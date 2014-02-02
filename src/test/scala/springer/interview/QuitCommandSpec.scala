package springer.interview


import org.specs2.mutable.Specification

class QuitCommandExtractorSpec extends Specification {

  "unapply" should {
    "match Q" in {
      QuitCommand.unapply("Q") must_== true
    }

    "match Q followed by space" in {
      QuitCommand.unapply("Q   ") must_== true
    }

    "not match non-Q String" in {
      QuitCommand.unapply("q") must_== false
      QuitCommand.unapply("Qblah") must_== false
    }
  }
}

