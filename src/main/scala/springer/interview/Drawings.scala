package springer.interview

object Drawings {

  def toDrawing: String => List[List[String]] => List[List[String]] = {
    rawInstruction => {
      rawInstruction.split(" ").toList match {
        case "C" :: tail => {
          val canvasDimension: List[Int] = tail.take(2).map(_.toInt)
          canvasDrawing(canvasDimension(0), canvasDimension(1))
        }
        case "L" :: tail => {
          val lineStartAndEnd: List[Int] = tail.take(4).map(_.toInt)
          lineDrawing(lineStartAndEnd(0), lineStartAndEnd(1), lineStartAndEnd(2), lineStartAndEnd(3))
        }
      }
    }
  }

  def lineDrawing(xStart: Int, yStart: Int, xEnd: Int, yEnd: Int): List[List[String]] => List[List[String]] = {
    canvas => canvas.zipWithIndex.map {
      case (row, rowIndex) if rowIndex >= yStart && rowIndex <= yEnd => {
        row.zipWithIndex map {
          case (cell, cellIndex) => if (cellIndex >= xStart && cellIndex <= xEnd) "x" else cell
        }
      }
      case (row, _) => row
    }

  }

  def canvasDrawing(xAxis: Int, yAxis: Int): List[List[String]] => List[List[String]] = {
    _ => {
      val numberOfRows = yAxis + 2
      val numberOfColumns = xAxis + 2

      (0 until numberOfRows).map {
        case x if x == 0 || x == numberOfRows - 1 => 0.until(numberOfColumns).map(_ => "-").toList
        case _ => 0.until(numberOfColumns).map {
          case x if x == 0 || x == numberOfColumns - 1 => "|"
          case _ => " "
        }.toList
      }.toList
    }
  }
}

