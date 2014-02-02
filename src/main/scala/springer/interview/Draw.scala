package springer.interview

import java.io._
import scala.io.Source
import scala._
import springer.interview.Drawings.Canvas

class Draw(instructionInput: Source, output: Writer) {

  def start() {
    val printer = new PrintWriter(output)
    printer.print("enter command:")
    printer.flush()

    val display = makeDisplay(printer) _

    val drawings = instructionInput.getLines().toSeq.map(toDrawing(_))

    drawings.foldLeft(List(List[Char]())) {
      (canvas, draw) =>
        val newDrawing: Canvas = draw(canvas)
        display(newDrawing)
        newDrawing
    }

    printer.close()
  }

  private def makeDisplay(printer: PrintWriter)(canvas: Canvas): Canvas = {
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