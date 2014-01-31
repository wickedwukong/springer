package springer.interview

import java.io._
import scala.io.Source
import scala._

class Draw(instructionInput: Source, output: Writer) {

  def start() {
    import Drawings._
    val printer = new PrintWriter(output)
    printer.print("enter command:")
    printer.flush()

    val display = makeDisplay(printer) _

    val drawings: Iterator[(List[List[String]]) => List[List[String]]] = instructionInput.getLines().map(toDrawing)
    drawings.foldLeft(List(List[String]())) {
      (canvas, draw) =>
        val newDrawing: List[List[String]] = draw(canvas)
        display(newDrawing)
        newDrawing
    }

    printer.close()
  }

  private def makeDisplay(printer: PrintWriter)(canvas: List[List[String]]): List[List[String]] = {
    canvas.foreach {
      line =>
        printer.println
        line.foreach(printer.print)
    }
    printer.println
    printer.print("enter command:")
    printer.flush()

    canvas
  }

}

object Drawings {

  def toDrawing: String => List[List[String]] => List[List[String]] = {
    rawIntruction => {
      rawIntruction.split(" ").toList match {
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

  def toLists(raw: String): List[List[String]] = {
    val canvasDimension: Array[Int] = raw.split(" ").tail.take(2).map(_.toInt)

    val (xAxis, yAxis) = (canvasDimension(0), canvasDimension(1))

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
