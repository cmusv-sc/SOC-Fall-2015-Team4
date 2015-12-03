
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

            var obj = """),format.raw/*22.23*/("""{"""),format.raw/*22.24*/("""
                postId : postId
            """),format.raw/*24.13*/("""}"""),format.raw/*24.14*/("""
            //alert(postId);
            $.ajax("""),format.raw/*26.20*/("""{"""),format.raw/*26.21*/("""
                url: "/deletePost",
                data: JSON.stringify(obj),
                headers: """),format.raw/*29.26*/("""{"""),format.raw/*29.27*/("""
                    'Content-Type': 'application/json'
                """),format.raw/*31.17*/("""}"""),format.raw/*31.18*/(""",
                type: "POST"
            """),format.raw/*33.13*/("""}"""),format.raw/*33.14*/(""").done(function(data) """),format.raw/*33.36*/("""{"""),format.raw/*33.37*/("""
                console.log(data);
                var response = data;
                if("error" in response)"""),format.raw/*36.40*/("""{"""),format.raw/*36.41*/("""
                    alert("delete error!")
                """),format.raw/*38.17*/("""}"""),format.raw/*38.18*/("""else"""),format.raw/*38.22*/("""{"""),format.raw/*38.23*/("""
                    window.location.reload();
                """),format.raw/*40.17*/("""}"""),format.raw/*40.18*/("""
            """),format.raw/*41.13*/("""}"""),format.raw/*41.14*/(""");
    """),format.raw/*42.5*/("""}"""),format.raw/*42.6*/("""

    function likePost(postId)"""),format.raw/*44.30*/("""{"""),format.raw/*44.31*/("""

        var obj = """),format.raw/*46.19*/("""{"""),format.raw/*46.20*/("""
            postId : postId
        """),format.raw/*48.9*/("""}"""),format.raw/*48.10*/("""
//        var likepost = document.getElementById(postId);
//        alert(postId);
        $.ajax("""),format.raw/*51.16*/("""{"""),format.raw/*51.17*/("""
            url: "/likePost",
            data: JSON.stringify(obj),
            headers: """),format.raw/*54.22*/("""{"""),format.raw/*54.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*56.13*/("""}"""),format.raw/*56.14*/(""",
            type: "POST"
        """),format.raw/*58.9*/("""}"""),format.raw/*58.10*/(""").done(function(data) """),format.raw/*58.32*/("""{"""),format.raw/*58.33*/("""
            console.log(data);
            var response = data;
            if("error" in response)"""),format.raw/*61.36*/("""{"""),format.raw/*61.37*/("""
                alert("like error!")
            """),format.raw/*63.13*/("""}"""),format.raw/*63.14*/("""else"""),format.raw/*63.18*/("""{"""),format.raw/*63.19*/("""
                window.location.reload();
            """),format.raw/*65.13*/("""}"""),format.raw/*65.14*/("""
        """),format.raw/*66.9*/("""}"""),format.raw/*66.10*/(""");
    """),format.raw/*67.5*/("""}"""),format.raw/*67.6*/("""

    function commentPost(postId)"""),format.raw/*69.33*/("""{"""),format.raw/*69.34*/("""
        $.get("/allComment/"+postId, function(data)"""),format.raw/*70.52*/("""{"""),format.raw/*70.53*/("""
            var commentServices = data;
            for (cid in commentServices) """),format.raw/*72.42*/("""{"""),format.raw/*72.43*/("""
                var json = commentServices[cid];
                var html = "<li><h6>"+json["time"]+"</h6>" +
                        json["commentUserId"] +"</a>&nbsp;replied:&nbsp;"+json["text"]+"</li>";
                //用下面的替换上面的html
//                var html = "<li><h6>"+json["time"]+"</h6>&nbsp;&nbsp;" +
//                        json["commentUserFirstName"] + "&nbsp;"+ json["commentUserLastName"] +"</a>&nbsp;replied:&nbsp;"+json["text"]+"</li>";
                $("#comment"+postId).append(html);
            """),format.raw/*80.13*/("""}"""),format.raw/*80.14*/("""
        """),format.raw/*81.9*/("""}"""),format.raw/*81.10*/(""");
        var commentBox = $('#commentBox'+postId);
        if (commentBox.css("display") == "none") """),format.raw/*83.50*/("""{"""),format.raw/*83.51*/("""
            commentBox.show();
        """),format.raw/*85.9*/("""}"""),format.raw/*85.10*/(""" else """),format.raw/*85.16*/("""{"""),format.raw/*85.17*/("""
            commentBox.hide();
        """),format.raw/*87.9*/("""}"""),format.raw/*87.10*/("""
    """),format.raw/*88.5*/("""}"""),format.raw/*88.6*/("""


    function submitComment(postId)"""),format.raw/*91.35*/("""{"""),format.raw/*91.36*/("""
        var obj = """),format.raw/*92.19*/("""{"""),format.raw/*92.20*/("""
            postId : postId,
            commentUserId : document.getElementById("commentUserId").value,
            //取消注释
//            commentUserFirstName : document.getElementById("commentUserFirstName").value,
//            commentUserLastName : document.getElementById("commentUserLastName").value,
        """),format.raw/*98.9*/("""}"""),format.raw/*98.10*/("""
        $.ajax("""),format.raw/*99.16*/("""{"""),format.raw/*99.17*/("""
            url: "/addComment",
            data: JSON.stringify(obj),
            headers: """),format.raw/*102.22*/("""{"""),format.raw/*102.23*/("""
                'Content-Type': 'application/json'
            """),format.raw/*104.13*/("""}"""),format.raw/*104.14*/(""",
            type: "POST"
        """),format.raw/*106.9*/("""}"""),format.raw/*106.10*/(""").done(function(data) """),format.raw/*106.32*/("""{"""),format.raw/*106.33*/("""
            window.location.reload();
        """),format.raw/*108.9*/("""}"""),format.raw/*108.10*/(""");
    """),format.raw/*109.5*/("""}"""),format.raw/*109.6*/("""
</script>
"""),_display_(Seq[Any](/*111.2*/self("Home Page")/*111.19*/ {_display_(Seq[Any](format.raw/*111.21*/("""

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
                """),_display_(Seq[Any](/*130.18*/if(!session.get("email"))/*130.43*/ {_display_(Seq[Any](format.raw/*130.45*/("""
                <form class="navbar-form navbar-right" action=""""),_display_(Seq[Any](/*131.65*/routes/*131.71*/.Application.login())),format.raw/*131.91*/("""">
                    <button type="submit" class="btn btn-success">Log in</button>
                </form>
                """)))}/*134.19*/else/*134.24*/{_display_(Seq[Any](format.raw/*134.25*/("""
                <li id="drop" class="dropdown nav-btn"><a href="#" class="dropdown-toggle" data-toggle="dropdown">
                    <span class="glyphicon glyphicon-user"></span> My Account<span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href=""""),_display_(Seq[Any](/*138.39*/routes/*138.45*/.UserController.homepage())),format.raw/*138.71*/("""">View Profile</a></li>
                        <li><a href=""""),_display_(Seq[Any](/*139.39*/routes/*139.45*/.UserController.editProfile())),format.raw/*139.74*/("""">Edit Profile</a></li>
                        <li><a href=""""),_display_(Seq[Any](/*140.39*/routes/*140.45*/.Application.logout())),format.raw/*140.66*/("""">Log out</a></li>
                    </ul>
                </li>
                """)))})),format.raw/*143.18*/("""
            </ul>
        </div><!--/navbar-collapse-->
    </div><!--/container-fluid-->
</nav>

<div class="row">
    <div id="wrapper1" class="col-md-10 col-md-offset-1">
        <div id="profile1">
            <img id="photo" src="/assets/image/default.jpg" class="img-circle center-block" alt="photo">
            <p class="text-center"><strong><a href="homepage">"""),_display_(Seq[Any](/*153.64*/session/*153.71*/.get("email"))),format.raw/*153.84*/("""</a></strong></p>
            <p class="text-center">"""),_display_(Seq[Any](/*154.37*/session/*154.44*/.get("firstName"))),format.raw/*154.61*/(""" """),_display_(Seq[Any](/*154.63*/session/*154.70*/.get("lastName"))),format.raw/*154.86*/("""</p>
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
                     <td><small><strong>"""),_display_(Seq[Any](/*176.42*/session/*176.49*/.get("firstName"))),format.raw/*176.66*/(""" """),_display_(Seq[Any](/*176.68*/session/*176.75*/.get("lastName"))),format.raw/*176.91*/("""</strong></small></td>
                 </tr>
                 <tr>
                     <td><span class="glyphicon glyphicon-heart"><small> Research</small></span></td>
                     <td><small><strong>"""),_display_(Seq[Any](/*180.42*/editUser/*180.50*/.getResearchFields())),format.raw/*180.70*/("""</strong></small></td>
                 </tr>
                 <tr>
                     <td><span class="glyphicon glyphicon-education"><small> Highest Degree</small></span></td>
                     <td><small><strong>"""),_display_(Seq[Any](/*184.42*/editUser/*184.50*/.getHighestDegree())),format.raw/*184.69*/("""</strong></small></td>
                 </tr>
                 <tr>
                     <td><span class="glyphicon glyphicon-phone-alt"><small> Phone</small></span></td>
                     <td><small><strong>"""),_display_(Seq[Any](/*188.42*/editUser/*188.50*/.getPhoneNumber())),format.raw/*188.67*/("""</strong></small></td>
                 </tr>
                 <tr>
                     <td><span class="glyphicon glyphicon-search"><small> Affiliation</small></span></td>
                     <td><small><strong>"""),_display_(Seq[Any](/*192.42*/editUser/*192.50*/.getAffiliation())),format.raw/*192.67*/("""</strong></small></td>
                 </tr>
             </table>
         </div>
         <!--<div class="line1"></div>-->
         <!--<div id="photo-list1">-->
             <!--<table id="photo-table1">-->
                 <!--<caption class="text-center"><strong> Gallery </strong></caption>-->
                 <!--<tr>-->
                     <!--<td><img src="/assets/image/img-default.jpg" alt="photos" class="img-thumbnail picture-lib1"></td>-->
                     <!--<td><img src="/assets/image/img-default.jpg" alt="photos" class="img-thumbnail picture-lib1"></td>-->
                 <!--</tr>-->
                 <!--<tr>-->
                     <!--<td><img src="/assets/image/img-default.jpg" alt="photos" class="img-thumbnail picture-lib1"></td>-->
                     <!--<td><img src="/assets/image/img-default.jpg" alt="photos" class="img-thumbnail picture-lib1"></td>-->
                 <!--</tr>-->
             <!--</table>-->
          <!--<br/>-->
         <!--</div>-->
         <!--<div class="line1" style="margin-top:20px;"></div><br/>-->
       </div>
    </div>
 <div id="rightcontent1" class="col-md-7">
     <div id="stream-list1">
         """),_display_(Seq[Any](/*216.11*/for(postService <- postServices) yield /*216.43*/{_display_(Seq[Any](format.raw/*216.44*/("""
         <div class="soc-box1">
             <div class="soc">
                 <img src="/assets/image/default.jpg" class="img-circle user-picture" alt="photo">
                 <a href="homepage">"""),_display_(Seq[Any](/*220.38*/postService/*220.49*/.getPostUserFirstName())),format.raw/*220.72*/(""" """),_display_(Seq[Any](/*220.74*/postService/*220.85*/.getPostUserLastName())),format.raw/*220.107*/("""</a>
             </div>
             <div class="post-time text-right">
                 <h6><span class="glyphicon glyphicon-time"></span> """),_display_(Seq[Any](/*223.70*/postService/*223.81*/.getTime())),format.raw/*223.91*/("""</h6>
             </div>
             <p class="post-text">"""),_display_(Seq[Any](/*225.36*/postService/*225.47*/.getText())),format.raw/*225.57*/("""</p>
             <div class="btn-group btn-group-justified" role="group" aria-label="...">
                 <div class="btn-group" role="group">
                     <button type="button" class="btn btn-default"><small><span class="glyphicon glyphicon-list-alt"></span> Share</small></button>
                 </div>
                 <div class="btn-group" role="group">
                     <button type="button" type="button" onclick="commentPost("""),_display_(Seq[Any](/*231.80*/postService/*231.91*/.getId())),format.raw/*231.99*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-list-alt"></span><small> Reply </small></button>
                 </div>
                 <div class="btn-group" role="group">
                     <button type="button" onclick="likePost("""),_display_(Seq[Any](/*234.63*/postService/*234.74*/.getId())),format.raw/*234.82*/(""","""),_display_(Seq[Any](/*234.84*/postService/*234.95*/.getLikes())),format.raw/*234.106*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-heart"></span><small> Like : <span id=""""),_display_(Seq[Any](/*234.206*/postService/*234.217*/.getId())),format.raw/*234.225*/("""">"""),_display_(Seq[Any](/*234.228*/postService/*234.239*/.getLikes())),format.raw/*234.250*/("""</span></small></button>
                 </div>
                 <div class="btn-group" role="group">
                     <button type="button"  data=""""),_display_(Seq[Any](/*237.52*/postService/*237.63*/.getId())),format.raw/*237.71*/("""" onclick="editPostById()" class="btn btn-default"><span class="glyphicon glyphicon-pencil"></span><small> Edit</small></button>
                 </div>
                 <div class="btn-group" role="group">
                     <button type="button" onclick="deletePostById("""),_display_(Seq[Any](/*240.69*/postService/*240.80*/.getId())),format.raw/*240.88*/(""")" class="btn btn-default"><span class="glyphicon glyphicon-trash"></span><small> Delete</small></button>
                 </div>
             </div>

             <div class="comment-box" style="display:none;" id="commentBox"""),_display_(Seq[Any](/*244.76*/postService/*244.87*/.getId())),format.raw/*244.95*/("""">
                 <div class="comment">
                     <ol class="list-unstyled" id="comment"""),_display_(Seq[Any](/*246.60*/postService/*246.71*/.getId())),format.raw/*246.79*/("""">
                     </ol>
                 </div>

                 """),_display_(Seq[Any](/*250.19*/helper/*250.25*/.form(action = routes.UserController.addComment)/*250.73*/ {_display_(Seq[Any](format.raw/*250.75*/("""
                 <form id="form"""),_display_(Seq[Any](/*251.33*/postService/*251.44*/.getId())),format.raw/*251.52*/("""" method="post">
                     <input type="hidden" name="postId" id="postId" value=""""),_display_(Seq[Any](/*252.77*/postService/*252.88*/.getId())),format.raw/*252.96*/("""">
                     <input class="form-control" type="hidden" name="commentUserId" id="commentUserId" value=""""),_display_(Seq[Any](/*253.112*/session/*253.119*/.get("userId"))),format.raw/*253.133*/("""">
                     <!--取消注释-->
                     <!--<input class="form-control" type="hidden" name="commentUserFirstName" id="commentUserFirstName" value=""""),_display_(Seq[Any](/*255.130*/session/*255.137*/.get("firstName"))),format.raw/*255.154*/("""">-->
                     <!--<input class="form-control" type="hidden" name="commentUserLastName" id="commentUserLastName" value=""""),_display_(Seq[Any](/*256.128*/session/*256.135*/.get("lastName"))),format.raw/*256.151*/("""">-->
                     <input type="text" class="form-control" placeholder="Type Your comment" name="text">
                     <button type="submit" class="btn btn-info pull-right submitBtn btn-xs" onclick="submitComment("""),_display_(Seq[Any](/*258.117*/postService/*258.128*/.getId())),format.raw/*258.136*/(""")">Submit</button>
                 </form>
                 """)))})),format.raw/*260.19*/("""
             </div>
         </div><br>
         """)))})),format.raw/*263.11*/("""

        </div>

    </div>

</div>
""")))})))}
    }
    
    def render(postServices:List[models.Post],commentForm:play.data.Form[models.Comment],editUser:models.User): play.api.templates.HtmlFormat.Appendable = apply(postServices,commentForm,editUser)
    
    def f:((List[models.Post],play.data.Form[models.Comment],models.User) => play.api.templates.HtmlFormat.Appendable) = (postServices,commentForm,editUser) => apply(postServices,commentForm,editUser)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Thu Dec 03 12:01:08 EST 2015
                    SOURCE: /Users/apple/test/SOC-Fall-2015-Team4-Lead-Shuting-Xi/ApacheCMDA-Frontend/app/views/climate/homepage.scala.html
                    HASH: d7935064833b71c2e29f999e52744144878d56bf
                    MATRIX: 3204->1188|3417->1289|3445->1307|3540->1374|3569->1375|3621->1399|3650->1400|3723->1445|3752->1446|3829->1495|3858->1496|3991->1601|4020->1602|4120->1674|4149->1675|4220->1718|4249->1719|4299->1741|4328->1742|4468->1854|4497->1855|4585->1915|4614->1916|4646->1920|4675->1921|4766->1984|4795->1985|4836->1998|4865->1999|4899->2006|4927->2007|4986->2038|5015->2039|5063->2059|5092->2060|5156->2097|5185->2098|5312->2197|5341->2198|5460->2289|5489->2290|5581->2354|5610->2355|5672->2390|5701->2391|5751->2413|5780->2414|5908->2514|5937->2515|6015->2565|6044->2566|6076->2570|6105->2571|6188->2626|6217->2627|6253->2636|6282->2637|6316->2644|6344->2645|6406->2679|6435->2680|6515->2732|6544->2733|6654->2815|6683->2816|7233->3338|7262->3339|7298->3348|7327->3349|7457->3451|7486->3452|7553->3492|7582->3493|7616->3499|7645->3500|7712->3540|7741->3541|7773->3546|7801->3547|7866->3584|7895->3585|7942->3604|7971->3605|8313->3920|8342->3921|8386->3937|8415->3938|8537->4031|8567->4032|8660->4096|8690->4097|8753->4132|8783->4133|8834->4155|8864->4156|8939->4203|8969->4204|9004->4211|9033->4212|9081->4224|9108->4241|9149->4243|10235->5292|10270->5317|10311->5319|10413->5384|10429->5390|10472->5410|10618->5537|10632->5542|10672->5543|11019->5853|11035->5859|11084->5885|11183->5947|11199->5953|11251->5982|11350->6044|11366->6050|11410->6071|11527->6155|11935->6526|11952->6533|11988->6546|12079->6600|12096->6607|12136->6624|12175->6626|12192->6633|12231->6649|13261->7642|13278->7649|13318->7666|13357->7668|13374->7675|13413->7691|13661->7902|13679->7910|13722->7930|13980->8151|13998->8159|14040->8178|14289->8390|14307->8398|14347->8415|14599->8630|14617->8638|14657->8655|15875->9836|15924->9868|15964->9869|16201->10069|16222->10080|16268->10103|16307->10105|16328->10116|16374->10138|16553->10280|16574->10291|16607->10301|16705->10362|16726->10373|16759->10383|17247->10834|17268->10845|17299->10853|17585->11102|17606->11113|17637->11121|17676->11123|17697->11134|17732->11145|17870->11245|17892->11256|17924->11264|17965->11267|17987->11278|18022->11289|18213->11443|18234->11454|18265->11462|18577->11737|18598->11748|18629->11756|18892->11982|18913->11993|18944->12001|19082->12102|19103->12113|19134->12121|19244->12194|19260->12200|19318->12248|19359->12250|19429->12283|19450->12294|19481->12302|19611->12395|19632->12406|19663->12414|19815->12528|19833->12535|19871->12549|20074->12714|20092->12721|20133->12738|20304->12871|20322->12878|20362->12894|20628->13122|20650->13133|20682->13141|20777->13203|20861->13254
                    LINES: 56->17|60->17|61->19|62->20|62->20|64->22|64->22|66->24|66->24|68->26|68->26|71->29|71->29|73->31|73->31|75->33|75->33|75->33|75->33|78->36|78->36|80->38|80->38|80->38|80->38|82->40|82->40|83->41|83->41|84->42|84->42|86->44|86->44|88->46|88->46|90->48|90->48|93->51|93->51|96->54|96->54|98->56|98->56|100->58|100->58|100->58|100->58|103->61|103->61|105->63|105->63|105->63|105->63|107->65|107->65|108->66|108->66|109->67|109->67|111->69|111->69|112->70|112->70|114->72|114->72|122->80|122->80|123->81|123->81|125->83|125->83|127->85|127->85|127->85|127->85|129->87|129->87|130->88|130->88|133->91|133->91|134->92|134->92|140->98|140->98|141->99|141->99|144->102|144->102|146->104|146->104|148->106|148->106|148->106|148->106|150->108|150->108|151->109|151->109|153->111|153->111|153->111|172->130|172->130|172->130|173->131|173->131|173->131|176->134|176->134|176->134|180->138|180->138|180->138|181->139|181->139|181->139|182->140|182->140|182->140|185->143|195->153|195->153|195->153|196->154|196->154|196->154|196->154|196->154|196->154|218->176|218->176|218->176|218->176|218->176|218->176|222->180|222->180|222->180|226->184|226->184|226->184|230->188|230->188|230->188|234->192|234->192|234->192|258->216|258->216|258->216|262->220|262->220|262->220|262->220|262->220|262->220|265->223|265->223|265->223|267->225|267->225|267->225|273->231|273->231|273->231|276->234|276->234|276->234|276->234|276->234|276->234|276->234|276->234|276->234|276->234|276->234|276->234|279->237|279->237|279->237|282->240|282->240|282->240|286->244|286->244|286->244|288->246|288->246|288->246|292->250|292->250|292->250|292->250|293->251|293->251|293->251|294->252|294->252|294->252|295->253|295->253|295->253|297->255|297->255|297->255|298->256|298->256|298->256|300->258|300->258|300->258|302->260|305->263
                    -- GENERATED --
                */
            