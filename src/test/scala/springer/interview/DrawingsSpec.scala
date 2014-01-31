package springer.interview

import org.specs2.mutable.Specification
import java.io.StringWriter
import scala.io.Source

import Drawings._

class DrawingsSpec extends Specification {

  "canvasDrawing" should {
    "generate data to represent a canvas of" in {

      "1 * 1 dimension" in {
        canvasDrawing(1, 1)(List.empty) must_== List(List("-", "-", "-"),
                                                      List("|", " ", "|"),
                                                      List("-", "-", "-"))
      }

      "0 * 0 dimension" in {
        canvasDrawing(0, 0)(List.empty) must_== List(List("-", "-"),
                                                     List("-", "-"))
      }

      "2 * 1 dimension" in {
        canvasDrawing(2, 1)(List.empty) must_== List(List("-", "-", "-", "-"),
                                                     List("|", " ", " ", "|"),
                                                     List("-", "-", "-", "-"))
      }
    }
  }


  "lineDrawing" should {
    "generate data to represent one line of" in {
      "one dot" in {
        lineDrawing(1, 1, 1, 1)(List(List("-", "-", "-"),
                                     List("|", " ", "|"),
                                     List("-", "-", "-"))) must_== List(List("-", "-", "-"),
                                                                        List("|", "x", "|"),
                                                                        List("-", "-", "-"))
      }
    }
  }


}