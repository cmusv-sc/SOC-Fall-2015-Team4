
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
object mainpage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[models.Post],play.data.Form[models.Post],play.data.Form[models.Comment],play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*17.2*/(postServices: List[models.Post],postForm: play.data.Form[models.Post],commentForm: play.data.Form[models.Comment]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*17.117*/("""
<script type="text/javascript">

    function likePost(postId)"""),format.raw/*20.30*/("""{"""),format.raw/*20.31*/("""

        var obj = """),format.raw/*22.19*/("""{"""),format.raw/*22.20*/("""
            postId : postId
        """),format.raw/*24.9*/("""}"""),format.raw/*24.10*/("""
        $.ajax("""),format.raw/*25.16*/("""{"""),format.raw/*25.17*/("""
            url: "/likePost",
            data: JSON.stringify(obj),
            headers: """),format.raw/*28.22*/("""{"""),format.raw/*28.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*30.13*/("""}"""),format.raw/*30.14*/(""",
            type: "POST"
        """),format.raw/*32.9*/("""}"""),format.raw/*32.10*/(""").done(function(data) """),format.raw/*32.32*/("""{"""),format.raw/*32.33*/("""
            console.log(data);
            var response = data;
            if("error" in response)"""),format.raw/*35.36*/("""{"""),format.raw/*35.37*/("""
                alert("like error!")
            """),format.raw/*37.13*/("""}"""),format.raw/*37.14*/("""else"""),format.raw/*37.18*/("""{"""),format.raw/*37.19*/("""
                window.location.reload();
            """),format.raw/*39.13*/("""}"""),format.raw/*39.14*/("""
        """),format.raw/*40.9*/("""}"""),format.raw/*40.10*/(""");
    """),format.raw/*41.5*/("""}"""),format.raw/*41.6*/("""
    
function searchUser()"""),format.raw/*43.22*/("""{"""),format.raw/*43.23*/("""
        var obj = """),format.raw/*44.19*/("""{"""),format.raw/*44.20*/("""
            userKeyword : document.getElementById("userKeyword").value
        """),format.raw/*46.9*/("""}"""),format.raw/*46.10*/("""
        $.ajax("""),format.raw/*47.16*/("""{"""),format.raw/*47.17*/("""
            url: "/searchUser",
            data: JSON.stringify(obj),
            headers: """),format.raw/*50.22*/("""{"""),format.raw/*50.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*52.13*/("""}"""),format.raw/*52.14*/(""",
            type: "POST"
        """),format.raw/*54.9*/("""}"""),format.raw/*54.10*/(""").done(function(data) """),format.raw/*54.32*/("""{"""),format.raw/*54.33*/("""
            console.log(data);
            var response = data;
            if("error" in response)"""),format.raw/*57.36*/("""{"""),format.raw/*57.37*/("""
                alert("like error!")
            """),format.raw/*59.13*/("""}"""),format.raw/*59.14*/("""else"""),format.raw/*59.18*/("""{"""),format.raw/*59.19*/("""
                window.location.reload();
            """),format.raw/*61.13*/("""}"""),format.raw/*61.14*/("""
        """),format.raw/*62.9*/("""}"""),format.raw/*62.10*/(""");
    """),format.raw/*63.5*/("""}"""),format.raw/*63.6*/("""
    
 function sharePost(postId)"""),format.raw/*65.28*/("""{"""),format.raw/*65.29*/("""
        var obj = """),format.raw/*66.19*/("""{"""),format.raw/*66.20*/("""
            postId : postId,
            postUserId : document.getElementById("inputUserId").value,
            postUserFirstName : document.getElementById("inputUserFirstName").value,
            postUserLastName : document.getElementById("inputUserLastName").value,
        """),format.raw/*71.9*/("""}"""),format.raw/*71.10*/("""
        $.ajax("""),format.raw/*72.16*/("""{"""),format.raw/*72.17*/("""
            url: "/sharePost",
            data: JSON.stringify(obj),
            headers: """),format.raw/*75.22*/("""{"""),format.raw/*75.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*77.13*/("""}"""),format.raw/*77.14*/(""",
            type: "POST"
        """),format.raw/*79.9*/("""}"""),format.raw/*79.10*/(""").done(function(data) """),format.raw/*79.32*/("""{"""),format.raw/*79.33*/("""
			window.location.reload();
        """),format.raw/*81.9*/("""}"""),format.raw/*81.10*/(""");
    """),format.raw/*82.5*/("""}"""),format.raw/*82.6*/("""

    function commentPost(postId)"""),format.raw/*84.33*/("""{"""),format.raw/*84.34*/("""
        $.get("/allComment/"+postId, function(data)"""),format.raw/*85.52*/("""{"""),format.raw/*85.53*/("""
            var commentServices = data;
            for (cid in commentServices) """),format.raw/*87.42*/("""{"""),format.raw/*87.43*/("""
                var json = commentServices[cid];
                var html = "<li><h6>"+json["time"]+"</h6>" +
                            json["commentUserId"] +"</a>&nbsp;replied:&nbsp;"+json["text"]+"</li>";
                //用下面的替换上面的html
//                var html = "<li><h6>"+json["time"]+"</h6>&nbsp;&nbsp;" +
//                        json["commentUserFirstName"] + "&nbsp;"+ json["commentUserLastName"] +"</a>&nbsp;replied:&nbsp;"+json["text"]+"</li>";
                $("#comment"+postId).append(html);
            """),format.raw/*95.13*/("""}"""),format.raw/*95.14*/("""
        """),format.raw/*96.9*/("""}"""),format.raw/*96.10*/(""");
        var commentBox = $('#commentBox'+postId);
        if (commentBox.css("display") == "none") """),format.raw/*98.50*/("""{"""),format.raw/*98.51*/("""
            commentBox.show();
        """),format.raw/*100.9*/("""}"""),format.raw/*100.10*/(""" else """),format.raw/*100.16*/("""{"""),format.raw/*100.17*/("""
            commentBox.hide();
        """),format.raw/*102.9*/("""}"""),format.raw/*102.10*/("""
    """),format.raw/*103.5*/("""}"""),format.raw/*103.6*/("""


    function submitComment(postId)"""),format.raw/*106.35*/("""{"""),format.raw/*106.36*/("""
        var obj = """),format.raw/*107.19*/("""{"""),format.raw/*107.20*/("""
            postId : postId,
            commentUserId : document.getElementById("commentUserId").value,
            //取消注释
//            commentUserFirstName : document.getElementById("commentUserFirstName").value,
//            commentUserLastName : document.getElementById("commentUserLastName").value,
        """),format.raw/*113.9*/("""}"""),format.raw/*113.10*/("""
        $.ajax("""),format.raw/*114.16*/("""{"""),format.raw/*114.17*/("""
            url: "/addComment",
            data: JSON.stringify(obj),
            headers: """),format.raw/*117.22*/("""{"""),format.raw/*117.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*119.13*/("""}"""),format.raw/*119.14*/(""",
            type: "POST"
        """),format.raw/*121.9*/("""}"""),format.raw/*121.10*/(""").done(function(data) """),format.raw/*121.32*/("""{"""),format.raw/*121.33*/("""
            window.location.reload();
        """),format.raw/*123.9*/("""}"""),format.raw/*123.10*/(""");
    """),format.raw/*124.5*/("""}"""),format.raw/*124.6*/("""


</script>
"""),format.raw/*129.1*/("""
"""),_display_(Seq[Any](/*130.2*/self("Main Page")/*130.19*/ {_display_(Seq[Any](format.raw/*130.21*/("""
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
            """),_display_(Seq[Any](/*148.14*/if(!session.get("email"))/*148.39*/ {_display_(Seq[Any](format.raw/*148.41*/("""
            <form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*149.61*/routes/*149.67*/.Application.login())),format.raw/*149.87*/("""">
                <button type="submit" class="btn btn-success">Log in</button>
            </form>
            """)))}/*152.15*/else/*152.20*/{_display_(Seq[Any](format.raw/*152.21*/("""
            <li id="drop" class="dropdown nav-btn"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <span class="glyphicon glyphicon-user"></span> My Account<span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href=""""),_display_(Seq[Any](/*156.35*/routes/*156.41*/.UserController.homepage())),format.raw/*156.67*/("""">View Profile</a></li>
                    <li><a href=""""),_display_(Seq[Any](/*157.35*/routes/*157.41*/.Application.logout())),format.raw/*157.62*/("""">Log out</a></li>
                </ul>
            </li>
            """)))})),format.raw/*160.14*/("""
        </ul>
 
            <div class="navbar-form navbar-right">
                <input type="text" id="userKeyword" class="form-control" placeholder="Search user">
                <button type="button" onclick="searchUser()" class="btn btn-default">Search</button>
            </div>
            
 
        
        </div><!--/navbar-collapse-->
    </div><!--/container-fluid-->
</nav>
"""),_display_(Seq[Any](/*173.2*/helper/*173.8*/.form(action = routes.UserController.addPost)/*173.53*/ {_display_(Seq[Any](format.raw/*173.55*/("""
<!-- Post board & Personal information -->
<div id="medium" class="row">
    <div id="right" class="col-md-3 col-md-offset-1">
        <div id="profile">
        <img id="photo" src="/assets/image/default.jpg" class="img-circle center-block" alt="photo">
        <p class="text-center"><strong><a href="homepage">"""),_display_(Seq[Any](/*179.60*/session/*179.67*/.get("email"))),format.raw/*179.80*/("""</a></strong></p>
        <p class="text-center">"""),_display_(Seq[Any](/*180.33*/session/*180.40*/.get("firstName"))),format.raw/*180.57*/(""" """),_display_(Seq[Any](/*180.59*/session/*180.66*/.get("lastName"))),format.raw/*180.82*/("""</p>
        </div>
    </div>
    <div id="left" class="col-md-7">
        <div id="post-board">
            <p id="prompt"><strong>Post a new message</strong></p>
            <p id="less" class="text-right"><small>#Limited 100 characters#</small></p>
            <form>
                <input class="form-control" type="text" id="focusedInput" name="text" placeholder="What's on your mind?" required=""
                       value='"""),_display_(Seq[Any](/*189.32*/postForm("text")/*189.48*/.value)),format.raw/*189.54*/("""'>
                <input class="form-control" type="hidden" name="postUserId" id="inputUserId" value=""""),_display_(Seq[Any](/*190.102*/session/*190.109*/.get("userId"))),format.raw/*190.123*/("""">
                <input class="form-control" type="hidden" name="postUserFirstName" id="inputUserFirstName" value=""""),_display_(Seq[Any](/*191.116*/session/*191.123*/.get("firstName"))),format.raw/*191.140*/("""">
                <input class="form-control" type="hidden" name="postUserLastName" id="inputUserLastName" value=""""),_display_(Seq[Any](/*192.114*/session/*192.121*/.get("lastName"))),format.raw/*192.137*/("""">
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
""")))})),format.raw/*206.2*/("""
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
        """),_display_(Seq[Any](/*288.10*/for(postService <- postServices) yield /*288.42*/{_display_(Seq[Any](format.raw/*288.43*/("""
        <div class="soc-box">
            <div class="soc">
                <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
                <a href="homepage">"""),_display_(Seq[Any](/*292.37*/postService/*292.48*/.getPostUserFirstName())),format.raw/*292.71*/(""" """),_display_(Seq[Any](/*292.73*/postService/*292.84*/.getPostUserLastName())),format.raw/*292.106*/("""</a>
            </div>
            <div class="post-time text-right">
                <h6><span class="glyphicon glyphicon-time"></span> """),_display_(Seq[Any](/*295.69*/postService/*295.80*/.getTime())),format.raw/*295.90*/("""</h6>
            </div>
            <p class="post-text">"""),_display_(Seq[Any](/*297.35*/postService/*297.46*/.getText())),format.raw/*297.56*/("""</p>
            <div class="btn-group btn-group-justified" role="group" aria-label="...">
                <div class="btn-group" role="group">
                    <button type="button" onclick="sharePost("""),_display_(Seq[Any](/*300.63*/postService/*300.74*/.getId())),format.raw/*300.82*/(""")" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share </small></button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" type="button" onclick="commentPost("""),_display_(Seq[Any](/*303.79*/postService/*303.90*/.getId())),format.raw/*303.98*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Reply </small></button>
                </div>
                <div class="btn-group" role="group">
                    <button type="button" onclick="likePost("""),_display_(Seq[Any](/*306.62*/postService/*306.73*/.getId())),format.raw/*306.81*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-heart"></span><small> Like : """),_display_(Seq[Any](/*306.171*/postService/*306.182*/.getLikes())),format.raw/*306.193*/("""</small></button>
                </div>
            </div>

            <div class="comment-box" style="display:none;" id="commentBox"""),_display_(Seq[Any](/*310.75*/postService/*310.86*/.getId())),format.raw/*310.94*/("""">
                <div class="comment">
                    <ol class="list-unstyled" id="comment"""),_display_(Seq[Any](/*312.59*/postService/*312.70*/.getId())),format.raw/*312.78*/("""">
                    </ol>
                </div>

                """),_display_(Seq[Any](/*316.18*/helper/*316.24*/.form(action = routes.UserController.addComment)/*316.72*/ {_display_(Seq[Any](format.raw/*316.74*/("""
                    <form id="form"""),_display_(Seq[Any](/*317.36*/postService/*317.47*/.getId())),format.raw/*317.55*/("""" method="post">
                        <input type="hidden" name="postId" id="postId" value=""""),_display_(Seq[Any](/*318.80*/postService/*318.91*/.getId())),format.raw/*318.99*/("""">
                        <input class="form-control" type="hidden" name="commentUserId" id="commentUserId" value=""""),_display_(Seq[Any](/*319.115*/session/*319.122*/.get("userId"))),format.raw/*319.136*/("""">
                        <!--取消注释-->
                        <!--<input class="form-control" type="hidden" name="commentUserFirstName" id="commentUserFirstName" value=""""),_display_(Seq[Any](/*321.133*/session/*321.140*/.get("firstName"))),format.raw/*321.157*/("""">-->
                        <!--<input class="form-control" type="hidden" name="commentUserLastName" id="commentUserLastName" value=""""),_display_(Seq[Any](/*322.131*/session/*322.138*/.get("lastName"))),format.raw/*322.154*/("""">-->
                        <input type="text" class="form-control" placeholder="Type Your comment" name="text">
                        <button type="submit" class="btn btn-info pull-right submitBtn btn-xs" onclick="submitComment("""),_display_(Seq[Any](/*324.120*/postService/*324.131*/.getId())),format.raw/*324.139*/(""")">Submit</button>
                    </form>
                """)))})),format.raw/*326.18*/("""
            </div>
        </div>
        <br>
        """)))})),format.raw/*330.10*/("""


    </div>
    </div><!--leftcontent-->
</div><!--Content-->
""")))})))}
    }
    
    def render(postServices:List[models.Post],postForm:play.data.Form[models.Post],commentForm:play.data.Form[models.Comment]): play.api.templates.HtmlFormat.Appendable = apply(postServices,postForm,commentForm)
    
    def f:((List[models.Post],play.data.Form[models.Post],play.data.Form[models.Comment]) => play.api.templates.HtmlFormat.Appendable) = (postServices,postForm,commentForm) => apply(postServices,postForm,commentForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 03 11:13:15 EST 2015
                    SOURCE: /Users/apple/test/SOC-Fall-2015-Team4-Lead-Shuting-Xi/ApacheCMDA-Frontend/app/views/climate/mainpage.scala.html
                    HASH: 752bf202df456a0a5d3494a8e5da912f53b0fda4
                    MATRIX: 3220->1188|3447->1303|3538->1366|3567->1367|3615->1387|3644->1388|3708->1425|3737->1426|3781->1442|3810->1443|3929->1534|3958->1535|4050->1599|4079->1600|4141->1635|4170->1636|4220->1658|4249->1659|4377->1759|4406->1760|4484->1810|4513->1811|4545->1815|4574->1816|4657->1871|4686->1872|4722->1881|4751->1882|4785->1889|4813->1890|4868->1917|4897->1918|4944->1937|4973->1938|5080->2018|5109->2019|5153->2035|5182->2036|5303->2129|5332->2130|5424->2194|5453->2195|5515->2230|5544->2231|5594->2253|5623->2254|5751->2354|5780->2355|5858->2405|5887->2406|5919->2410|5948->2411|6031->2466|6060->2467|6096->2476|6125->2477|6159->2484|6187->2485|6248->2518|6277->2519|6324->2538|6353->2539|6657->2816|6686->2817|6730->2833|6759->2834|6879->2926|6908->2927|7000->2991|7029->2992|7091->3027|7120->3028|7170->3050|7199->3051|7264->3089|7293->3090|7327->3097|7355->3098|7417->3132|7446->3133|7526->3185|7555->3186|7665->3268|7694->3269|8248->3795|8277->3796|8313->3805|8342->3806|8472->3908|8501->3909|8569->3949|8599->3950|8634->3956|8664->3957|8732->3997|8762->3998|8795->4003|8824->4004|8890->4041|8920->4042|8968->4061|8998->4062|9341->4377|9371->4378|9416->4394|9446->4395|9568->4488|9598->4489|9691->4553|9721->4554|9784->4589|9814->4590|9865->4612|9895->4613|9970->4660|10000->4661|10035->4668|10064->4669|10105->4699|10143->4701|10170->4718|10211->4720|11235->5707|11270->5732|11311->5734|11409->5795|11425->5801|11468->5821|11602->5936|11616->5941|11656->5942|11987->6236|12003->6242|12052->6268|12147->6326|12163->6332|12207->6353|12312->6425|12740->6817|12755->6823|12810->6868|12851->6870|13203->7185|13220->7192|13256->7205|13343->7255|13360->7262|13400->7279|13439->7281|13456->7288|13495->7304|13968->7740|13994->7756|14023->7762|14165->7866|14183->7873|14221->7887|14377->8005|14395->8012|14436->8029|14590->8145|14608->8152|14648->8168|15327->8815|19942->13393|19991->13425|20031->13426|20263->13621|20284->13632|20330->13655|20369->13657|20390->13668|20436->13690|20612->13829|20633->13840|20666->13850|20762->13909|20783->13920|20816->13930|21059->14136|21080->14147|21111->14155|21411->14418|21432->14429|21463->14437|21746->14683|21767->14694|21798->14702|21926->14792|21948->14803|21983->14814|22155->14949|22176->14960|22207->14968|22343->15067|22364->15078|22395->15086|22502->15156|22518->15162|22576->15210|22617->15212|22690->15248|22711->15259|22742->15267|22875->15363|22896->15374|22927->15382|23082->15499|23100->15506|23138->15520|23347->15691|23365->15698|23406->15715|23580->15851|23598->15858|23638->15874|23910->16108|23932->16119|23964->16127|24061->16191|24151->16248
                    LINES: 56->17|60->17|63->20|63->20|65->22|65->22|67->24|67->24|68->25|68->25|71->28|71->28|73->30|73->30|75->32|75->32|75->32|75->32|78->35|78->35|80->37|80->37|80->37|80->37|82->39|82->39|83->40|83->40|84->41|84->41|86->43|86->43|87->44|87->44|89->46|89->46|90->47|90->47|93->50|93->50|95->52|95->52|97->54|97->54|97->54|97->54|100->57|100->57|102->59|102->59|102->59|102->59|104->61|104->61|105->62|105->62|106->63|106->63|108->65|108->65|109->66|109->66|114->71|114->71|115->72|115->72|118->75|118->75|120->77|120->77|122->79|122->79|122->79|122->79|124->81|124->81|125->82|125->82|127->84|127->84|128->85|128->85|130->87|130->87|138->95|138->95|139->96|139->96|141->98|141->98|143->100|143->100|143->100|143->100|145->102|145->102|146->103|146->103|149->106|149->106|150->107|150->107|156->113|156->113|157->114|157->114|160->117|160->117|162->119|162->119|164->121|164->121|164->121|164->121|166->123|166->123|167->124|167->124|171->129|172->130|172->130|172->130|190->148|190->148|190->148|191->149|191->149|191->149|194->152|194->152|194->152|198->156|198->156|198->156|199->157|199->157|199->157|202->160|215->173|215->173|215->173|215->173|221->179|221->179|221->179|222->180|222->180|222->180|222->180|222->180|222->180|231->189|231->189|231->189|232->190|232->190|232->190|233->191|233->191|233->191|234->192|234->192|234->192|248->206|330->288|330->288|330->288|334->292|334->292|334->292|334->292|334->292|334->292|337->295|337->295|337->295|339->297|339->297|339->297|342->300|342->300|342->300|345->303|345->303|345->303|348->306|348->306|348->306|348->306|348->306|348->306|352->310|352->310|352->310|354->312|354->312|354->312|358->316|358->316|358->316|358->316|359->317|359->317|359->317|360->318|360->318|360->318|361->319|361->319|361->319|363->321|363->321|363->321|364->322|364->322|364->322|366->324|366->324|366->324|368->326|372->330
                    -- GENERATED --
                */
            