
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
object homepage extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template3[List[models.Post],play.data.Form[models.Comment],models.User,play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*17.2*/(postServices: List[models.Post], commentForm: play.data.Form[models.Comment], editUser: models.User):play.api.templates.HtmlFormat.Appendable = {
        _display_ {import helper._


Seq[Any](format.raw/*17.103*/("""
"""),format.raw/*19.1*/("""<script type="text/javascript">
    function deletePostById(postId)"""),format.raw/*20.36*/("""{"""),format.raw/*20.37*/("""
            var obj = """),format.raw/*21.23*/("""{"""),format.raw/*21.24*/("""
                postId : postId
            """),format.raw/*23.13*/("""}"""),format.raw/*23.14*/("""
            $.ajax("""),format.raw/*24.20*/("""{"""),format.raw/*24.21*/("""
                url: "/deletePost",
                data: JSON.stringify(obj),
                headers: """),format.raw/*27.26*/("""{"""),format.raw/*27.27*/("""
                    'Content-Type': 'application/json'
                """),format.raw/*29.17*/("""}"""),format.raw/*29.18*/(""",
                type: "POST"
            """),format.raw/*31.13*/("""}"""),format.raw/*31.14*/(""").done(function(data) """),format.raw/*31.36*/("""{"""),format.raw/*31.37*/("""
                var response = data;
                if("error" in response)"""),format.raw/*33.40*/("""{"""),format.raw/*33.41*/("""
                    alert("delete error!")
                """),format.raw/*35.17*/("""}"""),format.raw/*35.18*/("""else"""),format.raw/*35.22*/("""{"""),format.raw/*35.23*/("""
                    window.location.reload();
                """),format.raw/*37.17*/("""}"""),format.raw/*37.18*/("""
            """),format.raw/*38.13*/("""}"""),format.raw/*38.14*/(""");
    """),format.raw/*39.5*/("""}"""),format.raw/*39.6*/("""

    function likePost(postId)"""),format.raw/*41.30*/("""{"""),format.raw/*41.31*/("""
        var obj = """),format.raw/*42.19*/("""{"""),format.raw/*42.20*/("""
            postId : postId
        """),format.raw/*44.9*/("""}"""),format.raw/*44.10*/("""
        $.ajax("""),format.raw/*45.16*/("""{"""),format.raw/*45.17*/("""
            url: "/likePost",
            data: JSON.stringify(obj),
            headers: """),format.raw/*48.22*/("""{"""),format.raw/*48.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*50.13*/("""}"""),format.raw/*50.14*/(""",
            type: "POST"
        """),format.raw/*52.9*/("""}"""),format.raw/*52.10*/(""").done(function(data) """),format.raw/*52.32*/("""{"""),format.raw/*52.33*/("""
            var response = data;
            if("error" in response)"""),format.raw/*54.36*/("""{"""),format.raw/*54.37*/("""
                alert("like error!")
            """),format.raw/*56.13*/("""}"""),format.raw/*56.14*/("""else"""),format.raw/*56.18*/("""{"""),format.raw/*56.19*/("""
                window.location.reload();
            """),format.raw/*58.13*/("""}"""),format.raw/*58.14*/("""
        """),format.raw/*59.9*/("""}"""),format.raw/*59.10*/(""");
    """),format.raw/*60.5*/("""}"""),format.raw/*60.6*/("""

    function sharePost(postId)"""),format.raw/*62.31*/("""{"""),format.raw/*62.32*/("""
           var obj = """),format.raw/*63.22*/("""{"""),format.raw/*63.23*/("""
               postId : postId,
               postUserId : document.getElementById("inputUserId").value,
               postUserFirstName : document.getElementById("inputUserFirstName").value,
               postUserLastName : document.getElementById("inputUserLastName").value,
           """),format.raw/*68.12*/("""}"""),format.raw/*68.13*/("""
           $.ajax("""),format.raw/*69.19*/("""{"""),format.raw/*69.20*/("""
               url: "/sharePost",
               data: JSON.stringify(obj),
               headers: """),format.raw/*72.25*/("""{"""),format.raw/*72.26*/("""
                   'Content-Type': 'application/json'
               """),format.raw/*74.16*/("""}"""),format.raw/*74.17*/(""",
               type: "POST"
           """),format.raw/*76.12*/("""}"""),format.raw/*76.13*/(""").done(function(data) """),format.raw/*76.35*/("""{"""),format.raw/*76.36*/("""
              window.location.reload();
           """),format.raw/*78.12*/("""}"""),format.raw/*78.13*/(""");
       """),format.raw/*79.8*/("""}"""),format.raw/*79.9*/("""

       function editPost(postId, text)"""),format.raw/*81.39*/("""{"""),format.raw/*81.40*/("""
              var ntext = prompt("Edit here:",text);
              var obj = """),format.raw/*83.25*/("""{"""),format.raw/*83.26*/("""
                  postId : postId,
                  text : ntext,
              """),format.raw/*86.15*/("""}"""),format.raw/*86.16*/("""
              $.ajax("""),format.raw/*87.22*/("""{"""),format.raw/*87.23*/("""
                  url: "/editPost",
                  data: JSON.stringify(obj),
                  headers: """),format.raw/*90.28*/("""{"""),format.raw/*90.29*/("""
                      'Content-Type': 'application/json'
                  """),format.raw/*92.19*/("""}"""),format.raw/*92.20*/(""",
                  type: "POST"
              """),format.raw/*94.15*/("""}"""),format.raw/*94.16*/(""").done(function(data) """),format.raw/*94.38*/("""{"""),format.raw/*94.39*/("""
                  window.location.reload();
              """),format.raw/*96.15*/("""}"""),format.raw/*96.16*/(""");
          """),format.raw/*97.11*/("""}"""),format.raw/*97.12*/("""

    function commentPost(postId)"""),format.raw/*99.33*/("""{"""),format.raw/*99.34*/("""
          var commentBox = $('#commentBox'+postId);
          if (commentBox.css("display") == "none") """),format.raw/*101.52*/("""{"""),format.raw/*101.53*/("""
              commentBox.show();
              $.get("/allComment/"+postId, function(data)"""),format.raw/*103.58*/("""{"""),format.raw/*103.59*/("""
                  $("#comment"+postId).empty();
                  var commentServices = data;
                  if("error" in commentServices) return;
                  for (cid in commentServices) """),format.raw/*107.48*/("""{"""),format.raw/*107.49*/("""
                      var json = commentServices[cid];
                      var html = "<li><h6>"+json["time"]+"</h6>&nbsp;&nbsp;" +
                       json["commentUserFirstName"] + "&nbsp;"+ json["commentUserLastName"]
                       +"</a>&nbsp;replied:&nbsp;"+json["text"]+"</li>";
                       $("#comment"+postId).append(html);
                     """),format.raw/*113.22*/("""}"""),format.raw/*113.23*/("""
              """),format.raw/*114.15*/("""}"""),format.raw/*114.16*/(""");
            """),format.raw/*115.13*/("""}"""),format.raw/*115.14*/(""" else """),format.raw/*115.20*/("""{"""),format.raw/*115.21*/("""
              commentBox.hide();
            """),format.raw/*117.13*/("""}"""),format.raw/*117.14*/("""
    """),format.raw/*118.5*/("""}"""),format.raw/*118.6*/("""
</script>
"""),_display_(Seq[Any](/*120.2*/self("Home Page")/*120.19*/ {_display_(Seq[Any](format.raw/*120.21*/("""

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
            <ul class="nav nav-pills navbar-right">
                <li  class="nav-btn"><a href="mainpage"><span class="glyphicon glyphicon-home"></span> Home</a></li>
                """),_display_(Seq[Any](/*139.18*/if(!session.get("email"))/*139.43*/ {_display_(Seq[Any](format.raw/*139.45*/("""
                <form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*140.65*/routes/*140.71*/.Application.login())),format.raw/*140.91*/("""">
                    <button type="submit" class="btn btn-success">Log in</button>
                </form>
                """)))}/*143.19*/else/*143.24*/{_display_(Seq[Any](format.raw/*143.25*/("""
                <li id="drop" class="dropdown nav-btn"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user"></span> My Account<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href=""""),_display_(Seq[Any](/*147.39*/routes/*147.45*/.UserController.homepage())),format.raw/*147.71*/("""">View Profile</a></li>
                        <li><a href=""""),_display_(Seq[Any](/*148.39*/routes/*148.45*/.UserController.editProfile())),format.raw/*148.74*/("""">Edit Profile</a></li>
                        <li><a href=""""),_display_(Seq[Any](/*149.39*/routes/*149.45*/.Application.logout())),format.raw/*149.66*/("""">Log out</a></li>
                    </ul>
                </li>
                """)))})),format.raw/*152.18*/("""
            </ul>
        </div><!--/navbar-collapse-->
    </div><!--/container-fluid-->
</nav>

<div class="row">
    <div id="wrapper1" class="col-md-10 col-md-offset-1">
        <div id="profile1">
            <img id="photo" src="/assets/image/default.jpg" class="img-circle center-block" alt="photo">
            <p class="text-center"><strong><a href="homepage">"""),_display_(Seq[Any](/*162.64*/session/*162.71*/.get("email"))),format.raw/*162.84*/("""</a></strong></p>
            <p class="text-center">"""),_display_(Seq[Any](/*163.37*/session/*163.44*/.get("firstName"))),format.raw/*163.61*/(""" """),_display_(Seq[Any](/*163.63*/session/*163.70*/.get("lastName"))),format.raw/*163.86*/("""</p>
            <div style="margin-left:46%; margin-top:-8px;">
                <button type="button" class="btn btn-success btn-xs" name="follow" id="follow">
                    <a href="#"><span style="color:white;">Follow</span></a>
                </button>
                <button type="button" class="btn btn-warning btn-xs" name="unblock" id="unblock">
                    <a href="#"><span style="color:white;">Block</span></a>
                </button>
            </div>
            <input id="inputUserId" type="hidden" value=""""),_display_(Seq[Any](/*172.59*/session/*172.66*/.get("userId"))),format.raw/*172.80*/(""""></input>
            <input id="inputUserFirstName" type="hidden" value=""""),_display_(Seq[Any](/*173.66*/session/*173.73*/.get("firstName"))),format.raw/*173.90*/(""""></input>
            <input id="inputUserLastName" type="hidden" value=""""),_display_(Seq[Any](/*174.65*/session/*174.72*/.get("lastName"))),format.raw/*174.88*/(""""></input>
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
                     <td><small><strong>"""),_display_(Seq[Any](/*188.42*/session/*188.49*/.get("firstName"))),format.raw/*188.66*/(""" """),_display_(Seq[Any](/*188.68*/session/*188.75*/.get("lastName"))),format.raw/*188.91*/("""</strong></small></td>
                 </tr>
                 <tr>
                     <td><span class="glyphicon glyphicon-heart"><small> Research</small></span></td>
                     <td><small><strong>"""),_display_(Seq[Any](/*192.42*/editUser/*192.50*/.getResearchFields())),format.raw/*192.70*/("""</strong></small></td>
                 </tr>
                 <tr>
                     <td><span class="glyphicon glyphicon-education"><small> Highest Degree</small></span></td>
                     <td><small><strong>"""),_display_(Seq[Any](/*196.42*/editUser/*196.50*/.getHighestDegree())),format.raw/*196.69*/("""</strong></small></td>
                 </tr>
                 <tr>
                     <td><span class="glyphicon glyphicon-phone-alt"><small> Phone</small></span></td>
                     <td><small><strong>"""),_display_(Seq[Any](/*200.42*/editUser/*200.50*/.getPhoneNumber())),format.raw/*200.67*/("""</strong></small></td>
                 </tr>
                 <tr>
                     <td><span class="glyphicon glyphicon-search"><small> Affiliation</small></span></td>
                     <td><small><strong>"""),_display_(Seq[Any](/*204.42*/editUser/*204.50*/.getAffiliation())),format.raw/*204.67*/("""</strong></small></td>
                 </tr>
             </table>
         </div>
       </div>
    </div>
 <div id="rightcontent1" class="col-md-7">
     <div id="stream-list1">
         """),_display_(Seq[Any](/*212.11*/for(postService <- postServices) yield /*212.43*/{_display_(Seq[Any](format.raw/*212.44*/("""
         <div class="soc-box1">
             <div class="soc">
                 <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
                 <a href="homepage">"""),_display_(Seq[Any](/*216.38*/postService/*216.49*/.getPostUserFirstName())),format.raw/*216.72*/(""" """),_display_(Seq[Any](/*216.74*/postService/*216.85*/.getPostUserLastName())),format.raw/*216.107*/("""</a>
             </div>
             <div class="post-time text-right">
                 <h6><span class="glyphicon glyphicon-time"></span> """),_display_(Seq[Any](/*219.70*/postService/*219.81*/.getTime())),format.raw/*219.91*/("""</h6>
             </div>
             <p class="post-text">"""),_display_(Seq[Any](/*221.36*/postService/*221.47*/.getText())),format.raw/*221.57*/("""</p>
             <div class="btn-group btn-group-justified" role="group" aria-label="...">
               <div class="btn-group" role="group">
                   <button type="button" onclick="sharePost("""),_display_(Seq[Any](/*224.62*/postService/*224.73*/.getId())),format.raw/*224.81*/(""")" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share </small></button>
               </div>
                 <div class="btn-group" role="group">
                     <button type="button" type="button" onclick="commentPost("""),_display_(Seq[Any](/*227.80*/postService/*227.91*/.getId())),format.raw/*227.99*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Reply </small></button>
                 </div>
                 <div class="btn-group" role="group">
                     <button type="button" onclick="likePost("""),_display_(Seq[Any](/*230.63*/postService/*230.74*/.getId())),format.raw/*230.82*/(""","""),_display_(Seq[Any](/*230.84*/postService/*230.95*/.getLikes())),format.raw/*230.106*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-heart"></span><small> Like : <span id=""""),_display_(Seq[Any](/*230.206*/postService/*230.217*/.getId())),format.raw/*230.225*/("""">"""),_display_(Seq[Any](/*230.228*/postService/*230.239*/.getLikes())),format.raw/*230.250*/("""</span></small></button>
                 </div>
                 <div class="btn-group" role="group">
                     <button type="button" onclick="editPost('"""),_display_(Seq[Any](/*233.64*/postService/*233.75*/.getId())),format.raw/*233.83*/("""','"""),_display_(Seq[Any](/*233.87*/postService/*233.98*/.getText())),format.raw/*233.108*/("""')" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> EditHere! </small></button>
                 </div>
                 <div class="btn-group" role="group">
                     <button type="button" onclick="deletePostById("""),_display_(Seq[Any](/*236.69*/postService/*236.80*/.getId())),format.raw/*236.88*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span><small> Delete</small></button>
                 </div>
             </div>

             <div class="comment-box" style="display:none;" id="commentBox"""),_display_(Seq[Any](/*240.76*/postService/*240.87*/.getId())),format.raw/*240.95*/("""">
                 <div class="comment">
                     <ol class="list-unstyled" id="comment"""),_display_(Seq[Any](/*242.60*/postService/*242.71*/.getId())),format.raw/*242.79*/("""">
                     </ol>
                 </div>

                 """),_display_(Seq[Any](/*246.19*/helper/*246.25*/.form(action = routes.UserController.addComment)/*246.73*/ {_display_(Seq[Any](format.raw/*246.75*/("""
                     <form id="form"""),_display_(Seq[Any](/*247.37*/postService/*247.48*/.getId())),format.raw/*247.56*/("""" method="post">
                         <input type="hidden" name="postId" id="postId" value=""""),_display_(Seq[Any](/*248.81*/postService/*248.92*/.getId())),format.raw/*248.100*/("""">
                         <input type="hidden" name="homepageflag" id="homepageflag" value="homepageflag">
                         <input class="form-control" type="hidden" name="commentUserId" id="commentUserId" value=""""),_display_(Seq[Any](/*250.116*/session/*250.123*/.get("userId"))),format.raw/*250.137*/("""">
                         <input type="text" class="form-control" placeholder="Type Your comment" name="text">
                         <button type="submit" class="btn btn-info pull-right submitBtn btn-xs">Submit</button>
                     </form>
                 """)))})),format.raw/*254.19*/("""
             </div>
         </div><br>
         """)))})),format.raw/*257.11*/("""
        </div>
    </div>
</div>
""")))})),format.raw/*261.2*/("""
"""))}
    }
    
    def render(postServices:List[models.Post],commentForm:play.data.Form[models.Comment],editUser:models.User): play.api.templates.HtmlFormat.Appendable = apply(postServices,commentForm,editUser)
    
    def f:((List[models.Post],play.data.Form[models.Comment],models.User) => play.api.templates.HtmlFormat.Appendable) = (postServices,commentForm,editUser) => apply(postServices,commentForm,editUser)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 04 15:27:34 EST 2015
                    SOURCE: /Users/X/Desktop/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/homepage.scala.html
                    HASH: 350c4471c075d280ad4914f7b8755fe9b34c7a7d
                    MATRIX: 3204->1188|3417->1289|3445->1307|3540->1374|3569->1375|3620->1398|3649->1399|3722->1444|3751->1445|3799->1465|3828->1466|3961->1571|3990->1572|4090->1644|4119->1645|4190->1688|4219->1689|4269->1711|4298->1712|4403->1789|4432->1790|4520->1850|4549->1851|4581->1855|4610->1856|4701->1919|4730->1920|4771->1933|4800->1934|4834->1941|4862->1942|4921->1973|4950->1974|4997->1993|5026->1994|5090->2031|5119->2032|5163->2048|5192->2049|5311->2140|5340->2141|5432->2205|5461->2206|5523->2241|5552->2242|5602->2264|5631->2265|5728->2334|5757->2335|5835->2385|5864->2386|5896->2390|5925->2391|6008->2446|6037->2447|6073->2456|6102->2457|6136->2464|6164->2465|6224->2497|6253->2498|6303->2520|6332->2521|6652->2813|6681->2814|6728->2833|6757->2834|6886->2935|6915->2936|7013->3006|7042->3007|7111->3048|7140->3049|7190->3071|7219->3072|7299->3124|7328->3125|7365->3135|7393->3136|7461->3176|7490->3177|7596->3255|7625->3256|7735->3338|7764->3339|7814->3361|7843->3362|7980->3471|8009->3472|8113->3548|8142->3549|8217->3596|8246->3597|8296->3619|8325->3620|8412->3679|8441->3680|8482->3693|8511->3694|8573->3728|8602->3729|8735->3833|8765->3834|8885->3925|8915->3926|9143->4125|9173->4126|9581->4505|9611->4506|9655->4521|9685->4522|9729->4537|9759->4538|9794->4544|9824->4545|9899->4591|9929->4592|9962->4597|9991->4598|10039->4610|10066->4627|10107->4629|11193->5678|11228->5703|11269->5705|11371->5770|11387->5776|11430->5796|11576->5923|11590->5928|11630->5929|11977->6239|11993->6245|12042->6271|12141->6333|12157->6339|12209->6368|12308->6430|12324->6436|12368->6457|12485->6541|12893->6912|12910->6919|12946->6932|13037->6986|13054->6993|13094->7010|13133->7012|13150->7019|13189->7035|13767->7576|13784->7583|13821->7597|13934->7673|13951->7680|13991->7697|14103->7772|14120->7779|14159->7795|14717->8316|14734->8323|14774->8340|14813->8342|14830->8349|14869->8365|15117->8576|15135->8584|15178->8604|15436->8825|15454->8833|15496->8852|15745->9064|15763->9072|15803->9089|16055->9304|16073->9312|16113->9329|16341->9520|16390->9552|16430->9553|16667->9753|16688->9764|16734->9787|16773->9789|16794->9800|16840->9822|17019->9964|17040->9975|17073->9985|17171->10046|17192->10057|17225->10067|17467->10272|17488->10283|17519->10291|17820->10555|17841->10566|17872->10574|18158->10823|18179->10834|18210->10842|18249->10844|18270->10855|18305->10866|18443->10966|18465->10977|18497->10985|18538->10988|18560->10999|18595->11010|18798->11176|18819->11187|18850->11195|18891->11199|18912->11210|18946->11220|19243->11480|19264->11491|19295->11499|19558->11725|19579->11736|19610->11744|19748->11845|19769->11856|19800->11864|19910->11937|19926->11943|19984->11991|20025->11993|20099->12030|20120->12041|20151->12049|20285->12146|20306->12157|20338->12165|20600->12389|20618->12396|20656->12410|20961->12682|21045->12733|21112->12768
                    LINES: 56->17|60->17|61->19|62->20|62->20|63->21|63->21|65->23|65->23|66->24|66->24|69->27|69->27|71->29|71->29|73->31|73->31|73->31|73->31|75->33|75->33|77->35|77->35|77->35|77->35|79->37|79->37|80->38|80->38|81->39|81->39|83->41|83->41|84->42|84->42|86->44|86->44|87->45|87->45|90->48|90->48|92->50|92->50|94->52|94->52|94->52|94->52|96->54|96->54|98->56|98->56|98->56|98->56|100->58|100->58|101->59|101->59|102->60|102->60|104->62|104->62|105->63|105->63|110->68|110->68|111->69|111->69|114->72|114->72|116->74|116->74|118->76|118->76|118->76|118->76|120->78|120->78|121->79|121->79|123->81|123->81|125->83|125->83|128->86|128->86|129->87|129->87|132->90|132->90|134->92|134->92|136->94|136->94|136->94|136->94|138->96|138->96|139->97|139->97|141->99|141->99|143->101|143->101|145->103|145->103|149->107|149->107|155->113|155->113|156->114|156->114|157->115|157->115|157->115|157->115|159->117|159->117|160->118|160->118|162->120|162->120|162->120|181->139|181->139|181->139|182->140|182->140|182->140|185->143|185->143|185->143|189->147|189->147|189->147|190->148|190->148|190->148|191->149|191->149|191->149|194->152|204->162|204->162|204->162|205->163|205->163|205->163|205->163|205->163|205->163|214->172|214->172|214->172|215->173|215->173|215->173|216->174|216->174|216->174|230->188|230->188|230->188|230->188|230->188|230->188|234->192|234->192|234->192|238->196|238->196|238->196|242->200|242->200|242->200|246->204|246->204|246->204|254->212|254->212|254->212|258->216|258->216|258->216|258->216|258->216|258->216|261->219|261->219|261->219|263->221|263->221|263->221|266->224|266->224|266->224|269->227|269->227|269->227|272->230|272->230|272->230|272->230|272->230|272->230|272->230|272->230|272->230|272->230|272->230|272->230|275->233|275->233|275->233|275->233|275->233|275->233|278->236|278->236|278->236|282->240|282->240|282->240|284->242|284->242|284->242|288->246|288->246|288->246|288->246|289->247|289->247|289->247|290->248|290->248|290->248|292->250|292->250|292->250|296->254|299->257|303->261
                    -- GENERATED --
                */
            