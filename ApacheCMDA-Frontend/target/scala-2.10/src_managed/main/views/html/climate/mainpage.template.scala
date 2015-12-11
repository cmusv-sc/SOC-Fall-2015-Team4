
package views.html.climate

import play.templates._
import play.templates.TemplateMagic._

import play.api.templates._
import play.api.templates.PlayMagic._
import models._
import controllers._
import java.lang._
import java.util._
import scala.collection.JavaConversions._
import scala.collection.JavaConverters._
import play.api.i18n._
import play.core.j.PlayMagicForJava._
import play.mvc._
import play.data._
import play.api.data.Field
import play.mvc.Http.Context.Implicit._
import views.html._
/*******************************************************************************
* Licensed to the Apache Software Foundation (ASF) under one or more		   *
* contributor license agreements.  See the NOTICE file distributed with	   *
* this work for additional information regarding copyright ownership.         *
* The ASF licenses this file to You under the Apache License, Version 2.0     *
* (the "License"); you may not use this file except in compliance with        *
* the License.  You may obtain a copy of the License at                       *
*                                                                             *
*    http://www.apache.org/licenses/LICENSE-2.0                               *
*																			   *
* Unless required by applicable law or agreed to in writing, software         *
* distributed under the License is distributed on an "AS IS" BASIS,           *
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    *
* See the License for the specific language governing permissions and         *
* limitations under the License.											   *
*******************************************************************************/
object mainpage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template7[List[models.Post],play.data.Form[models.Post],play.data.Form[models.Comment],models.User,List[models.User],List[models.User],List[models.User],play.api.templates.HtmlFormat.Appendable] {

    /*******************************************************************************
* Licensed to the Apache Software Foundation (ASF) under one or more		   *
* contributor license agreements.  See the NOTICE file distributed with	   *
* this work for additional information regarding copyright ownership.         *
* The ASF licenses this file to You under the Apache License, Version 2.0     *
* (the "License"); you may not use this file except in compliance with        *
* the License.  You may obtain a copy of the License at                       *
*                                                                             *
*    http://www.apache.org/licenses/LICENSE-2.0                               *
*																			   *
* Unless required by applicable law or agreed to in writing, software         *
* distributed under the License is distributed on an "AS IS" BASIS,           *
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.    *
* See the License for the specific language governing permissions and         *
* limitations under the License.											   *
*******************************************************************************/
    def apply/*17.2*/(postServices: List[models.Post],
  postForm: play.data.Form[models.Post],
  commentForm: play.data.Form[models.Comment],
  user:models.User,
  searchUserResult: List[models.User],
  followees: List[models.User],
  followers: List[models.User]
  ):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*24.4*/("""
<script type="text/javascript">

    function likePost(postId)"""),format.raw/*27.30*/("""{"""),format.raw/*27.31*/("""
        var obj = """),format.raw/*28.19*/("""{"""),format.raw/*28.20*/("""
            postId : postId
        """),format.raw/*30.9*/("""}"""),format.raw/*30.10*/("""
        $.ajax("""),format.raw/*31.16*/("""{"""),format.raw/*31.17*/("""
            url: "/likePost",
            data: JSON.stringify(obj),
            headers: """),format.raw/*34.22*/("""{"""),format.raw/*34.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*36.13*/("""}"""),format.raw/*36.14*/(""",
            type: "POST"
        """),format.raw/*38.9*/("""}"""),format.raw/*38.10*/(""").done(function(data) """),format.raw/*38.32*/("""{"""),format.raw/*38.33*/("""
            var response = data;
            if("error" in response)"""),format.raw/*40.36*/("""{"""),format.raw/*40.37*/("""
                alert("like error!")
            """),format.raw/*42.13*/("""}"""),format.raw/*42.14*/("""else"""),format.raw/*42.18*/("""{"""),format.raw/*42.19*/("""
                window.location.reload();
            """),format.raw/*44.13*/("""}"""),format.raw/*44.14*/("""
        """),format.raw/*45.9*/("""}"""),format.raw/*45.10*/(""");
    """),format.raw/*46.5*/("""}"""),format.raw/*46.6*/("""

    function searchUser()"""),format.raw/*48.26*/("""{"""),format.raw/*48.27*/("""
        var obj = """),format.raw/*49.19*/("""{"""),format.raw/*49.20*/("""
            userKeyword : document.getElementById("userKeyword").value
        """),format.raw/*51.9*/("""}"""),format.raw/*51.10*/("""
        $.ajax("""),format.raw/*52.16*/("""{"""),format.raw/*52.17*/("""
            url: "/searchUser",
            data: JSON.stringify(obj),
            headers: """),format.raw/*55.22*/("""{"""),format.raw/*55.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*57.13*/("""}"""),format.raw/*57.14*/(""",
            type: "POST"
        """),format.raw/*59.9*/("""}"""),format.raw/*59.10*/(""").done(function(data) """),format.raw/*59.32*/("""{"""),format.raw/*59.33*/("""
            var response = data;
            if("error" in response)"""),format.raw/*61.36*/("""{"""),format.raw/*61.37*/("""
                alert("like error!")
            """),format.raw/*63.13*/("""}"""),format.raw/*63.14*/("""else"""),format.raw/*63.18*/("""{"""),format.raw/*63.19*/("""
                window.location.reload();
            """),format.raw/*65.13*/("""}"""),format.raw/*65.14*/("""
        """),format.raw/*66.9*/("""}"""),format.raw/*66.10*/(""");
    """),format.raw/*67.5*/("""}"""),format.raw/*67.6*/("""

    function sharePost(postId)"""),format.raw/*69.31*/("""{"""),format.raw/*69.32*/("""
        var obj = """),format.raw/*70.19*/("""{"""),format.raw/*70.20*/("""
            postId : postId,
            postUserId : document.getElementById("inputUserId").value,
            postUserFirstName : document.getElementById("inputUserFirstName").value,
            postUserLastName : document.getElementById("inputUserLastName").value,
        """),format.raw/*75.9*/("""}"""),format.raw/*75.10*/("""
        $.ajax("""),format.raw/*76.16*/("""{"""),format.raw/*76.17*/("""
            url: "/sharePost",
            data: JSON.stringify(obj),
            headers: """),format.raw/*79.22*/("""{"""),format.raw/*79.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*81.13*/("""}"""),format.raw/*81.14*/(""",
            type: "POST"
        """),format.raw/*83.9*/("""}"""),format.raw/*83.10*/(""").done(function(data) """),format.raw/*83.32*/("""{"""),format.raw/*83.33*/("""
			       window.location.reload();
        """),format.raw/*85.9*/("""}"""),format.raw/*85.10*/(""");
    """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/("""

    function visitFollowee(followeeId)"""),format.raw/*88.39*/("""{"""),format.raw/*88.40*/("""
       alert(followeeId);
        var obj = """),format.raw/*90.19*/("""{"""),format.raw/*90.20*/("""
            followeeId : followeeId,
        """),format.raw/*92.9*/("""}"""),format.raw/*92.10*/("""
        $.ajax("""),format.raw/*93.16*/("""{"""),format.raw/*93.17*/("""
            url: "/visitFollowee",
            data: JSON.stringify(obj),
            headers: """),format.raw/*96.22*/("""{"""),format.raw/*96.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*98.13*/("""}"""),format.raw/*98.14*/(""",
            type: "POST"
        """),format.raw/*100.9*/("""}"""),format.raw/*100.10*/(""").done(function(data) """),format.raw/*100.32*/("""{"""),format.raw/*100.33*/("""
             //window.location.reload();
        """),format.raw/*102.9*/("""}"""),format.raw/*102.10*/(""");
        //window.location.reload();
    """),format.raw/*104.5*/("""}"""),format.raw/*104.6*/("""

    function searchUser()"""),format.raw/*106.26*/("""{"""),format.raw/*106.27*/("""
            var obj = """),format.raw/*107.23*/("""{"""),format.raw/*107.24*/("""
                userKeyword : document.getElementById("userKeyword").value
            """),format.raw/*109.13*/("""}"""),format.raw/*109.14*/("""
            $.ajax("""),format.raw/*110.20*/("""{"""),format.raw/*110.21*/("""
                url: "/searchUser",
                data: JSON.stringify(obj),
                headers: """),format.raw/*113.26*/("""{"""),format.raw/*113.27*/("""
                    'Content-Type': 'application/json'
                """),format.raw/*115.17*/("""}"""),format.raw/*115.18*/(""",
                type: "POST"
            """),format.raw/*117.13*/("""}"""),format.raw/*117.14*/(""").done(function(data) """),format.raw/*117.36*/("""{"""),format.raw/*117.37*/("""
                    window.location.reload();
            """),format.raw/*119.13*/("""}"""),format.raw/*119.14*/(""");
        """),format.raw/*120.9*/("""}"""),format.raw/*120.10*/("""

    function searchPost()"""),format.raw/*122.26*/("""{"""),format.raw/*122.27*/("""
            var obj = """),format.raw/*123.23*/("""{"""),format.raw/*123.24*/("""
                postKeyword : document.getElementById("postKeyword").value
            """),format.raw/*125.13*/("""}"""),format.raw/*125.14*/("""
            $.ajax("""),format.raw/*126.20*/("""{"""),format.raw/*126.21*/("""
                url: "/searchPost",
                data: JSON.stringify(obj),
                headers: """),format.raw/*129.26*/("""{"""),format.raw/*129.27*/("""
                    'Content-Type': 'application/json'
                """),format.raw/*131.17*/("""}"""),format.raw/*131.18*/(""",
                type: "POST"
             """),format.raw/*133.14*/("""}"""),format.raw/*133.15*/(""").done(function(data) """),format.raw/*133.37*/("""{"""),format.raw/*133.38*/("""
                    window.location.reload();
             """),format.raw/*135.14*/("""}"""),format.raw/*135.15*/(""");
    """),format.raw/*136.5*/("""}"""),format.raw/*136.6*/("""

    function goBack() """),format.raw/*138.23*/("""{"""),format.raw/*138.24*/("""
            $.ajax("""),format.raw/*139.20*/("""{"""),format.raw/*139.21*/("""
              url: "/goBack",
              type: "POST"
            """),format.raw/*142.13*/("""}"""),format.raw/*142.14*/(""").done(function(data) """),format.raw/*142.36*/("""{"""),format.raw/*142.37*/("""
              window.location.reload();
            """),format.raw/*144.13*/("""}"""),format.raw/*144.14*/(""");
          """),format.raw/*145.11*/("""}"""),format.raw/*145.12*/("""

    function commentPost(postId)"""),format.raw/*147.33*/("""{"""),format.raw/*147.34*/("""
        var commentBox = $('#commentBox'+postId);
        if (commentBox.css("display") == "none") """),format.raw/*149.50*/("""{"""),format.raw/*149.51*/("""
            commentBox.show();
            $.get("/allComment/"+postId, function(data)"""),format.raw/*151.56*/("""{"""),format.raw/*151.57*/("""
                $("#comment"+postId).empty();

                var commentServices = data;
                if("error" in commentServices) return;
                for (cid in commentServices) """),format.raw/*156.46*/("""{"""),format.raw/*156.47*/("""
                var json = commentServices[cid];
                var html = "<li><h6>"+json["time"]+"</h6>&nbsp;&nbsp;" +
                       json["commentUserFirstName"] + "&nbsp;"+ json["commentUserLastName"]
                       +"</a>&nbsp;replied:&nbsp;"+json["text"]+"</li>";
                $("#comment"+postId).append(html);
                """),format.raw/*162.17*/("""}"""),format.raw/*162.18*/("""
              """),format.raw/*163.15*/("""}"""),format.raw/*163.16*/(""");
          """),format.raw/*164.11*/("""}"""),format.raw/*164.12*/(""" else """),format.raw/*164.18*/("""{"""),format.raw/*164.19*/("""
          commentBox.hide();
      """),format.raw/*166.7*/("""}"""),format.raw/*166.8*/("""
    """),format.raw/*167.5*/("""}"""),format.raw/*167.6*/("""


    var la = NULL;
    var lt = NULL;

    function refreshLocation() """),format.raw/*173.32*/("""{"""),format.raw/*173.33*/("""
      if (navigator.geolocation) """),format.raw/*174.34*/("""{"""),format.raw/*174.35*/("""
          navigator.geolocation.getCurrentPosition(showPosition);
        """),format.raw/*176.9*/("""}"""),format.raw/*176.10*/("""
      """),format.raw/*177.7*/("""}"""),format.raw/*177.8*/("""

    function showPosition(position) """),format.raw/*179.37*/("""{"""),format.raw/*179.38*/("""
      la = position.coords.latitude;
      lt = position.coords.longitude;
      alert("Location Refreshed!");
      var obj = """),format.raw/*183.17*/("""{"""),format.raw/*183.18*/("""
          latitude : la,
          longtitude : lt,
      """),format.raw/*186.7*/("""}"""),format.raw/*186.8*/("""
      $.ajax("""),format.raw/*187.14*/("""{"""),format.raw/*187.15*/("""
          url: "/sendLocation",
          data: JSON.stringify(obj),
          headers: """),format.raw/*190.20*/("""{"""),format.raw/*190.21*/("""
              'Content-Type': 'application/json'
          """),format.raw/*192.11*/("""}"""),format.raw/*192.12*/(""",
          type: "POST"
       """),format.raw/*194.8*/("""}"""),format.raw/*194.9*/(""").done(function(data) """),format.raw/*194.31*/("""{"""),format.raw/*194.32*/("""
              window.location.reload();
       """),format.raw/*196.8*/("""}"""),format.raw/*196.9*/(""");

    """),format.raw/*198.5*/("""}"""),format.raw/*198.6*/("""


</script>
"""),format.raw/*203.1*/("""
"""),_display_(Seq[Any](/*204.2*/self("Main Page")/*204.19*/ {_display_(Seq[Any](format.raw/*204.21*/("""
<!--Navigation bar (Cite Bootstrap template)-->
<nav id="bar" class="navbar navbar-default navbar-fixed-top">
    <div class="container-fluid">
    <!-- Brand and toggle get grouped once screen zoom out -->
    <div class="navbar-header">
        <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
        <img alt="Logo" class="navbar-brand" src="/assets/image/logo.png">
    </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav nav-pills navbar-left">
            <li  class="nav-btn"><a href="mainpage"><span class="glyphicon glyphicon-home"></span> Home</a></li>
            """),_display_(Seq[Any](/*222.14*/if(!session.get("email"))/*222.39*/ {_display_(Seq[Any](format.raw/*222.41*/("""
            <form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*223.61*/routes/*223.67*/.Application.login())),format.raw/*223.87*/("""">
                <button type="submit" class="btn btn-success">Log in</button>
            </form>
            """)))}/*226.15*/else/*226.20*/{_display_(Seq[Any](format.raw/*226.21*/("""
            <li id="drop" class="dropdown nav-btn"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <span class="glyphicon glyphicon-user"></span> My Account<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href=""""),_display_(Seq[Any](/*230.35*/routes/*230.41*/.Application.logout())),format.raw/*230.62*/("""">Log out</a></li>
                </ul>
            </li>
            """)))})),format.raw/*233.14*/("""
        </ul>

        <div class="navbar-form navbar-right">
            <input type="text" id="userKeyword" class="form-control" placeholder="Search user">
            <button type="button" onclick="searchUser()" class="btn btn-default">Search User!</button>
            <button type="button" onclick="goBack()" class="btn btn-default">Go Back!</button>
        </div>

        <div class="navbar-form navbar-right">
            <input type="text" id="postKeyword" class="form-control" placeholder="Search Post!">
            <button type="button" onclick="searchPost()" class="btn btn-default">Search Post!</button>
        </div>

        <div class="navbar-form navbar-left">
        <form id="getFolloweeform" action = "/visitFollowee" method="POST">
            <button type="submit" class="btn btn-success">My Profile</button>
            <input id="followeeId" name="followeeId" type="hidden" value=""""),_display_(Seq[Any](/*250.76*/session/*250.83*/.get("userId"))),format.raw/*250.97*/(""""></input>
        </form>
        </div>

        <div class="navbar-form navbar-left">
            <button type="submit" class="btn btn-success" onclick="refreshLocation()">Refresh Location</button>
        </div>

        </div><!--/navbar-collapse-->
    </div><!--/container-fluid-->
</nav>
"""),_display_(Seq[Any](/*261.2*/helper/*261.8*/.form(action = routes.UserController.addPost)/*261.53*/ {_display_(Seq[Any](format.raw/*261.55*/("""
<!-- Post board & Personal information -->
<div id="medium" class="row">
    <div id="right" class="col-md-3 col-md-offset-1">
        <div id="profile">
        <img id="photo" src="/assets/image/default.jpg" class="img-circle center-block" alt="photo">

        <p class="text-center" ><strong><font color="black">"""),_display_(Seq[Any](/*268.62*/session/*268.69*/.get("firstName"))),format.raw/*268.86*/(""" """),_display_(Seq[Any](/*268.88*/session/*268.95*/.get("lastName"))),format.raw/*268.111*/("""</font></strong></p>
          <p class="text-center" ><strong><font color="black">"""),_display_(Seq[Any](/*269.64*/session/*269.71*/.get("email"))),format.raw/*269.84*/("""</font></strong></p>
        </div>
    </div>
    <div id="left" class="col-md-7">
        <div id="post-board">
            <p id="prompt"><strong>Post a new message</strong></p>
            <p id="less" class="text-right"><small>#Limited 100 characters#</small></p>
            <form>
                <input class="form-control" type="text" id="focusedInput" name="text" placeholder="What's on your mind?" required=""
                       value='"""),_display_(Seq[Any](/*278.32*/postForm("text")/*278.48*/.value)),format.raw/*278.54*/("""'>
                <input class="form-control" type="hidden" name="postUserId" id="inputUserId" value=""""),_display_(Seq[Any](/*279.102*/session/*279.109*/.get("userId"))),format.raw/*279.123*/("""">
                <input class="form-control" type="hidden" name="postUserFirstName" id="inputUserFirstName" value=""""),_display_(Seq[Any](/*280.116*/session/*280.123*/.get("firstName"))),format.raw/*280.140*/("""">
                <input class="form-control" type="hidden" name="postUserLastName" id="inputUserLastName" value=""""),_display_(Seq[Any](/*281.114*/session/*281.121*/.get("lastName"))),format.raw/*281.137*/("""">
                <ul class="nav nav-pills">
                <li role="presentation"><a href="#"><span class="glyphicon glyphicon-map-marker"></span></a></li>
                <li role="presentation">
                    <input type="radio" name="visibility" value="public" checked> Public
                    <input type="radio" name="visibility" value="private"> Private
                    <p class="error" style="color: red;"></p>
                </li>
                <li role="presentation">
                    <input type="radio" name="shareLocation" value="share" checked> Share Location
                    <input type="radio" name="shareLocation" value="hide"> Do Not Share Location
                    <p class="error" style="color: red;"></p>
                </li>
                </ul>
                <button id="post-btn" type="submit" class="btn btn-danger pull-right">Post</button>
            </form>
        </div>
    </div>
</div><!--/medium-->
""")))})),format.raw/*300.2*/("""

<div id="content" class="row">
<!--Right-->
    <div id="rightcontent" class="col-md-3  col-md-offset-1">
    <div id="sidebar"><br/>
    <!-- Hot Topic -->

    <div id="followeeList" class="friends-list">
        <table class="table table-hover text-center">
            <caption class="text-center"><strong>Followees</strong></caption>
            """),_display_(Seq[Any](/*311.14*/for(followee <- followees) yield /*311.40*/{_display_(Seq[Any](format.raw/*311.41*/("""
                  <tr>
                    <form id="getFolloweeform"""),_display_(Seq[Any](/*313.47*/followee/*313.55*/.getId())),format.raw/*313.63*/("""" action = "/visitFollowee" method="POST">
                        <td><img src="/assets/image/2.jpg" alt="friends-list" class="img-circle friends-photo"></td>
                        <td><a href="#" onclick="document.getElementById('getFolloweeform"""),_display_(Seq[Any](/*315.91*/followee/*315.99*/.getId())),format.raw/*315.107*/("""').submit();">"""),_display_(Seq[Any](/*315.122*/followee/*315.130*/.getFirstName)),format.raw/*315.143*/(""" """),_display_(Seq[Any](/*315.145*/followee/*315.153*/.getLastName)),format.raw/*315.165*/("""</a></td>
                        <td><input id="followeeId" name="followeeId" type="hidden" value=""""),_display_(Seq[Any](/*316.92*/followee/*316.100*/.getId)),format.raw/*316.106*/(""""></input></td>
                    </form>
                  </tr>
              """)))})),format.raw/*319.16*/("""

        </table>
    </div><!--/friend-list-->

    <div class="line"></div><br/>

    <div id="followerList" class="friends-list">
        <table class="table table-hover text-center">
            <caption class="text-center"><strong>Followers</strong></caption>
            """),_display_(Seq[Any](/*329.14*/for(follower <- followers) yield /*329.40*/{_display_(Seq[Any](format.raw/*329.41*/("""
                  <tr>
                    <form id="getFollowerform"""),_display_(Seq[Any](/*331.47*/follower/*331.55*/.getId())),format.raw/*331.63*/("""" action = "/visitFollowee" method="POST">
                        <td><img src="/assets/image/2.jpg" alt="friends-list" class="img-circle friends-photo"></td>
                        <td><a href="#" onclick="document.getElementById('getFollowerform"""),_display_(Seq[Any](/*333.91*/follower/*333.99*/.getId())),format.raw/*333.107*/("""').submit();">"""),_display_(Seq[Any](/*333.122*/follower/*333.130*/.getFirstName)),format.raw/*333.143*/(""" """),_display_(Seq[Any](/*333.145*/follower/*333.153*/.getLastName)),format.raw/*333.165*/("""</a></td>
                        <td><input id="followeeId" name="followeeId" type="hidden" value=""""),_display_(Seq[Any](/*334.92*/follower/*334.100*/.getId())),format.raw/*334.108*/(""""></input></td>
                    </form>
                  </tr>
              """)))})),format.raw/*337.16*/("""

        </table>
    </div><!--/friend-list-->

    <form action = "/getMoreAllPost" method="POST">
        <button type="submit" class="btn btn-success">Click Here To Show More Posts!</button>
    </form>

    <form action = "/getLessAllPost" method="POST">
        <button type="submit" class="btn btn-success">Click Here To Show Less Posts!</button>
    </form>

    </div><!--/sidebar-->
    </div><!--/rightcontent-->

    <div id="leftcontent" class="col-md-7">
    <!-- Dashboard -->
    <div id="stream-list">
        """),_display_(Seq[Any](/*356.10*/for(postService <- postServices) yield /*356.42*/{_display_(Seq[Any](format.raw/*356.43*/("""
        <div class="soc-box">
            <div class="soc">

              <form id="getPostUser"""),_display_(Seq[Any](/*360.37*/postService/*360.48*/.getId())),format.raw/*360.56*/("""" action = "/visitFollowee" method="POST">
                <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
                <a href="#" onclick="document.getElementById('getPostUser"""),_display_(Seq[Any](/*362.75*/postService/*362.86*/.getId())),format.raw/*362.94*/("""').submit();">"""),_display_(Seq[Any](/*362.109*/postService/*362.120*/.getPostUserFirstName())),format.raw/*362.143*/(""" """),_display_(Seq[Any](/*362.145*/postService/*362.156*/.getPostUserLastName())),format.raw/*362.178*/("""</a>
                <input id="followeeId" name="followeeId" type="hidden" value=""""),_display_(Seq[Any](/*363.80*/postService/*363.91*/.getPostUserId())),format.raw/*363.107*/(""""></input>
              </form>

            </div>
            <div class="post-time text-right">
                <h6><span class="glyphicon glyphicon-time"></span> """),_display_(Seq[Any](/*368.69*/postService/*368.80*/.getTime())),format.raw/*368.90*/("""</h6>
                <h6><span class="glyphicon"></span>"""),_display_(Seq[Any](/*369.53*/postService/*369.64*/.getLocation())),format.raw/*369.78*/("""</h6>
            </div>

            <p class="post-text">"""),_display_(Seq[Any](/*372.35*/postService/*372.46*/.getText())),format.raw/*372.56*/("""</p>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="button" onclick="sharePost("""),_display_(Seq[Any](/*375.63*/postService/*375.74*/.getId())),format.raw/*375.82*/(""")" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share </small></button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" type="button" onclick="commentPost("""),_display_(Seq[Any](/*378.79*/postService/*378.90*/.getId())),format.raw/*378.98*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Reply </small></button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" onclick="likePost("""),_display_(Seq[Any](/*381.62*/postService/*381.73*/.getId())),format.raw/*381.81*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-heart"></span><small> Like : """),_display_(Seq[Any](/*381.171*/postService/*381.182*/.getLikes())),format.raw/*381.193*/("""</small></button>
                </div>
            </div>

            <div class="comment-box" style="display:none;" id="commentBox"""),_display_(Seq[Any](/*385.75*/postService/*385.86*/.getId())),format.raw/*385.94*/("""">
                <div class="comment">
                    <ol class="list-unstyled" id="comment"""),_display_(Seq[Any](/*387.59*/postService/*387.70*/.getId())),format.raw/*387.78*/("""">
                    </ol>
                </div>

                """),_display_(Seq[Any](/*391.18*/helper/*391.24*/.form(action = routes.UserController.addComment)/*391.72*/ {_display_(Seq[Any](format.raw/*391.74*/("""
                    <form id="form"""),_display_(Seq[Any](/*392.36*/postService/*392.47*/.getId())),format.raw/*392.55*/("""" method="post">
                        <input type="hidden" name="postId" id="postId" value=""""),_display_(Seq[Any](/*393.80*/postService/*393.91*/.getId())),format.raw/*393.99*/("""">
                        <input class="form-control" type="hidden" name="commentUserId" id="commentUserId" value=""""),_display_(Seq[Any](/*394.115*/session/*394.122*/.get("userId"))),format.raw/*394.136*/("""">
                        <input type="text" class="form-control" placeholder="Type Your comment" name="text">
                        <button type="submit" class="btn btn-info pull-right submitBtn btn-xs">Submit</button>
                    </form>
                """)))})),format.raw/*398.18*/("""
            </div>
        </div>
        <br>
        """)))})),format.raw/*402.10*/("""

        """),_display_(Seq[Any](/*404.10*/for(sUser <- searchUserResult) yield /*404.40*/{_display_(Seq[Any](format.raw/*404.41*/("""
            <div class="soc-box">
              <div class="soc">

                <form id="getSearched"""),_display_(Seq[Any](/*408.39*/sUser/*408.44*/.getId())),format.raw/*408.52*/("""" action = "/visitFollowee" method="POST">
                  <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
                  <a href="#" onclick="document.getElementById('getSearched"""),_display_(Seq[Any](/*410.77*/sUser/*410.82*/.getId())),format.raw/*410.90*/("""').submit();">"""),_display_(Seq[Any](/*410.105*/sUser/*410.110*/.getUserName)),format.raw/*410.122*/("""</a>
                  <input id="followeeId" name="followeeId" type="hidden" value=""""),_display_(Seq[Any](/*411.82*/sUser/*411.87*/.getId())),format.raw/*411.95*/(""""></input>
                </form>

              </div>
            </div>


          """)))})),format.raw/*418.12*/("""
    </div><!--leftcontent-->
</div><!--Content-->
""")))})),format.raw/*421.2*/("""
"""))}
    }
    
    def render(postServices:List[models.Post],postForm:play.data.Form[models.Post],commentForm:play.data.Form[models.Comment],user:models.User,searchUserResult:List[models.User],followees:List[models.User],followers:List[models.User]): play.api.templates.HtmlFormat.Appendable = apply(postServices,postForm,commentForm,user,searchUserResult,followees,followers)
    
    def f:((List[models.Post],play.data.Form[models.Post],play.data.Form[models.Comment],models.User,List[models.User],List[models.User],List[models.User]) => play.api.templates.HtmlFormat.Appendable) = (postServices,postForm,commentForm,user,searchUserResult,followees,followers) => apply(postServices,postForm,commentForm,user,searchUserResult,followees,followers)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 11 00:10:23 EST 2015
                    SOURCE: /Users/X/Desktop/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/mainpage.scala.html
                    HASH: 5b8a94ffca11bb0afb4ecf83a2a26dda61ef490f
                    MATRIX: 3286->1188|3643->1435|3734->1498|3763->1499|3810->1518|3839->1519|3903->1556|3932->1557|3976->1573|4005->1574|4124->1665|4153->1666|4245->1730|4274->1731|4336->1766|4365->1767|4415->1789|4444->1790|4541->1859|4570->1860|4648->1910|4677->1911|4709->1915|4738->1916|4821->1971|4850->1972|4886->1981|4915->1982|4949->1989|4977->1990|5032->2017|5061->2018|5108->2037|5137->2038|5244->2118|5273->2119|5317->2135|5346->2136|5467->2229|5496->2230|5588->2294|5617->2295|5679->2330|5708->2331|5758->2353|5787->2354|5884->2423|5913->2424|5991->2474|6020->2475|6052->2479|6081->2480|6164->2535|6193->2536|6229->2545|6258->2546|6292->2553|6320->2554|6380->2586|6409->2587|6456->2606|6485->2607|6789->2884|6818->2885|6862->2901|6891->2902|7011->2994|7040->2995|7132->3059|7161->3060|7223->3095|7252->3096|7302->3118|7331->3119|7403->3164|7432->3165|7466->3172|7494->3173|7562->3213|7591->3214|7664->3259|7693->3260|7766->3306|7795->3307|7839->3323|7868->3324|7992->3420|8021->3421|8113->3485|8142->3486|8205->3521|8235->3522|8286->3544|8316->3545|8394->3595|8424->3596|8495->3639|8524->3640|8580->3667|8610->3668|8662->3691|8692->3692|8809->3780|8839->3781|8888->3801|8918->3802|9052->3907|9082->3908|9183->3980|9213->3981|9285->4024|9315->4025|9366->4047|9396->4048|9484->4107|9514->4108|9553->4119|9583->4120|9639->4147|9669->4148|9721->4171|9751->4172|9868->4260|9898->4261|9947->4281|9977->4282|10111->4387|10141->4388|10242->4460|10272->4461|10345->4505|10375->4506|10426->4528|10456->4529|10545->4589|10575->4590|10610->4597|10639->4598|10692->4622|10722->4623|10771->4643|10801->4644|10900->4714|10930->4715|10981->4737|11011->4738|11093->4791|11123->4792|11165->4805|11195->4806|11258->4840|11288->4841|11417->4941|11447->4942|11563->5029|11593->5030|11814->5222|11844->5223|12228->5578|12258->5579|12302->5594|12332->5595|12374->5608|12404->5609|12439->5615|12469->5616|12533->5652|12562->5653|12595->5658|12624->5659|12726->5732|12756->5733|12819->5767|12849->5768|12952->5843|12982->5844|13017->5851|13046->5852|13113->5890|13143->5891|13300->6019|13330->6020|13417->6079|13446->6080|13489->6094|13519->6095|13637->6184|13667->6185|13756->6245|13786->6246|13846->6278|13875->6279|13926->6301|13956->6302|14032->6350|14061->6351|14097->6359|14126->6360|14167->6390|14205->6392|14232->6409|14273->6411|15297->7398|15332->7423|15373->7425|15471->7486|15487->7492|15530->7512|15664->7627|15678->7632|15718->7633|16049->7927|16065->7933|16109->7954|16214->8026|17162->8937|17179->8944|17216->8958|17549->9255|17564->9261|17619->9306|17660->9308|18015->9626|18032->9633|18072->9650|18111->9652|18128->9659|18168->9675|18289->9759|18306->9766|18342->9779|18831->10231|18857->10247|18886->10253|19028->10357|19046->10364|19084->10378|19240->10496|19258->10503|19299->10520|19453->10636|19471->10643|19511->10659|20511->11627|20902->11981|20945->12007|20985->12008|21092->12078|21110->12086|21141->12094|21428->12344|21446->12352|21478->12360|21531->12375|21550->12383|21587->12396|21627->12398|21646->12406|21682->12418|21820->12519|21839->12527|21869->12533|21985->12616|22301->12895|22344->12921|22384->12922|22491->12992|22509->13000|22540->13008|22827->13258|22845->13266|22877->13274|22930->13289|22949->13297|22986->13310|23026->13312|23045->13320|23081->13332|23219->13433|23238->13441|23270->13449|23386->13532|23952->14061|24001->14093|24041->14094|24176->14192|24197->14203|24228->14211|24480->14426|24501->14437|24532->14445|24585->14460|24607->14471|24654->14494|24694->14496|24716->14507|24762->14529|24883->14613|24904->14624|24944->14640|25149->14808|25170->14819|25203->14829|25298->14887|25319->14898|25356->14912|25453->14972|25474->14983|25507->14993|25750->15199|25771->15210|25802->15218|26102->15481|26123->15492|26154->15500|26437->15746|26458->15757|26489->15765|26617->15855|26639->15866|26674->15877|26846->16012|26867->16023|26898->16031|27034->16130|27055->16141|27086->16149|27193->16219|27209->16225|27267->16273|27308->16275|27381->16311|27402->16322|27433->16330|27566->16426|27587->16437|27618->16445|27773->16562|27791->16569|27829->16583|28130->16851|28220->16908|28268->16919|28315->16949|28355->16950|28498->17056|28513->17061|28544->17069|28800->17288|28815->17293|28846->17301|28899->17316|28915->17321|28951->17333|29074->17419|29089->17424|29120->17432|29242->17521|29326->17573
                    LINES: 56->17|67->24|70->27|70->27|71->28|71->28|73->30|73->30|74->31|74->31|77->34|77->34|79->36|79->36|81->38|81->38|81->38|81->38|83->40|83->40|85->42|85->42|85->42|85->42|87->44|87->44|88->45|88->45|89->46|89->46|91->48|91->48|92->49|92->49|94->51|94->51|95->52|95->52|98->55|98->55|100->57|100->57|102->59|102->59|102->59|102->59|104->61|104->61|106->63|106->63|106->63|106->63|108->65|108->65|109->66|109->66|110->67|110->67|112->69|112->69|113->70|113->70|118->75|118->75|119->76|119->76|122->79|122->79|124->81|124->81|126->83|126->83|126->83|126->83|128->85|128->85|129->86|129->86|131->88|131->88|133->90|133->90|135->92|135->92|136->93|136->93|139->96|139->96|141->98|141->98|143->100|143->100|143->100|143->100|145->102|145->102|147->104|147->104|149->106|149->106|150->107|150->107|152->109|152->109|153->110|153->110|156->113|156->113|158->115|158->115|160->117|160->117|160->117|160->117|162->119|162->119|163->120|163->120|165->122|165->122|166->123|166->123|168->125|168->125|169->126|169->126|172->129|172->129|174->131|174->131|176->133|176->133|176->133|176->133|178->135|178->135|179->136|179->136|181->138|181->138|182->139|182->139|185->142|185->142|185->142|185->142|187->144|187->144|188->145|188->145|190->147|190->147|192->149|192->149|194->151|194->151|199->156|199->156|205->162|205->162|206->163|206->163|207->164|207->164|207->164|207->164|209->166|209->166|210->167|210->167|216->173|216->173|217->174|217->174|219->176|219->176|220->177|220->177|222->179|222->179|226->183|226->183|229->186|229->186|230->187|230->187|233->190|233->190|235->192|235->192|237->194|237->194|237->194|237->194|239->196|239->196|241->198|241->198|245->203|246->204|246->204|246->204|264->222|264->222|264->222|265->223|265->223|265->223|268->226|268->226|268->226|272->230|272->230|272->230|275->233|292->250|292->250|292->250|303->261|303->261|303->261|303->261|310->268|310->268|310->268|310->268|310->268|310->268|311->269|311->269|311->269|320->278|320->278|320->278|321->279|321->279|321->279|322->280|322->280|322->280|323->281|323->281|323->281|342->300|353->311|353->311|353->311|355->313|355->313|355->313|357->315|357->315|357->315|357->315|357->315|357->315|357->315|357->315|357->315|358->316|358->316|358->316|361->319|371->329|371->329|371->329|373->331|373->331|373->331|375->333|375->333|375->333|375->333|375->333|375->333|375->333|375->333|375->333|376->334|376->334|376->334|379->337|398->356|398->356|398->356|402->360|402->360|402->360|404->362|404->362|404->362|404->362|404->362|404->362|404->362|404->362|404->362|405->363|405->363|405->363|410->368|410->368|410->368|411->369|411->369|411->369|414->372|414->372|414->372|417->375|417->375|417->375|420->378|420->378|420->378|423->381|423->381|423->381|423->381|423->381|423->381|427->385|427->385|427->385|429->387|429->387|429->387|433->391|433->391|433->391|433->391|434->392|434->392|434->392|435->393|435->393|435->393|436->394|436->394|436->394|440->398|444->402|446->404|446->404|446->404|450->408|450->408|450->408|452->410|452->410|452->410|452->410|452->410|452->410|453->411|453->411|453->411|460->418|463->421
                    -- GENERATED --
                */
            