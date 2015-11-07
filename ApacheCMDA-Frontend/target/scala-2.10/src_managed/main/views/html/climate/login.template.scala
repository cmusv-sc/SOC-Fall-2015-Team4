
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
object login extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[User],play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(loginForm: play.data.Form[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._ 


Seq[Any](format.raw/*18.35*/("""
"""),format.raw/*20.1*/("""
"""),_display_(Seq[Any](/*21.2*/self("Login")/*21.15*/{_display_(Seq[Any](format.raw/*21.16*/("""
<div id="wrapper">
    """),_display_(Seq[Any](/*23.6*/form(routes.UserController.CheckUser())/*23.45*/ {_display_(Seq[Any](format.raw/*23.47*/("""
        <h1>Log in</h1>
        <p>
            <label for="username" class="uname" data-icon="u" > Username</label>
            <input id="username" name="userName" required="required" type="text" placeholder="Enter username"/>
        </p>
        <p>
            <label for="password" class="youpasswd" data-icon="p"> Password </label>
            <input id="password" name="password" required="required" type="password" placeholder="Enter password" />
        </p>
        <p class="keeplogin">
            <input type="checkbox" name="loginkeeping" id="loginkeeping" value="loginkeeping" />
            <label for="loginkeeping">Remember Me</label>
        </p>
        <p class="login button">
            <input type="submit" value="Login" onclick="location.href='mainpage';"/>
        </p>
    """)))})),format.raw/*40.6*/("""
    <div class="text-right">Don't have an account?
        <a href="register">Sign up &raquo;</a>
    </div>
</div>
""")))})),format.raw/*45.2*/("""
"""))}
    }
    
    def render(loginForm:play.data.Form[User]): play.api.templates.HtmlFormat.Appendable = apply(loginForm)
    
    def f:((play.data.Form[User]) => play.api.templates.HtmlFormat.Appendable) = (loginForm) => apply(loginForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 07 07:23:24 UTC 2015
                    SOURCE: /home/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/login.scala.html
                    HASH: 0955d0b5b54baac08626822ea228506eb02ed918
                    MATRIX: 3191->1204|3336->1237|3364->1256|3401->1258|3423->1271|3462->1272|3522->1297|3570->1336|3610->1338|4445->2142|4594->2260
                    LINES: 56->18|60->18|61->20|62->21|62->21|62->21|64->23|64->23|64->23|81->40|86->45
                    -- GENERATED --
                */
            