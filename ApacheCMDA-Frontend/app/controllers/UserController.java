/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package controllers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.*;
import java.net.URLEncoder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import models.Post;
import models.Comment;
import models.User;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import models.metadata.ClimateService;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.*;
import util.Constants;
import util.APICall;
import util.APICall.ResponseType;
import views.html.climate.*;

public class UserController extends Controller {
    final static Form<Post> postForm = Form.form(Post.class);
    final static Form<Comment> commentForm = Form.form(Comment.class);
    final static Form<User> userForm = Form.form(User.class);

    public static Result homepage() {
        return ok(homepage.render(allSelfPost(),commentForm,userInfo()));
    }

    public static Result mainpage() {
        return ok(mainpage.render(allPost(),postForm,commentForm));
    }

    public static Result addPost() {
    Form<Post> np = postForm.bindFromRequest();
    ObjectNode jsonData = Json.newObject();

        try{
            jsonData.put("text", np.field("text").value());
            jsonData.put("visibility", np.field("visibility").value());
            jsonData.put("likes", "0");
            jsonData.put("location", "pittsburgh");
            jsonData.put("share", "0");
            jsonData.put("time","0");
            jsonData.put("postUserId", np.field("postUserId").value());
            jsonData.put("postUserFirstName",np.field("postUserFirstName").value());
            jsonData.put("postUserLastName",np.field("postUserLastName").value());

            System.out.println(np.field("postUserLastName").value());
            JsonNode response = APICall.postAPI(Constants.URL_HOST + Constants.CMU_BACKEND_PORT
                    + Constants.ADD_POST, jsonData);
            Application.flashMsg(response);
        }catch (IllegalStateException e) {
            e.printStackTrace();
            Application.flashMsg(APICall
                    .createResponse(ResponseType.CONVERSIONERROR));
        } catch (Exception e) {
            e.printStackTrace();
            Application.flashMsg(APICall
                    .createResponse(ResponseType.UNKNOWN));
        }
        return redirect(routes.UserController.mainpage());
    }

    public static List<Post> allSelfPost() {

        List<Post> postServices = new ArrayList<Post>();

        JsonNode postServicesNode = APICall.callAPI(Constants.GET_HOMEPAGE_POST_CALL+session("userId")+"/json");

        if (postServicesNode == null || postServicesNode.has("error")
                || !postServicesNode.isArray()) {
            return postServices;
        }

        for (int i = 0; i < postServicesNode.size(); i++) {
            JsonNode json = postServicesNode.path(i);
            Post newPost = new Post();
            newPost.setId(json.path("id").asInt());
            newPost.setText(json.get("text").asText());
            newPost.setLikes(json.path("likes").asInt());
            newPost.setLocation(json.path("location").asText());
            newPost.setPostUserId(json.path("postUserId").asLong());
            newPost.setShare(json.path("share").asText());
            newPost.setVisibility(json.path("visibility").asText());
            newPost.setTime(json.path("time").asText());
            newPost.setPostUserFirstName(json.path("postUserFirstName").asText());
            newPost.setPostUserLastName(json.path("postUserLastName").asText());
            postServices.add(newPost);
        }
        return postServices;
    }

    public static List<Post> allPost() {

        List<Post> postServices = new ArrayList<Post>();

        JsonNode postServicesNode = APICall.callAPI(Constants.GET_MAINPAGE_POST_CALL+session("userId")+"/json");

        if (postServicesNode == null || postServicesNode.has("error")
                || !postServicesNode.isArray()) {
            return postServices;
        }

        for (int i = 0; i < postServicesNode.size(); i++) {
            JsonNode json = postServicesNode.path(i);
            Post newPost = new Post();
            newPost.setId(json.path("id").asInt());
            newPost.setText(json.get("text").asText());
            newPost.setLikes(json.path("likes").asInt());
            newPost.setLocation(json.path("location").asText());
            newPost.setPostUserId(json.path("postUserId").asLong());
            newPost.setShare(json.path("share").asText());
            newPost.setVisibility(json.path("visibility").asText());
            newPost.setTime(json.path("time").asText());
            newPost.setPostUserFirstName(json.path("postUserFirstName").asText());
            newPost.setPostUserLastName(json.path("postUserLastName").asText());
            postServices.add(newPost);
        }
        return postServices;
    }
    
    public static Result searchUser() throws UnsupportedEncodingException {
    	
    	List<Post> searchUserResult =new ArrayList<Post>();
    	
    	System.out.println("SearchUser Called!");
    	
        ObjectNode jsonData = Json.newObject();
        JsonNode json = request().body().asJson();

        System.out.println(json.path("userKeyword"));
        	
        jsonData.put("userKeyword", json.path("userKeyword"));

            
        System.out.println("Search UserRequest Sent");
        JsonNode response = APICall.postAPI(Constants.URL_HOST + Constants.CMU_BACKEND_PORT
                    + "/users/search", jsonData);
        System.out.println("Reponse Received");
        Application.flashMsg(response);
        System.out.println(response.size());
        JsonNode jsonResponse = response.path(0);
       // System.out.println(jsonResponse);
        System.out.println(jsonResponse.path("userName").asText());
        return redirect(routes.UserController.mainpage());
        
    }
    public static Result sharePost() throws UnsupportedEncodingException {
    	
    	System.out.println("Share Post Called!");
    	//Form<Post> np = postForm.bindFromRequest();
        ObjectNode jsonData = Json.newObject();
        JsonNode json = request().body().asJson();

        	System.out.println(json.path("postUserId"));
        	System.out.println(json.path("postUserLastName"));
            jsonData.put("text", "");
            jsonData.put("visibility", "public");
            jsonData.put("likes", "0");
            jsonData.put("location", "pittsburgh");
            jsonData.put("share", "0");
            jsonData.put("time","0");
            jsonData.put("postUserId", json.path("postUserId"));
            jsonData.put("postUserFirstName",json.path("postUserFirstName"));
            jsonData.put("postUserLastName",json.path("postUserLastName"));
            jsonData.put("origPostId", json.path("postId").asText());
            
            System.out.println("Request Sent");
            JsonNode response = APICall.postAPI(Constants.URL_HOST + Constants.CMU_BACKEND_PORT
                    + "/posts/share", jsonData);
            System.out.println("Reponse Received");
            Application.flashMsg(response);

//        return redirect(routes.UserController.mainpage());
        //    return ok(mainpage.render(allPost(),postForm));
            return ok(response);
    }
    

    public static Result deletePost() throws UnsupportedEncodingException {
        JsonNode json = request().body().asJson();
        String postId = json.path("postId").asText();
        System.out.print(Constants.DELETE_POST_CALL + URLEncoder.encode(postId, "UTF-8"));
        JsonNode response = APICall.deleteAPI(Constants.DELETE_POST_CALL + URLEncoder.encode(postId, "UTF-8"));
        Application.flashMsg(response);
        System.out.print(response);
        return ok(response);
    }

    public static Result likePost() throws UnsupportedEncodingException {
        JsonNode json = request().body().asJson();
        ObjectNode jsonData = Json.newObject();

        String postId = json.path("postId").asText();
        jsonData.put("id", postId);
        System.out.print(Constants.UPDATE_POST_LIKE_CALL + URLEncoder.encode(postId, "UTF-8"));
        JsonNode response = APICall.putAPI(Constants.UPDATE_POST_LIKE_CALL + URLEncoder.encode(postId, "UTF-8"), jsonData);
        Application.flashMsg(response);
        System.out.print(response);
        return ok(response);
    }



    public static Result addComment() {
        Form<Comment> np = commentForm.bindFromRequest();
        ObjectNode jsonData = Json.newObject();

        try{
            jsonData.put("text", np.field("text").value());
            jsonData.put("time","0");
            jsonData.put("postId", np.field("postId").value());
            jsonData.put("commentUserId", np.field("commentUserId").value());
            // 取消注释
//            jsonData.put("commentUserFirstName",np.field("commentUserFirstName").value());
//            jsonData.put("commentUserLastName",np.field("commentUserLastName").value());

            System.out.println(np.field("text").value());
            JsonNode response = APICall.postAPI(Constants.URL_HOST + Constants.CMU_BACKEND_PORT
                    + Constants.ADD_COMMENT, jsonData);
            System.out.println(response);
            Application.flashMsg(response);
        }catch (IllegalStateException e) {
            e.printStackTrace();
            Application.flashMsg(APICall
                    .createResponse(ResponseType.CONVERSIONERROR));
        } catch (Exception e) {
            e.printStackTrace();
            Application.flashMsg(APICall
                    .createResponse(ResponseType.UNKNOWN));
        }
        return redirect(routes.UserController.mainpage());
    }

    public static Result allComment(Long postId) {
        System.out.println(postId);
        String id = String.valueOf(postId);
        System.out.println(id);
        JsonNode commentServicesNode = APICall.callAPI(Constants.GET_COMMENT_CALL+id+"/json");
        System.out.println(commentServicesNode);
        return ok(commentServicesNode);
    }

    public static Result editProfile() {
        return ok(editProfile.render(userForm,userInfo()));
    }

    public static Result editUser(){
        Form<User> np = userForm.bindFromRequest();

        ObjectNode jsonData = Json.newObject();

        try{
            jsonData.put("affiliation", np.field("affiliation").value());
            jsonData.put("title", np.field("title").value());
            jsonData.put("mailingAddress", np.field("mailingAddress").value());
            jsonData.put("phoneNumber", np.field("phoneNumber").value());
            jsonData.put("faxNumber", np.field("faxNumber").value());
            jsonData.put("researchFields", np.field("researchFields").value());
            jsonData.put("highestDegree", np.field("highestDegree").value());
            JsonNode response = APICall.putAPI(Constants.URL_HOST + Constants.CMU_BACKEND_PORT
                    + Constants.Edit_USER+session("userId"), jsonData);

            // flash the response message
            Application.flashMsg(response);
            return redirect(routes.UserController.homepage());

        }catch (IllegalStateException e) {
            e.printStackTrace();
            Application.flashMsg(APICall
                    .createResponse(ResponseType.CONVERSIONERROR));
        } catch (Exception e) {
            e.printStackTrace();
            Application.flashMsg(APICall
                    .createResponse(ResponseType.UNKNOWN));
        }
        return redirect(routes.UserController.homepage());
    }

    public static User userInfo() {
        JsonNode userInformation =APICall.callAPI(Constants.GET_USER_INFO+session("userId"));
        if (userInformation == null || userInformation.has("error")) {
            return null;
        }
            User editUser = new User();
            editUser.setAffiliation(userInformation.path("affiliation").asText());
            editUser.setFaxNumber(userInformation.path("faxNumber").asText());
            editUser.setHighestDegree(userInformation.path("highestDegree").asText());
            editUser.setMailingAddress(userInformation.path("mailingAddress").asText());
            editUser.setPhoneNumber(userInformation.path("phoneNumber").asText());
            editUser.setTitle(userInformation.path("title").asText());
            editUser.setResearchFields(userInformation.path("researchFields").asText());
        return editUser;
    }
}
