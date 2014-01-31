package springer.interview

import org.specs2.mutable.Specification
import java.io.StringWriter
import scala.io.Source

class DrawSpec extends Specification {

  "On Start" should {
    "give a Enter Command: prompt" in {
      val output: StringWriter = new StringWriter()

      val string: Source = Source.fromString("Q")
      
      new Draw(string, output).start()

      output.toString must_==("enter command: ")
    }
  }
}

