package springer.interview

import org.specs2.mutable.Specification

import Drawings._

class DrawingsSpec extends Specification {

  "canvasDrawing" should {
    "generate data to represent a canvas of" in {

      "1 * 1 dimension" in {
        canvasDrawing(1, 1)(List.empty) must_== List(List('-', '-', '-'),
                                                      List('|', ' ', '|'),
                                                      List('-', '-', '-'))
      }

      "0 * 0 dimension" in {
        canvasDrawing(0, 0)(List.empty) must_== List(List('-', '-'),
                                                     List('-', '-'))
      }

      "2 * 1 dimension" in {
        canvasDrawing(2, 1)(List.empty) must_== List(List('-', '-', '-', '-'),
                                                     List('|', ' ', ' ', '|'),
                                                     List('-', '-', '-', '-'))
      }
    }
  }


  "lineDrawing" should {
    "generate data to represent one line of" in {
      "one dot" in {
        lineDrawing(1, 1, 1, 1)(List(List('-', '-', '-'),
                                     List('|', ' ', '|'),
                                     List('-', '-', '-'))) must_== List(List('-', '-', '-'),
                                                                        List('|', 'x', '|'),
                                                                        List('-', '-', '-'))
      }

      "horizontal" in {
        lineDrawing(1, 2, 2, 2)(List(List('-', '-', '-', '-'),
                                     List('|', ' ', ' ', '|'),
                                     List('|', ' ', ' ', '|'),
                                     List('-', '-', '-', '-'))) must_== List(List('-', '-', '-', '-'),
                                                                             List('|', ' ', ' ', '|'),
                                                                             List('|', 'x', 'x', '|'),
                                                                             List('-', '-', '-', '-'))
      }

      "vertical" in {
        lineDrawing(1, 1, 1, 2)(List(List('-', '-', '-', '-'),
                                     List('|', ' ', ' ', '|'),
                                     List('|', ' ', ' ', '|'),
                                     List('-', '-', '-', '-'))) must_== List(List('-', '-', '-', '-'),
                                                                             List('|', 'x', ' ', '|'),
                                                                             List('|', 'x', ' ', '|'),
                                                                             List('-', '-', '-', '-'))
      }
    }
  }

  "bucketFillDrawing" should {
    "generate data to fill an empty canvas" in {
        bucketFill(1, 2, 'o')(List(List('-', '-', '-', '-'),
                                   List('|', ' ', ' ', '|'),
                                   List('|', ' ', ' ', '|'),
                                   List('-', '-', '-', '-'))) must_== List(List('-', '-', '-', '-'),
                                                                           List('|', 'o', 'o', '|'),
                                                                           List('|', 'o', 'o', '|'),
                                                                           List('-', '-', '-', '-'))
    }

    "generate data to fill a canvas divided by a horizontal line" in {
        bucketFill(1, 3, 'o')(List(List('-', '-', '-', '-'),
                                   List('|', ' ', ' ', '|'),
                                   List('|', 'x', 'x', '|'),
                                   List('|', ' ', ' ', '|'),
                                   List('-', '-', '-', '-'))) must_== List(List('-', '-', '-', '-'),
                                                                           List('|', ' ', ' ', '|'),
                                                                           List('|', 'x', 'x', '|'),
                                                                           List('|', 'o', 'o', '|'),
                                                                           List('-', '-', '-', '-'))
    }

    "generate data to fill a rectangle" in {
        bucketFill(2, 2, '0')(List(List('-', '-', '-', '-', '-'),
                                   List('|', 'x', 'x', 'x', '|'),
                                   List('|', 'x', ' ', 'x', '|'),
                                   List('|', 'x', 'x', 'x', '|'),
                                   List('|', ' ', ' ', ' ', '|'),
                                   List('-', '-', '-', '-', '-'))) must_== List(List('-', '-', '-', '-', '-'),
                                                                                List('|', 'x', 'x', 'x', '|'),
                                                                                List('|', 'x', '0', 'x', '|'),
                                                                                List('|', 'x', 'x', 'x', '|'),
                                                                                List('|', ' ', ' ', ' ', '|'),
                                                                                List('-', '-', '-', '-', '-'))
    }
  }


}