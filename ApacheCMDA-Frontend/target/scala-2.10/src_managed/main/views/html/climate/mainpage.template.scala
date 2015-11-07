
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
object mainpage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

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
    def apply():play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*19.1*/("""
"""),_display_(Seq[Any](/*20.2*/self("Main Page")/*20.19*/ {_display_(Seq[Any](format.raw/*20.21*/("""

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
    <li id="drop" class="dropdown nav-btn"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
     <span class="glyphicon glyphicon-user"></span> My Account<span class="caret"></span></a>
     <ul class="dropdown-menu">
      <li><a href="homepage">View Profile</a></li>
      <li role="separator" class="divider"></li>
      <li><a href="#">Setting</a></li>
      <li role="separator" class="divider"></li>
      <li><a href="login">Log out</a></li>
     </ul>
    </li>
    <li  class="nav-btn"><a href="#"><span class="glyphicon glyphicon-envelope"></span> Message</a></li>
   </ul>

   <form id="search-form" class="navbar-form navbar-right">
    <div class="form-group">
     <input type="text" class="form-control" placeholder="Search user">
    </div>
    <button type="submit" class="btn btn-default">Search</button>
   </form>
  </div><!--/navbar-collapse-->
 </div><!--/container-fluid-->
</nav>

<!-- Post board & Personal information -->
<div id="medium" class="row">
 <div id="right" class="col-md-3 col-md-offset-1">
  <div id="profile">
   <img id="photo" src="/assets/image/default.jpg" class="img-circle center-block" alt="photo">
   <p class="text-center"><strong><a href="homepage">username</a></strong></p>
   <p class="text-center"><span class="glyphicon glyphicon-map-marker"></span> Location
    <span class="splitter">| </span><span class="glyphicon glyphicon-user"></span> Gender
   </p>
  </div>
 </div>
 <div id="left" class="col-md-7">
  <div id="post-board">
   <p id="prompt"><strong>Post a new message</strong></p>
   <p id="less" class="text-right"><small>#Limited 100 characters#</small></p>
   <form>
    <textarea class="form-control" id="focusedInput" placeholder="What's on your mind?"></textarea>
    <ul class="nav nav-pills">
     <li role="presentation"><a href="#"><span class="glyphicon glyphicon-picture"></span></a></li>
     <li role="presentation"><a href="#"><span class="glyphicon glyphicon-tags"></span></a></li>
     <li role="presentation"><a href="#"><span class="glyphicon glyphicon-map-marker"></span></a></li>
     <li role="presentation">
      <select name="type" id="type">
       <option value="1" selected="selected">Public</option>
       <option value="2">Private</option>
      </select>
     </li>
    </ul>
    <button id="post-btn" type="button" class="btn btn-danger pull-right">Post</button>
   </form>
  </div>
 </div>

</div><!--/medium-->

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
   <div class="line"></div>
   <!-- Hot picture -->
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
   <div class="soc-box">
    <div class="soc">
     <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
     <a href="homepage">username</a>
    </div>
    <div class="post-time text-right">
     <h6><span class="glyphicon glyphicon-time"></span> 20:16:20 11/04/2015</h6>
    </div>
    <p class="post-text">Posts (Discussion topics over some services) that are
     published by the user.</p>
    <img src="/assets/image/img-default.jpg" class="img-thumbnail post-picture center-block" alt="photo">
    <div class="btn-group btn-group-justified" role="group" aria-label="...">
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Reply</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-heart"></span><small> Like</small></button>
     </div>
    </div>
   </div>

   <div class="soc-box">
    <div class="soc">
     <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
     <a href="homepage">username</a>
    </div>
    <div class="post-time text-right">
     <h6><span class="glyphicon glyphicon-time"></span> 15:09:40 11/01/2015</h6>
    </div>
    <p class="post-text"> Posts (Discussion topics over some services) that are
     published by others and shared by the user. </p>
    <div class="soc-shared-box">
     <div class="soc-shared">
      <a href="homepage"> other username:</a><span> Posts (Discussion topics over some services) that are published by the user.</span>
      <img src="/assets/image/img-default.jpg" class="img-thumbnail post-picture center-block" alt="photo">
     </div>
    </div>
    <div class="btn-group btn-group-justified" role="group" aria-label="...">
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Reply</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-heart"></span><small> Like</small></button>
     </div>
    </div>
   </div>

   <div class="soc-box">
    <div class="soc">
     <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
     <a href="homepage">username</a>
    </div>
    <div class="post-time text-right">
     <h6><span class="glyphicon glyphicon-time"></span> 20:16:20 10/30/2015</h6>
    </div>
    <p class="post-text">Posts (Discussion topics over some services) that are
     published by the user.</p>
    <img src="/assets/image/img-default.jpg" class="img-thumbnail post-picture center-block" alt="photo">
    <div class="btn-group btn-group-justified" role="group" aria-label="...">
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span><small> Reply</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-heart"></span><small> Like</small></button>
     </div>
    </div>
   </div>
  </div><!--/stream-list-->
 </div><!--leftcontent-->


</div><!--Content-->

""")))})),format.raw/*262.2*/("""
"""))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 07 07:23:24 UTC 2015
                    SOURCE: /home/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/mainpage.scala.html
                    HASH: 612405a0709bfdbe564b34b46aa2537f10091d02
                    MATRIX: 3247->1205|3284->1207|3310->1224|3350->1226|14618->12462
                    LINES: 60->19|61->20|61->20|61->20|303->262
                    -- GENERATED --
                */
            