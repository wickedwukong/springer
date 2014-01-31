package springer.interview

import org.specs2.mutable.Specification
import java.io.StringWriter
import scala.io.Source


class OutputListsSpec extends Specification {

   "toLists" should {
     import OutputLists._
     "generate data to represent a 1 * 1 canvas" in {

       toLists("C 1 1") must_== List(List("-", "-", "-"),
                                     List("|", " ", "|"),
                                     List("-", "-", "-"))

     }

   }
 }

