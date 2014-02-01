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

      output.toString must_== ("enter command:")
    }

    "Can process Canvas command" in {
      val output: StringWriter = new StringWriter()

      val string: Source = Source.fromString("C 2 2\n")

      new Draw(string, output).start()

      val twoTwoCanvas = """----
                           ||  |
                           ||  |
                           |----
                           |enter command:""".stripMargin

      val applicationOutput = Source.fromString(output.toString).getLines().toList

      applicationOutput(0) must_== "enter command:"
      
      val canvas: String = applicationOutput.tail.mkString("\n")
      
      canvas must_== twoTwoCanvas
    }

    "draw a line" in {
      val output: StringWriter = new StringWriter()

      val string: Source = Source.fromString("C 2 2\nL 1 1 2 1")

      new Draw(string, output).start()

      val oneLineOnCanvas = """enter command:
                              |----
                              ||  |
                              ||  |
                              |----
                              |enter command:
                              |----
                              ||xx|
                              ||  |
                              |----
                              |enter command:""".stripMargin

      val applicationOutput = Source.fromString(output.toString).getLines().toList

      val canvas: String = applicationOutput.mkString("\n")

      canvas must_== oneLineOnCanvas
    }

    "draw a rectangle" in {
      val output: StringWriter = new StringWriter()

      val string: Source = Source.fromString("C 4 3\nR 1 1 3 3")

      new Draw(string, output).start()

      val oneRectangleOnCanvas = """enter command:
                              |------
                              ||    |
                              ||    |
                              ||    |
                              |------
                              |enter command:
                              |------
                              ||xxx |
                              ||x x |
                              ||xxx |
                              |------
                              |enter command:""".stripMargin

      val applicationOutput = Source.fromString(output.toString).getLines().toList

      val canvas: String = applicationOutput.mkString("\n")

      canvas must_== oneRectangleOnCanvas
    }
  }
}

