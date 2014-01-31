package springer.interview

import org.specs2.mutable.Specification
import java.io.StringWriter
import scala.io.Source

class DrawSpec extends Specification {

  "On Start" should {
    "give a enter command: prompt" in {
      val output: StringWriter = new StringWriter()

      val emptyCommandInput: Source = Source.fromIterable(List.empty)

      new Draw(emptyCommandInput, output).start()

      output.toString must_== ("enter command: ")
    }

    "Can process Canvas command" in {
      val output: StringWriter = new StringWriter()

      val string: Source = Source.fromString("C 2 2\n")

      new Draw(string, output).start()

      val twoTwoCanvas = """----
                           ||  |
                           ||  |
                           |----""".stripMargin

      val applicationOutput = Source.fromString(output.toString).getLines().toList

      applicationOutput(0) must_== "enter command: "
      
      val canvas: String = applicationOutput.tail.mkString("\n")
      
      canvas must_== twoTwoCanvas
    }
  }
}

