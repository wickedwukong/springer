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

    instructionInput.getLines().map {
      case QuitCommand() => System.exit(0); printer.close(); null
      case SupportedCommand(command) => command
      case nonSupportedCommand => {
        canvas: Canvas => {
          printer.print(s"command not supported: [$nonSupportedCommand]")
          printer.flush()
          canvas
        }
      }
    }.foldLeft(List(List[Char]())) {
      (canvas, draw) => display(draw(canvas))
    }
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

object QuitCommand {
  def unapply(command: String) = { if (command.trim() == "Q") true else false }
}