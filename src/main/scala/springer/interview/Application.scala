package springer.interview

import scala.io.Source
import java.io.OutputStreamWriter

object Application extends App {

  new Draw(Source.stdin, new OutputStreamWriter(System.out)).start

}
