
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
object register extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[play.data.Form[User],play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(RegisterForm: play.data.Form[User]):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*18.38*/("""
"""),format.raw/*20.1*/("""

"""),_display_(Seq[Any](/*22.2*/self("Register")/*22.18*/ {_display_(Seq[Any](format.raw/*22.20*/("""

<div id="wrapper">
    """),_display_(Seq[Any](/*25.6*/form(routes.UserController.AddUser())/*25.43*/ {_display_(Seq[Any](format.raw/*25.45*/("""
        <h1> Sign up </h1>
        <p>
            <label for="usernamesignup" class="uname" data-icon="u">Username</label>
            <input id="usernamesignup" name="userName" required="required" type="text" placeholder="Enter Username" />
        </p>
        <p>
            <label for="emailsignup" class="youmail" data-icon="e" >Email Address</label>
            <input id="emailsignup" name="email" required="required" type="email" placeholder="Enter email address"/>
        </p>
        <p>
            <label for="passwordsignup" class="youpasswd" data-icon="p">Password </label>
            <input id="passwordsignup" name="password" required="required" type="password" placeholder="Enter password"/>
        </p>
        <p class="signin button">
            <input type="submit" value="Sign up" onclick="location.href='mainpage';"/>
        </p>
    """)))})),format.raw/*42.6*/("""
    <div class="text-right">Have an account? <a href="login">Log in &raquo;</a></div>
</div>
""")))})),format.raw/*45.2*/("""
"""))}
    }
    
    def render(RegisterForm:play.data.Form[User]): play.api.templates.HtmlFormat.Appendable = apply(RegisterForm)
    
    def f:((play.data.Form[User]) => play.api.templates.HtmlFormat.Appendable) = (RegisterForm) => apply(RegisterForm)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 07 07:23:24 UTC 2015
                    SOURCE: /home/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/register.scala.html
                    HASH: 01cd45dae90fa529ca234224ee600b911cdf87fd
                    MATRIX: 3194->1204|3341->1240|3369->1258|3407->1261|3432->1277|3472->1279|3533->1305|3579->1342|3619->1344|4516->2210|4642->2305
                    LINES: 56->18|60->18|61->20|63->22|63->22|63->22|66->25|66->25|66->25|83->42|86->45
                    -- GENERATED --
                */
            