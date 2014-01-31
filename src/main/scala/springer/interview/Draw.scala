package springer.interview

import java.io._
import scala.io.Source
import scala.collection.immutable.IndexedSeq

class Draw(input: Source, output: Writer) {

  def start() {
    import OutputLists._
    val printer = new PrintWriter(output)
    printer.print("enter command: ")

    val firstCommand = input.getLines().toList.headOption

    val drawingLines: Option[List[List[String]]]= firstCommand.map(toLists)


    drawingLines.foreach{ lines =>
      printer.println
      lines.foreach(line => {
        line.foreach(printer.print)
        printer.println
      })
    }
    printer.close()
  }

}

object OutputLists {
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