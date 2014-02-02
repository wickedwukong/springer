package springer.interview

import java.io._
import scala.io.Source
import scala._

class Draw(instructionInput: Source, output: Writer) {

  def start() {
    val printer = new PrintWriter(output)
    printer.print("enter command:")
    printer.flush()

    val display = makeDisplay(printer) _

    val drawings = instructionInput.getLines().toSeq.map(toDrawing(_))

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