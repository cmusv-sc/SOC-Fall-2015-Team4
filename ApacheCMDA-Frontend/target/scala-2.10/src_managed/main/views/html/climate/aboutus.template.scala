
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
object aboutus extends BaseScalaTemplate[play.api.templates.HtmlFormat.Appendable,Format[play.api.templates.HtmlFormat.Appendable]](play.api.templates.HtmlFormat) with play.api.templates.Template1[String,play.api.templates.HtmlFormat.Appendable] {

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
    def apply/*18.2*/(message: String):play.api.templates.HtmlFormat.Appendable = {
        _display_ {

Seq[Any](format.raw/*18.19*/("""

"""),_display_(Seq[Any](/*20.2*/main("About Us")/*20.18*/ {_display_(Seq[Any](format.raw/*20.20*/("""

   <h1>About Us</h1>
   	<div class="jumbotron">
   <p>We are a joint team between Jet Propulsion Laboratory (JPL) and Carnegie Mellon University (CMU).</p>
   <br>
   <h3><strong>JPL Contributors</strong></h3>
   <p>Seungwon Lee:		<a href="mailto:seungwon.lee@jpl.nasa.gov">seungwon.lee@jpl.nasa.gov</a></p>
   <p>Lei Pan:			<a href="mailto:lei.pan@jpl.nasa.gov">lei.pan@jpl.nasa.gov</a></p>
   <p>Chengxing Zhai:	<a href="mailto:chengxing.zhai@jpl.nasa.gov">chengxing.zhai@jpl.nasa.gov</a></p>
   <p>Benyang Tang:		<a href="mailto:benyang.tang@jpl.nasa.gov">benyang.tang@jpl.nasa.gov</a></p>
   <p>Terry Kubar:		<a href="mailto:terry.kubar@jpl.nasa.gov">terry.kubar@jpl.nasa.gov</a></p>
   <p>Frank Li:			<a href="mailto:juilin.li@jpl.nasa.gov">juilin.li@jpl.nasa.gov</a></p>
   <p>Jonathan Jiang:	<a href="mailto:jonathan.jiang@jpl.nasa.gov">jonathan.jiang@jpl.nasa.gov</a></p>
   <p>LJoao Teixeira:	<a href="mailto:joao.teixeira@jpl.nasa.gov">joao.teixeira@jpl.nasa.gov</a></p>
   <br>
   <h3><strong>CMU Contributors</strong></h3>
   <p>Wei Wang</p>
   <p>Xing Wei</p> 
   <p>Rao Li</p>
   <p>Chenran Gong</p>
   <p>Ming Qi</p>
   <p>Ruoxiao Wang</p>
   <p>Qihao Bao</p>
   <p>Zelin Zeng</p>
   <p>Xiatao Jin</p>
   <p>Yichen Liu</p>
   <p>Edward Huang</p>
   <p>Zhiyu Lin</p>  
   <p>Jian Jiao</p>
   <p>Juanchen Li</p>
   <br>
   <h3><strong>CMU Former Contributors</strong></h3>
   <p>Pinchao Wang</p>
   <p>Kang Fang</p>
   <p>Minghan Chen</p>
   <p>Chris Lee</p>
   <br>
   <h3><strong>CMU Advisor</strong></h3>
   <p>Jia Zhang		<a href="http://www.andrew.cmu.edu/user/jiaz/">Personal Website</a></p>
   <br>
   

   <h3><strong>Publications</strong></h3>
   <b>2015</b>
   <p>1. S. Lee. L. Pan, C. Zhai, B. Tang, T. Kubar, J. Zhang, and W. Wang, Climate Model Diagnostic Analyzer, submitted to 2015 IEEE International Conference on Big Data, Oct 29-Nov 01, 2015.</p>
   <p>2. J. Zhang, W. Wang, C. Lee, X. Wei, S. Lee, L. Pan, and T.J. Lee, "Climate Analytics Workflow Recommendation as a Service – Provenance-driven Automatic Workflow Mashup", in Proceedings of IEEE International Conference on Web Services (ICWS 2015), Jun. 27-Jul. 2, 2015, New York, NY, USA, pp. 89-97.</p>
   <b>2014</b>
   <p>3. J. Zhang, C. Lee, S. Xiao, P. Votava, T.J. Lee, R. Nemani and I. Foster, "A Community-Driven Workflow Recommendations and Reuse Infrastructure", accepted by The 8th IEEE International Symposium on Service-Oriented System Engineering (SOSE 2014).</p>
   <p>4. J. Zhang, D. Kuc, and S. Lu, "Confucius: A Tool Supporting Collaborative Scientific Workflow Composition", IEEE Transactions on Services Computing (TSC), 7(1), Jan.-Mar, 2014.<a href = "http://www.andrew.cmu.edu/user/jiaz/Papers/JiaZhang-Confucius-TSC.pdf">[pdf]</a></p>
   <b>2013</b>
   <p>5. J. Zhang, Z. Li, O. Sandoval, N. Xin, Y. Ren, B. Iannucci, M. Griss, S. Rosernberg, R.A. Martin, J. Cao, A. Rowe, "Supporting Personizable Virtual Internet of Things", in Proceedings of The 10th IEEE International Conference on Ubiquitous Intelligence and Computing (UIC-2013), Dec. 18-20, 2013, Vietri sul Mare, Italy.<a href = "http://www.andrew.cmu.edu/user/jiaz/Papers/JiaZhang-VirtualSensorEditor.pdf">[pdf]</a></p>
   <p>6. J. Zhang, N. Radia, Z. Li, N. Xin, Y. Ren, P. Sachdeva, P. Subramanyam, S. Hu, S. Luan, L. Lee, B. Xing, D. Li, J. Cao, T. Selker, B. Iannucci, M. Griss, A. Rowe, "An Infrastructure Supporting Considerate Sensor Service Provisioning", in Proceedings of the 6th IEEE International Conference on Service Oriented Computing and Applications (SOCA 2013), Dec. 16-18, 2013, Kauai, HA, USA.<a href="http://www.andrew.cmu.edu/user/jiaz/Papers/JiaZhang-SocialSensors.pdf">[pdf]</a></p>
   <p>7. L.-J. Zhang and J. Zhang, "Service Oriented Solution Modeling and Variation Propagation Analysis based on Architectural Building Blocks", International Journal of Web Services Research (JWSR), 10(4), 2013.</p>
   <p>8. J. Wang, Z. Feng, J. Zhang, P.C.K. Hung, K. He, and L.-J. Zhang, "A Unified RGPS-Based Approach Supporting Service-Oriented Process Customization", accepted as a book chapter in Web Services Foundations, edited by Athman Bouguettaya and Schahram Dustdar, Springer Verlag, pp. 657-682.</p>
   <p>9. J. Zhang, P. Votava, T.J. Lee, S. Adhikarla, I. Kulkumjon, M. Schlau, D. Natesan, R. Nemani, "A Technique of Analyzing Trust Relationships to Facilitate Scientific Service Discovery and Recommendation", in Proceedings of 2013 IEEE 10th International Conference on Services Computing (SCC), Jun. 27-Jul. 2, 2013, Santa Clara, CA, USA, pp. 57-64. (acceptance rate: 18%)<a href = "http://www.andrew.cmu.edu/user/jiaz/Papers/JiaZhang-TrustServiceDiscovery.pdf">[pdf]</a></p>
   <p>10. J. Zhang, B. Iannucci, M. Hennessy, K. Gopal, S. Xiao, S. Kumar, D. Pfeffer, B. Aljedia, Y. Ren, M. Griss, S. Rosenberg, J. Cao, A. Rowe, "Sensor Data as a Service - A Federated Platform for Mobile Data-Centric Service Development and Sharing", in Proceedings of 2013 IEEE 10th International Conference on Services Computing (SCC), Jun. 27-Jul. 2, 2013, Santa Clara, CA, USA, pp. 446-453.<a href="http://www.andrew.cmu.edu/user/jiaz/Papers/JiaZhang-SensorServicePlatform.pdf">[pdf]</a></p>
   <p>11. J. Zhang, P. Votava, T.J. Lee, O. Chu, C. Li, D. Liu, K. Liu, N. Xin, R. Nemani, "Bridging VisTrails Scientific Workflow Management System to High Performance Computing", IEEE 2013 7th International Workshop on Scientific Workflows (SWF), in Proceedings of 2013 IEEE 9th World Congress on Services (SERVICES), Jun. 27-Jul. 2, 2013, Santa Clara, CA, USA, pp. 29-36.<a href = "http://www.andrew.cmu.edu/user/jiaz/Papers/JiaZhang-VisTrails-HECC.pdf">[pdf]</a></p>
   <p>12. B. Plale, M.R. Lyu, J. Zhang (Eds.), 2013 IEEE 20th International Conference on Web Services (ICWS), Jun. 27-Jul. 2, 2013, Santa Clara, CA, USA, IEEE 2013.</p>
   <p>13. L.-J. Zhang and J. Zhang, "Technical Architecture of Enabling Body of Knowledge System for Effective Learning and Information Dissemination", International Journal of Web Services Research (JWSR), 10(2), 2013, pp. 41-62.<a href = "http://www.andrew.cmu.edu/user/jiaz/Papers/JiaZhang-BoK.pdf">[pdf]</a></p>
   <p>14. I. Bojanova, J. Zhang, J.M. Voas, "Cloud Computing", IEEE IT Professional, 15(2), 2013, pp. 12-14.</p>
</div>
""")))})))}
    }
    
    def render(message:String): play.api.templates.HtmlFormat.Appendable = apply(message)
    
    def f:((String) => play.api.templates.HtmlFormat.Appendable) = (message) => apply(message)
    
    def ref: this.type = this

}
                /*
                    -- GENERATED --
                    DATE: Fri Dec 04 00:59:07 EST 2015
                    SOURCE: /Users/X/Desktop/SOC-Fall-2015/ApacheCMDA-Frontend/app/views/climate/aboutus.scala.html
                    HASH: a0e5135b7554c04a0e56e57b12e5e053ec8c0d01
                    MATRIX: 3179->1205|3291->1222|3329->1225|3354->1241|3394->1243
                    LINES: 56->18|59->18|61->20|61->20|61->20
                    -- GENERATED --
                */
            