
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
object mainpage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template5[List[models.Post],play.data.Form[models.Post],play.data.Form[models.Comment],models.User,List[models.User],play.api.templates.HtmlFormat.Appendable] {

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
  searchUserResult: List[models.User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*21.39*/("""
<script type="text/javascript">

    function likePost(postId)"""),format.raw/*24.30*/("""{"""),format.raw/*24.31*/("""
        var obj = """),format.raw/*25.19*/("""{"""),format.raw/*25.20*/("""
            postId : postId
        """),format.raw/*27.9*/("""}"""),format.raw/*27.10*/("""
        $.ajax("""),format.raw/*28.16*/("""{"""),format.raw/*28.17*/("""
            url: "/likePost",
            data: JSON.stringify(obj),
            headers: """),format.raw/*31.22*/("""{"""),format.raw/*31.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*33.13*/("""}"""),format.raw/*33.14*/(""",
            type: "POST"
        """),format.raw/*35.9*/("""}"""),format.raw/*35.10*/(""").done(function(data) """),format.raw/*35.32*/("""{"""),format.raw/*35.33*/("""
            var response = data;
            if("error" in response)"""),format.raw/*37.36*/("""{"""),format.raw/*37.37*/("""
                alert("like error!")
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""else"""),format.raw/*39.18*/("""{"""),format.raw/*39.19*/("""
                window.location.reload();
            """),format.raw/*41.13*/("""}"""),format.raw/*41.14*/("""
        """),format.raw/*42.9*/("""}"""),format.raw/*42.10*/(""");
    """),format.raw/*43.5*/("""}"""),format.raw/*43.6*/("""

    function searchUser()"""),format.raw/*45.26*/("""{"""),format.raw/*45.27*/("""
        var obj = """),format.raw/*46.19*/("""{"""),format.raw/*46.20*/("""
            userKeyword : document.getElementById("userKeyword").value
        """),format.raw/*48.9*/("""}"""),format.raw/*48.10*/("""
        $.ajax("""),format.raw/*49.16*/("""{"""),format.raw/*49.17*/("""
            url: "/searchUser",
            data: JSON.stringify(obj),
            headers: """),format.raw/*52.22*/("""{"""),format.raw/*52.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*54.13*/("""}"""),format.raw/*54.14*/(""",
            type: "POST"
        """),format.raw/*56.9*/("""}"""),format.raw/*56.10*/(""").done(function(data) """),format.raw/*56.32*/("""{"""),format.raw/*56.33*/("""
            var response = data;
            if("error" in response)"""),format.raw/*58.36*/("""{"""),format.raw/*58.37*/("""
                alert("like error!")
            """),format.raw/*60.13*/("""}"""),format.raw/*60.14*/("""else"""),format.raw/*60.18*/("""{"""),format.raw/*60.19*/("""
                window.location.reload();
            """),format.raw/*62.13*/("""}"""),format.raw/*62.14*/("""
        """),format.raw/*63.9*/("""}"""),format.raw/*63.10*/(""");
    """),format.raw/*64.5*/("""}"""),format.raw/*64.6*/("""

    function sharePost(postId)"""),format.raw/*66.31*/("""{"""),format.raw/*66.32*/("""
        var obj = """),format.raw/*67.19*/("""{"""),format.raw/*67.20*/("""
            postId : postId,
            postUserId : document.getElementById("inputUserId").value,
            postUserFirstName : document.getElementById("inputUserFirstName").value,
            postUserLastName : document.getElementById("inputUserLastName").value,
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/("""
        $.ajax("""),format.raw/*73.16*/("""{"""),format.raw/*73.17*/("""
            url: "/sharePost",
            data: JSON.stringify(obj),
            headers: """),format.raw/*76.22*/("""{"""),format.raw/*76.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*78.13*/("""}"""),format.raw/*78.14*/(""",
            type: "POST"
        """),format.raw/*80.9*/("""}"""),format.raw/*80.10*/(""").done(function(data) """),format.raw/*80.32*/("""{"""),format.raw/*80.33*/("""
			       window.location.reload();
        """),format.raw/*82.9*/("""}"""),format.raw/*82.10*/(""");
    """),format.raw/*83.5*/("""}"""),format.raw/*83.6*/("""

    function searchUser()"""),format.raw/*85.26*/("""{"""),format.raw/*85.27*/("""
            var obj = """),format.raw/*86.23*/("""{"""),format.raw/*86.24*/("""
                userKeyword : document.getElementById("userKeyword").value
            """),format.raw/*88.13*/("""}"""),format.raw/*88.14*/("""
            $.ajax("""),format.raw/*89.20*/("""{"""),format.raw/*89.21*/("""
                url: "/searchUser",
                data: JSON.stringify(obj),
                headers: """),format.raw/*92.26*/("""{"""),format.raw/*92.27*/("""
                    'Content-Type': 'application/json'
                """),format.raw/*94.17*/("""}"""),format.raw/*94.18*/(""",
                type: "POST"
            """),format.raw/*96.13*/("""}"""),format.raw/*96.14*/(""").done(function(data) """),format.raw/*96.36*/("""{"""),format.raw/*96.37*/("""
                    window.location.reload();
            """),format.raw/*98.13*/("""}"""),format.raw/*98.14*/(""");
        """),format.raw/*99.9*/("""}"""),format.raw/*99.10*/("""

    function searchPost()"""),format.raw/*101.26*/("""{"""),format.raw/*101.27*/("""
            var obj = """),format.raw/*102.23*/("""{"""),format.raw/*102.24*/("""
                postKeyword : document.getElementById("postKeyword").value
            """),format.raw/*104.13*/("""}"""),format.raw/*104.14*/("""
            $.ajax("""),format.raw/*105.20*/("""{"""),format.raw/*105.21*/("""
                url: "/searchPost",
                data: JSON.stringify(obj),
                headers: """),format.raw/*108.26*/("""{"""),format.raw/*108.27*/("""
                    'Content-Type': 'application/json'
                """),format.raw/*110.17*/("""}"""),format.raw/*110.18*/(""",
                type: "POST"
             """),format.raw/*112.14*/("""}"""),format.raw/*112.15*/(""").done(function(data) """),format.raw/*112.37*/("""{"""),format.raw/*112.38*/("""
                    window.location.reload();
             """),format.raw/*114.14*/("""}"""),format.raw/*114.15*/(""");
    """),format.raw/*115.5*/("""}"""),format.raw/*115.6*/("""

    function goBack() """),format.raw/*117.23*/("""{"""),format.raw/*117.24*/("""
            $.ajax("""),format.raw/*118.20*/("""{"""),format.raw/*118.21*/("""
              url: "/goBack",
              type: "POST"
            """),format.raw/*121.13*/("""}"""),format.raw/*121.14*/(""").done(function(data) """),format.raw/*121.36*/("""{"""),format.raw/*121.37*/("""
              window.location.reload();
            """),format.raw/*123.13*/("""}"""),format.raw/*123.14*/(""");
          """),format.raw/*124.11*/("""}"""),format.raw/*124.12*/("""

    function commentPost(postId)"""),format.raw/*126.33*/("""{"""),format.raw/*126.34*/("""
        var commentBox = $('#commentBox'+postId);
        if (commentBox.css("display") == "none") """),format.raw/*128.50*/("""{"""),format.raw/*128.51*/("""
            commentBox.show();
            $.get("/allComment/"+postId, function(data)"""),format.raw/*130.56*/("""{"""),format.raw/*130.57*/("""
                $("#comment"+postId).empty();

                var commentServices = data;
                if("error" in commentServices) return;
                for (cid in commentServices) """),format.raw/*135.46*/("""{"""),format.raw/*135.47*/("""
                var json = commentServices[cid];
                var html = "<li><h6>"+json["time"]+"</h6>&nbsp;&nbsp;" +
                       json["commentUserFirstName"] + "&nbsp;"+ json["commentUserLastName"]
                       +"</a>&nbsp;replied:&nbsp;"+json["text"]+"</li>";
                $("#comment"+postId).append(html);
                """),format.raw/*141.17*/("""}"""),format.raw/*141.18*/("""
              """),format.raw/*142.15*/("""}"""),format.raw/*142.16*/(""");
          """),format.raw/*143.11*/("""}"""),format.raw/*143.12*/(""" else """),format.raw/*143.18*/("""{"""),format.raw/*143.19*/("""
          commentBox.hide();
      """),format.raw/*145.7*/("""}"""),format.raw/*145.8*/("""
    """),format.raw/*146.5*/("""}"""),format.raw/*146.6*/("""

    function submitComment(postId)"""),format.raw/*148.35*/("""{"""),format.raw/*148.36*/("""
        var obj = """),format.raw/*149.19*/("""{"""),format.raw/*149.20*/("""
            postId : postId,
            commentUserId : document.getElementById("commentUserId").value,
        """),format.raw/*152.9*/("""}"""),format.raw/*152.10*/("""
        $.ajax("""),format.raw/*153.16*/("""{"""),format.raw/*153.17*/("""
            url: "/addComment",
            data: JSON.stringify(obj),
            headers: """),format.raw/*156.22*/("""{"""),format.raw/*156.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*158.13*/("""}"""),format.raw/*158.14*/(""",
            type: "POST"
        """),format.raw/*160.9*/("""}"""),format.raw/*160.10*/(""").done(function(data) """),format.raw/*160.32*/("""{"""),format.raw/*160.33*/("""
            window.location.reload();
        """),format.raw/*162.9*/("""}"""),format.raw/*162.10*/(""");
    """),format.raw/*163.5*/("""}"""),format.raw/*163.6*/("""


</script>
"""),format.raw/*168.1*/("""
"""),_display_(Seq[Any](/*169.2*/self("Main Page")/*169.19*/ {_display_(Seq[Any](format.raw/*169.21*/("""
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
            """),_display_(Seq[Any](/*187.14*/if(!session.get("email"))/*187.39*/ {_display_(Seq[Any](format.raw/*187.41*/("""
            <form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*188.61*/routes/*188.67*/.Application.login())),format.raw/*188.87*/("""">
                <button type="submit" class="btn btn-success">Log in</button>
            </form>
            """)))}/*191.15*/else/*191.20*/{_display_(Seq[Any](format.raw/*191.21*/("""
            <li id="drop" class="dropdown nav-btn"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <span class="glyphicon glyphicon-user"></span> My Account<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href=""""),_display_(Seq[Any](/*195.35*/routes/*195.41*/.UserController.homepage())),format.raw/*195.67*/("""">View Profile</a></li>
                    <li><a href=""""),_display_(Seq[Any](/*196.35*/routes/*196.41*/.Application.logout())),format.raw/*196.62*/("""">Log out</a></li>
                </ul>
            </li>
            """)))})),format.raw/*199.14*/("""
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
        
        </div><!--/navbar-collapse-->
    </div><!--/container-fluid-->
</nav>
"""),_display_(Seq[Any](/*216.2*/helper/*216.8*/.form(action = routes.UserController.addPost)/*216.53*/ {_display_(Seq[Any](format.raw/*216.55*/("""
<!-- Post board & Personal information -->
<div id="medium" class="row">
    <div id="right" class="col-md-3 col-md-offset-1">
        <div id="profile">
        <img id="photo" src="/assets/image/default.jpg" class="img-circle center-block" alt="photo">
        <p class="text-center"><strong><a href="homepage">"""),_display_(Seq[Any](/*222.60*/session/*222.67*/.get("email"))),format.raw/*222.80*/("""</a></strong></p>
        <p class="text-center">"""),_display_(Seq[Any](/*223.33*/session/*223.40*/.get("firstName"))),format.raw/*223.57*/(""" """),_display_(Seq[Any](/*223.59*/session/*223.66*/.get("lastName"))),format.raw/*223.82*/("""</p>
        </div>
    </div>
    <div id="left" class="col-md-7">
        <div id="post-board">
            <p id="prompt"><strong>Post a new message</strong></p>
            <p id="less" class="text-right"><small>#Limited 100 characters#</small></p>
            <form>
                <input class="form-control" type="text" id="focusedInput" name="text" placeholder="What's on your mind?" required=""
                       value='"""),_display_(Seq[Any](/*232.32*/postForm("text")/*232.48*/.value)),format.raw/*232.54*/("""'>
                <input class="form-control" type="hidden" name="postUserId" id="inputUserId" value=""""),_display_(Seq[Any](/*233.102*/session/*233.109*/.get("userId"))),format.raw/*233.123*/("""">
                <input class="form-control" type="hidden" name="postUserFirstName" id="inputUserFirstName" value=""""),_display_(Seq[Any](/*234.116*/session/*234.123*/.get("firstName"))),format.raw/*234.140*/("""">
                <input class="form-control" type="hidden" name="postUserLastName" id="inputUserLastName" value=""""),_display_(Seq[Any](/*235.114*/session/*235.121*/.get("lastName"))),format.raw/*235.137*/("""">
                <ul class="nav nav-pills">
                <li role="presentation"><a href="#"><span class="glyphicon glyphicon-map-marker"></span></a></li>
                <li role="presentation">
                    <input type="radio" name="visibility" value="public" checked> Public
                    <input type="radio" name="visibility" value="private"> Private
                    <p class="error" style="color: red;"></p>
                </li>
                </ul>
                <button id="post-btn" type="submit" class="btn btn-danger pull-right">Post</button>
            </form>
        </div>
    </div>
</div><!--/medium-->
""")))})),format.raw/*249.2*/("""
<!--Main Content-->

<div id="content" class="row">
<!--Right-->
    <div id="rightcontent" class="col-md-3  col-md-offset-1">
    <div id="sidebar"><br/>
    <!-- Hot Topic -->
    <div id="friends" class="friends-list">
        <table class="table table-hover text-center">
            <caption class="text-center"><strong>Friends List</strong></caption>
            <tr>
                <td><a href="homepage"><img src="/assets/image/1.jpg" alt="friends-list" class="img-circle friends-photo"></a></td>
                <td><a href="homepage">Shuting Xi</a></td>
                <td><button type="button" class="btn btn-sm btn-warning"><small>&minus; Unfollow</small></button></td>
            </tr>
            <tr>
                <td><a href="homepage"><img src="/assets/image/2.jpg" alt="friends-list" class="img-circle friends-photo"></a></td>
                <td><a href="homepage">Pan Li</a></td>
                <td><button type="button" class="btn btn-sm btn-warning"><small>&minus; Unfollow</small></button></td>
            </tr>
            <tr>
                <td><a href="homepage"><img src="/assets/image/4.jpg" alt="friends-list" class="img-circle friends-photo"></a></td>
                <td><a href="homepage">Nianzu Tang</a></td>
                <td><button type="button" class="btn btn-sm btn-warning"><small>&minus; Unfollow</small></button></td>
            </tr>
            <tr>
                <td><a href="homepage"><img src="/assets/image/6.jpg" alt="friends-list" class="img-circle friends-photo"></a></td>
                <td><a href="homepage">Shuoyao Ma</a></td>
                <td><button type="button" class="btn btn-sm btn-warning"><small>&minus; Unfollow</small></button></td>
            </tr>
        </table>
    </div><!--/friend-list-->
    <div class="line"></div><br/>
    <div id="new-friends" class="friends-list">
        <table class="table table-hover text-center">
            <caption class="text-center"><strong>New Friends</strong></caption>
            <tr>
                <td><a href="homepage"><img src="/assets/image/default.jpg" alt="friends-list" class="img-circle friends-photo"></a></td>
                <td><a href="homepage">Tina</a></td>
                <td><button type="button" class="btn btn-sm btn-info"><small>&plus; Follow</small></button></td>
            </tr>
            <tr>
                <td><a href="homepage"><img src="/assets/image/default.jpg" alt="friends-list" class="img-circle friends-photo"></a></td>
                <td><a href="homepage">cpp</a></td>
                <td><button type="button" class="btn btn-sm btn-info"><small>&plus; Follow</small></button></td>
            </tr>
            <tr>
                <td><a href="homepage"><img src="/assets/image/default.jpg" alt="friends-list" class="img-circle friends-photo"></a></td>
                <td><a href="homepage">Ge</a></td>
                <td><button type="button" class="btn btn-sm btn-info"><small>&plus; Follow</small></button></td>
            </tr>
            <tr>
                <td><a href="homepage"><img src="/assets/image/default.jpg" alt="friends-list" class="img-circle friends-photo"></a></td>
                <td><a href="homepage">Sherry</a></td>
                <td><button type="button" class="btn btn-sm btn-info"><small>&plus; Follow</small></button></td>
            </tr>
        </table>
    </div><!--/friend-list-->
        <div id="hot-picture">
            <table id="picture-table">
                <caption class="text-center"><strong>Photos and videos</strong></caption>
                <tr>
                    <td><img src="/assets/image/post1.png" alt="photos" class="img-thumbnail picture-lib"></td>
                    <td><img src="/assets/image/post3.jpg" alt="photos" class="img-thumbnail picture-lib"></td>
                </tr>
                <tr>
                    <td><img src="/assets/image/post2.jpg" alt="photos" class="img-thumbnail picture-lib"></td>
                    <td><img src="/assets/image/img3.jpg" alt="photos" class="img-thumbnail picture-lib"></td>
                </tr>
                <tr>
                    <td><img src="/assets/image/flower2.jpg" alt="photos" class="img-thumbnail picture-lib"></td>
                    <td><img src="/assets/image/img2.jpg" alt="photos" class="img-thumbnail picture-lib"></td>
                </tr>
            </table>
        </div><!--/Hot picture -->
    </div><!--/sidebar-->
    </div><!--/rightcontent-->

    <div id="leftcontent" class="col-md-7">
    <!-- Dashboard -->
    <div id="stream-list">
        """),_display_(Seq[Any](/*331.10*/for(postService <- postServices) yield /*331.42*/{_display_(Seq[Any](format.raw/*331.43*/("""
        <div class="soc-box">
            <div class="soc">
                <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
                <a href="homepage">"""),_display_(Seq[Any](/*335.37*/postService/*335.48*/.getPostUserFirstName())),format.raw/*335.71*/(""" """),_display_(Seq[Any](/*335.73*/postService/*335.84*/.getPostUserLastName())),format.raw/*335.106*/("""</a>
            </div>
            <div class="post-time text-right">
                <h6><span class="glyphicon glyphicon-time"></span> """),_display_(Seq[Any](/*338.69*/postService/*338.80*/.getTime())),format.raw/*338.90*/("""</h6>
            </div>
            <p class="post-text">"""),_display_(Seq[Any](/*340.35*/postService/*340.46*/.getText())),format.raw/*340.56*/("""</p>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="button" onclick="sharePost("""),_display_(Seq[Any](/*343.63*/postService/*343.74*/.getId())),format.raw/*343.82*/(""")" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share </small></button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" type="button" onclick="commentPost("""),_display_(Seq[Any](/*346.79*/postService/*346.90*/.getId())),format.raw/*346.98*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Reply </small></button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" onclick="likePost("""),_display_(Seq[Any](/*349.62*/postService/*349.73*/.getId())),format.raw/*349.81*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-heart"></span><small> Like : """),_display_(Seq[Any](/*349.171*/postService/*349.182*/.getLikes())),format.raw/*349.193*/("""</small></button>
                </div>
            </div>

            <div class="comment-box" style="display:none;" id="commentBox"""),_display_(Seq[Any](/*353.75*/postService/*353.86*/.getId())),format.raw/*353.94*/("""">
                <div class="comment">
                    <ol class="list-unstyled" id="comment"""),_display_(Seq[Any](/*355.59*/postService/*355.70*/.getId())),format.raw/*355.78*/("""">
                    </ol>
                </div>

                """),_display_(Seq[Any](/*359.18*/helper/*359.24*/.form(action = routes.UserController.addComment)/*359.72*/ {_display_(Seq[Any](format.raw/*359.74*/("""
                    <form id="form"""),_display_(Seq[Any](/*360.36*/postService/*360.47*/.getId())),format.raw/*360.55*/("""" method="post">
                        <input type="hidden" name="postId" id="postId" value=""""),_display_(Seq[Any](/*361.80*/postService/*361.91*/.getId())),format.raw/*361.99*/("""">
                        <input class="form-control" type="hidden" name="commentUserId" id="commentUserId" value=""""),_display_(Seq[Any](/*362.115*/session/*362.122*/.get("userId"))),format.raw/*362.136*/("""">
                        <input type="text" class="form-control" placeholder="Type Your comment" name="text">
                        <button type="submit" class="btn btn-info pull-right submitBtn btn-xs">Submit</button>
                    </form>
                """)))})),format.raw/*366.18*/("""
            </div>
        </div>
        <br>
        """)))})),format.raw/*370.10*/("""

        """),_display_(Seq[Any](/*372.10*/for(sUser <- searchUserResult) yield /*372.40*/{_display_(Seq[Any](format.raw/*372.41*/("""
            <div class="soc-box">
              <div class="soc">
                <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
                <a href="homepage">"""),_display_(Seq[Any](/*376.37*/sUser/*376.42*/.getUserName)),format.raw/*376.54*/("""</a>
              </div>
            </div>
          """)))})),format.raw/*379.12*/("""
    </div><!--leftcontent-->
</div><!--Content-->
""")))})),format.raw/*382.2*/("""
"""))}
    }
    
    def render(postServices:List[models.Post],postForm:play.data.Form[models.Post],commentForm:play.data.Form[models.Comment],user:models.User,searchUserResult:List[models.User]): play.api.templates.HtmlFormat.Appendable = apply(postServices,postForm,commentForm,user,searchUserResult)
    
    def f:((List[models.Post],play.data.Form[models.Post],play.data.Form[models.Comment],models.User,List[models.User]) => play.api.templates.HtmlFormat.Appendable) = (postServices,postForm,commentForm,user,searchUserResult) => apply(postServices,postForm,commentForm,user,searchUserResult)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 04 17:17:25 EST 2015
                    SOURCE: /Users/X/Desktop/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/mainpage.scala.html
                    HASH: fad1e7d1f99c7f88d4b1bfde6e075059eee72984
                    MATRIX: 3250->1188|3541->1368|3632->1431|3661->1432|3708->1451|3737->1452|3801->1489|3830->1490|3874->1506|3903->1507|4022->1598|4051->1599|4143->1663|4172->1664|4234->1699|4263->1700|4313->1722|4342->1723|4439->1792|4468->1793|4546->1843|4575->1844|4607->1848|4636->1849|4719->1904|4748->1905|4784->1914|4813->1915|4847->1922|4875->1923|4930->1950|4959->1951|5006->1970|5035->1971|5142->2051|5171->2052|5215->2068|5244->2069|5365->2162|5394->2163|5486->2227|5515->2228|5577->2263|5606->2264|5656->2286|5685->2287|5782->2356|5811->2357|5889->2407|5918->2408|5950->2412|5979->2413|6062->2468|6091->2469|6127->2478|6156->2479|6190->2486|6218->2487|6278->2519|6307->2520|6354->2539|6383->2540|6687->2817|6716->2818|6760->2834|6789->2835|6909->2927|6938->2928|7030->2992|7059->2993|7121->3028|7150->3029|7200->3051|7229->3052|7301->3097|7330->3098|7364->3105|7392->3106|7447->3133|7476->3134|7527->3157|7556->3158|7672->3246|7701->3247|7749->3267|7778->3268|7911->3373|7940->3374|8040->3446|8069->3447|8140->3490|8169->3491|8219->3513|8248->3514|8335->3573|8364->3574|8402->3585|8431->3586|8487->3613|8517->3614|8569->3637|8599->3638|8716->3726|8746->3727|8795->3747|8825->3748|8959->3853|8989->3854|9090->3926|9120->3927|9193->3971|9223->3972|9274->3994|9304->3995|9393->4055|9423->4056|9458->4063|9487->4064|9540->4088|9570->4089|9619->4109|9649->4110|9748->4180|9778->4181|9829->4203|9859->4204|9941->4257|9971->4258|10013->4271|10043->4272|10106->4306|10136->4307|10265->4407|10295->4408|10411->4495|10441->4496|10662->4688|10692->4689|11076->5044|11106->5045|11150->5060|11180->5061|11222->5074|11252->5075|11287->5081|11317->5082|11381->5118|11410->5119|11443->5124|11472->5125|11537->5161|11567->5162|11615->5181|11645->5182|11787->5296|11817->5297|11862->5313|11892->5314|12014->5407|12044->5408|12137->5472|12167->5473|12230->5508|12260->5509|12311->5531|12341->5532|12416->5579|12446->5580|12481->5587|12510->5588|12551->5618|12589->5620|12616->5637|12657->5639|13681->6626|13716->6651|13757->6653|13855->6714|13871->6720|13914->6740|14048->6855|14062->6860|14102->6861|14433->7155|14449->7161|14498->7187|14593->7245|14609->7251|14653->7272|14758->7344|15518->8068|15533->8074|15588->8119|15629->8121|15981->8436|15998->8443|16034->8456|16121->8506|16138->8513|16178->8530|16217->8532|16234->8539|16273->8555|16746->8991|16772->9007|16801->9013|16943->9117|16961->9124|16999->9138|17155->9256|17173->9263|17214->9280|17368->9396|17386->9403|17426->9419|18105->10066|22720->14644|22769->14676|22809->14677|23041->14872|23062->14883|23108->14906|23147->14908|23168->14919|23214->14941|23390->15080|23411->15091|23444->15101|23540->15160|23561->15171|23594->15181|23837->15387|23858->15398|23889->15406|24189->15669|24210->15680|24241->15688|24524->15934|24545->15945|24576->15953|24704->16043|24726->16054|24761->16065|24933->16200|24954->16211|24985->16219|25121->16318|25142->16329|25173->16337|25280->16407|25296->16413|25354->16461|25395->16463|25468->16499|25489->16510|25520->16518|25653->16614|25674->16625|25705->16633|25860->16750|25878->16757|25916->16771|26217->17039|26307->17096|26355->17107|26402->17137|26442->17138|26680->17339|26695->17344|26730->17356|26819->17412|26903->17464
                    LINES: 56->17|64->21|67->24|67->24|68->25|68->25|70->27|70->27|71->28|71->28|74->31|74->31|76->33|76->33|78->35|78->35|78->35|78->35|80->37|80->37|82->39|82->39|82->39|82->39|84->41|84->41|85->42|85->42|86->43|86->43|88->45|88->45|89->46|89->46|91->48|91->48|92->49|92->49|95->52|95->52|97->54|97->54|99->56|99->56|99->56|99->56|101->58|101->58|103->60|103->60|103->60|103->60|105->62|105->62|106->63|106->63|107->64|107->64|109->66|109->66|110->67|110->67|115->72|115->72|116->73|116->73|119->76|119->76|121->78|121->78|123->80|123->80|123->80|123->80|125->82|125->82|126->83|126->83|128->85|128->85|129->86|129->86|131->88|131->88|132->89|132->89|135->92|135->92|137->94|137->94|139->96|139->96|139->96|139->96|141->98|141->98|142->99|142->99|144->101|144->101|145->102|145->102|147->104|147->104|148->105|148->105|151->108|151->108|153->110|153->110|155->112|155->112|155->112|155->112|157->114|157->114|158->115|158->115|160->117|160->117|161->118|161->118|164->121|164->121|164->121|164->121|166->123|166->123|167->124|167->124|169->126|169->126|171->128|171->128|173->130|173->130|178->135|178->135|184->141|184->141|185->142|185->142|186->143|186->143|186->143|186->143|188->145|188->145|189->146|189->146|191->148|191->148|192->149|192->149|195->152|195->152|196->153|196->153|199->156|199->156|201->158|201->158|203->160|203->160|203->160|203->160|205->162|205->162|206->163|206->163|210->168|211->169|211->169|211->169|229->187|229->187|229->187|230->188|230->188|230->188|233->191|233->191|233->191|237->195|237->195|237->195|238->196|238->196|238->196|241->199|258->216|258->216|258->216|258->216|264->222|264->222|264->222|265->223|265->223|265->223|265->223|265->223|265->223|274->232|274->232|274->232|275->233|275->233|275->233|276->234|276->234|276->234|277->235|277->235|277->235|291->249|373->331|373->331|373->331|377->335|377->335|377->335|377->335|377->335|377->335|380->338|380->338|380->338|382->340|382->340|382->340|385->343|385->343|385->343|388->346|388->346|388->346|391->349|391->349|391->349|391->349|391->349|391->349|395->353|395->353|395->353|397->355|397->355|397->355|401->359|401->359|401->359|401->359|402->360|402->360|402->360|403->361|403->361|403->361|404->362|404->362|404->362|408->366|412->370|414->372|414->372|414->372|418->376|418->376|418->376|421->379|424->382
                    -- GENERATED --
                */
            