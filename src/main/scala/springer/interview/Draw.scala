package springer.interview

import java.io.{Writer, OutputStream, PrintStream, InputStream}
import scala.io.Source

class Draw(input: Source, output: Writer) {

  def start() {
    output.write("enter command: ")
  }

}
