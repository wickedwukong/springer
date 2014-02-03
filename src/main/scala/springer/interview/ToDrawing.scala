package springer.interview

import springer.interview.Drawings._
import scala.Some

object SupportedCommand {
  def unapply(rawInstruction: String)  = {
    rawInstruction.split(" ").toList match {
      case "C" :: tail => {
        val canvasDimension: List[Int] = tail.take(2).map(_.toInt)
        Some(canvasDrawing(canvasDimension(0), canvasDimension(1)))
      }
      case "L" :: tail => {
        val lineStartAndEnd: List[Int] = tail.take(4).map(_.toInt)
        Some(lineDrawing(lineStartAndEnd(0), lineStartAndEnd(1), lineStartAndEnd(2), lineStartAndEnd(3)))
      }
      case "R" :: tail => {
        val topLeftCornerAndBottomRightCorner: List[Int] = tail.take(4).map(_.toInt)
        Some(rectangleDrawing(topLeftCornerAndBottomRightCorner(0), topLeftCornerAndBottomRightCorner(1), topLeftCornerAndBottomRightCorner(2), topLeftCornerAndBottomRightCorner(3)))
      }
      case "B" :: tail => {
        val color = tail(2).head
        val startingPoint: List[Int] = tail.take(2).map(_.toInt)
        Some(bucketFill(startingPoint(0), startingPoint(1), color))
      }
      case _ => None
    }
  }
}


object toDrawing {
  import Drawings._

  def apply(rawInstruction: String):  Canvas => Canvas = {
      rawInstruction.split(" ").toList match {
        case "C" :: tail => {
          val canvasDimension: List[Int] = tail.take(2).map(_.toInt)
          canvasDrawing(canvasDimension(0), canvasDimension(1))
        }
        case "L" :: tail => {
          val lineStartAndEnd: List[Int] = tail.take(4).map(_.toInt)
          lineDrawing(lineStartAndEnd(0), lineStartAndEnd(1), lineStartAndEnd(2), lineStartAndEnd(3))
        }
        case "R" :: tail => {
          val topLeftCornerAndBottomRightCorner: List[Int] = tail.take(4).map(_.toInt)

          rectangleDrawing(topLeftCornerAndBottomRightCorner(0), topLeftCornerAndBottomRightCorner(1), topLeftCornerAndBottomRightCorner(2), topLeftCornerAndBottomRightCorner(3))
        }
        case "B" :: tail => {
          val color = tail(2).head
          val startingPoint: List[Int] = tail.take(2).map(_.toInt)
          bucketFill(startingPoint(0), startingPoint(1), color)
        }
    }
  }
}
