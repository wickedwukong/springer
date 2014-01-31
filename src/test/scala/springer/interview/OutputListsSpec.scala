package springer.interview

import org.specs2.mutable.Specification
import java.io.StringWriter
import scala.io.Source

import OutputLists._

class OutputListsSpec extends Specification {

   "toLists" should {
     "generate data to represent a canvas of" in {

       "1 * 1 dimension" in {
         toLists("C 1 1") must_== List(List("-", "-", "-"),
           List("|", " ", "|"),
           List("-", "-", "-"))
       }

       "0 * 0 dimension" in {
         toLists("C 0 0") must_== List(List("-", "-"),
           List("-", "-"))
       }

       "2 * 1 dimension" in {
         toLists("C 2 1") must_== List(List("-", "-", "-", "-"),
           List("|", " ", " ", "|"),
           List("-", "-", "-", "-"))
       }
     }
   }
 }

