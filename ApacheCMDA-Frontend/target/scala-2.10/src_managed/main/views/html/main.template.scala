
package views.html

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
object main extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[String,Html,Html,play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(title: String, moreScripts: Html = Html(""))(content: Html):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*18.62*/("""

<!DOCTYPE html>

<html>
<head>

    <title>"""),_display_(Seq[Any](/*25.13*/title)),format.raw/*25.18*/("""</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet"
          href='"""),_display_(Seq[Any](/*31.18*/routes/*31.24*/.Assets.at("stylesheets/bootstrap.css"))),format.raw/*31.63*/("""'>
    <link rel="stylesheet" href='"""),_display_(Seq[Any](/*32.35*/routes/*32.41*/.Assets.at("css/login.css"))),format.raw/*32.68*/("""'>
    <link rel="stylesheet" href='"""),_display_(Seq[Any](/*33.35*/routes/*33.41*/.Assets.at("css/mainpage.css"))),format.raw/*33.71*/("""'>
    <link rel="stylesheet" href='"""),_display_(Seq[Any](/*34.35*/routes/*34.41*/.Assets.at("css/homepage.css"))),format.raw/*34.71*/("""'>

    <script src='"""),_display_(Seq[Any](/*36.19*/routes/*36.25*/.Assets.at("javascripts/jquery-1.9.0.min.js"))),format.raw/*36.70*/("""'
            type="text/javascript"></script>
    <script src='"""),_display_(Seq[Any](/*38.19*/routes/*38.25*/.Assets.at("javascripts/bootstrap.min.js"))),format.raw/*38.67*/("""'
            type="text/javascript"></script>

    """),_display_(Seq[Any](/*41.6*/moreScripts)),format.raw/*41.17*/("""
</head>

<body>
    """),_display_(Seq[Any](/*45.6*/content)),format.raw/*45.13*/("""
</body>
</html>
"""))}
    }
    
    def render(title:String,moreScripts:Html,content:Html): play.api.templates.HtmlFormat.Appendable = apply(title,moreScripts)(content)
    
    def f:((String,Html) => (Html) => play.api.templates.HtmlFormat.Appendable) = (title,moreScripts) => (content) => apply(title,moreScripts)(content)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Sat Nov 07 07:23:22 UTC 2015
                    SOURCE: /home/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/main.scala.html
                    HASH: a8d7b7ff82422e27463ae3d705c125d572a4de97
                    MATRIX: 3148->1189|3303->1249|3385->1295|3412->1300|3662->1514|3677->1520|3738->1559|3811->1596|3826->1602|3875->1629|3948->1666|3963->1672|4015->1702|4088->1739|4103->1745|4155->1775|4213->1797|4228->1803|4295->1848|4396->1913|4411->1919|4475->1961|4563->2014|4596->2025|4653->2047|4682->2054
                    LINES: 56->18|59->18|66->25|66->25|72->31|72->31|72->31|73->32|73->32|73->32|74->33|74->33|74->33|75->34|75->34|75->34|77->36|77->36|77->36|79->38|79->38|79->38|82->41|82->41|86->45|86->45
                    -- GENERATED --
                */
            