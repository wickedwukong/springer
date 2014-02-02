package springer.interview

object startingPoint {
   import Drawings._
   def apply(rawInstruction: String):  List[List[String]] => List[List[String]] = {
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
           val canvasDimension: List[Int] = tail.take(2).map(_.toInt)
           canvasDrawing(canvasDimension(0), canvasDimension(1))
         }
     }
   }
 }
