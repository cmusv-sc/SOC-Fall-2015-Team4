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

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import models.User;
import models.metadata.ClimateService;
import play.Logger;
import play.data.DynamicForm;
import play.data.Form;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Result;
import util.APICall;
import util.APICall.ResponseType;
import views.html.climate.*;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class UserController extends Controller {


	final static Form<User> loginForm = Form.form(User.class);
	final static Form<User> RegisterForm = Form.form(User.class);

	public static Result login() {
		return ok(login.render(loginForm));
	}

	public static Result CheckUser() {
        Form<User> dc = loginForm.bindFromRequest();
        ObjectNode jsonData = Json.newObject();
        try {
            String userName = dc.field("userName").value();
            String password = dc.field("password").value();

            if (userName == null && userName.isEmpty() && password==null && password.isEmpty()) {
                return ok(login.render(loginForm));
            }

            jsonData.put("userName", dc.field("userName").value());
            jsonData.put("password", dc.field("password").value());
            JsonNode response = ClimateService.create(jsonData);
            Application.flashMsg(response);
        } catch (IllegalStateException e) {
            e.printStackTrace();
            Application.flashMsg(APICall.createResponse(APICall.ResponseType.CONVERSIONERROR));
        } catch (Exception e) {
            e.printStackTrace();
            Application.flashMsg(APICall.createResponse(APICall.ResponseType.UNKNOWN));
        }
        if (User.loginSuccess(jsonData))
            return redirect("/climate/mainpage");
        else
            return ok(login.render(loginForm));
	}

	public static Result register() {
        return ok(register.render(RegisterForm));
	}

    public static Result AddUser() {
        Form<User> dc = RegisterForm.bindFromRequest();
        ObjectNode jsonData = Json.newObject();
        String newUserName = dc.field("userName").value();

        if (newUserName != null && !newUserName.isEmpty()) {
            jsonData.put("userName", newUserName);
        }

        jsonData.put("firstName", dc.field("firstName").value());
        jsonData.put("lastName", dc.field("lastName").value());
        jsonData.put("email", dc.field("email").value());
        jsonData.put("password", dc.field("password").value());
        JsonNode response = ClimateService.create(jsonData);
        Application.flashMsg(response);

        if (User.registerSuccess(jsonData))
            return redirect("/climate/mainpage");
        else
            return ok(register.render(RegisterForm));
    }

    public static Result homepage() {
        return ok(homepage.render());
    }

    public static Result mainpage() {
        return ok(mainpage.render());
    }
}
