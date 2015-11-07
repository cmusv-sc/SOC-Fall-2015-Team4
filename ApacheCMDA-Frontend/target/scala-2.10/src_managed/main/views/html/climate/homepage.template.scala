
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
object homepage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template0[play.api.templates.HtmlFormat.Appendable] {

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
"""),_display_(Seq[Any](/*20.2*/self("Home Page")/*20.19*/ {_display_(Seq[Any](format.raw/*20.21*/("""

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
    <li class="nav-btn"><a href="mainpage"><span class="glyphicon glyphicon-home"></span> Home</a></li>
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
    <li class="nav-btn"><a href="#"><span class="glyphicon glyphicon-envelope"></span> Message</a></li>
   </ul>

   <div class="navbar-form navbar-right">
    <p id="welcome"><strong>Welcome back!<a href="homepage"> username </a></strong></p>
   </div>
  </div><!--/navbar-collapse-->
 </div><!--/container-fluid-->
</nav>

<div class="row">
 <div id="wrapper1" class="col-md-10 col-md-offset-1">
  <div id="profile1">
   <img id="user-photo1" src="/assets/image/default.jpg" class="img-circle center-block" alt="photo">
   <p class="text-center"><strong><a href="homepage">username</a></strong></p>
   <p class="text-center"><span class="glyphicon glyphicon-map-marker"></span> Location
    <span class="splitter">| </span><span class="glyphicon glyphicon-user"></span> Gender
   </p>
   <div style="margin-left:46%; margin-top:-8px;">
    <button type="button" class="btn btn-success btn-xs" name="follow" id="follow">
     <a href="#"><span style="color:white;">Follow</span></a>
    </button>
    <button type="button" class="btn btn-warning btn-xs" name="unblock" id="unblock">
     <a href="#"><span style="color:white;">Block</span></a>
    </button>
   </div>
  </div>
 </div>
</div>

<div id="content" class="row">
 <div id="leftcontent1" class="col-md-3 col-md-offset-1">
  <div id="sidebar1">
   <br>
   <div id="personal-info1">
    <table class="table table-striped">
     <caption class="text-center"><strong>Personal Information</strong></caption>
     <tr>
      <td><span class="glyphicon glyphicon-th-large"><small> Name</small></span></td>
      <td><small><strong>Name</strong></small></td>
     </tr>
     <tr>
      <td><span class="glyphicon glyphicon-heart"><small> Research</small></span></td>
      <td><small><strong>SOC, Web...</strong></small></td>
     </tr>
     <tr>
      <td><span class="glyphicon glyphicon-education"><small> Education</small></span></td>
      <td><small><strong>CMU</strong></small></td>
     </tr>
     <tr>
      <td><span class="glyphicon glyphicon-phone-alt"><small> Phone</small></span></td>
      <td><small><strong>123-456-7890</strong></small></td>
     </tr>
     <tr>
      <td><span class="glyphicon glyphicon-envelope"><small> E-mail</small></span></td>
      <td><small><strong>email</strong></small></td>
     </tr>
    </table>
   </div>
   <div class="line1"></div>
   <div id="photo-list1">
    <table id="photo-table1">
     <caption class="text-center"><strong> Gallery </strong></caption>
     <tr>
      <td><img src="/assets/image/img-default.jpg" alt="photos" class="img-thumbnail picture-lib1"></td>
      <td><img src="/assets/image/img-default.jpg" alt="photos" class="img-thumbnail picture-lib1"></td>
     </tr>
     <tr>
      <td><img src="/assets/image/img-default.jpg" alt="photos" class="img-thumbnail picture-lib1"></td>
      <td><img src="/assets/image/img-default.jpg" alt="photos" class="img-thumbnail picture-lib1"></td>
     </tr>
    </table>
    <br/>
   </div>
   <div class="line1" style="margin-top:20px;"></div><br/>
  </div>
 </div>
 <div id="rightcontent1" class="col-md-7">
  <div id="stream-list1">
   <div class="soc-box1">
    <div class="soc">
     <img src="/assets/image/default.jpg" class="img-circle user-picture1" alt="photo">
     <a href="homepage">username</a>
    </div>
    <div class="post-time1 text-right">
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
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Comment</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span><small> Edit</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span><small> Delete</small></button>
     </div>
    </div>
   </div>
   <div class="soc-box1">
    <div class="soc1">
     <img src="/assets/image/default.jpg" class="img-circle user-picture1" alt="photo">
     <a href="homepage">username</a>
    </div>
    <div class="post-time1 text-right">
     <h6><span class="glyphicon glyphicon-time"></span> 15:09:40 11/01/2015</h6>
    </div>
    <p class="post-text"> Posts (Discussion topics over some services) that are
     published by others and shared by the user. </p>
    <div class="soc-shared-box1">
     <div class="soc-shared1">
      <a href="homepage"> other username:</a><span> Posts (Discussion topics over some services) that are published by the user.</span>
      <img src="/assets/image/img-default.jpg" class="img-thumbnail post-picture center-block" alt="photo">
     </div>
    </div>
    <div class="btn-group btn-group-justified" role="group" aria-label="...">
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Comment</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span><small> Edit</small></button>
     </div>
     <div class="btn-group" role="group">
      <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span><small> Delete</small></button>
     </div>
    </div>
   </div>
   <br/>
  </div>
 </div>
</div>
""")))})))}
    }
    
    def render(): play.api.templates.HtmlFormat.Appendable = apply()
    
    def f:(() => play.api.templates.HtmlFormat.Appendable) = () => apply()
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 07 07:23:24 UTC 2015
                    SOURCE: /home/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/homepage.scala.html
                    HASH: a95ce830fc6d67d8fe2ed7380d4d85a49e148d07
                    MATRIX: 3247->1205|3284->1207|3310->1224|3350->1226
                    LINES: 60->19|61->20|61->20|61->20
                    -- GENERATED --
                */
            