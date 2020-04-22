package example

import org.scalatest._

class RationalSpec extends FlatSpec with Matchers {
  val oneHalf = new Rational(1, 2)
  val twoThree = new Rational(2, 3)
  the[IllegalArgumentException] thrownBy (new Rational(1, 0)) should have message "requirement failed"
  (oneHalf + twoThree) should equal(new Rational(7, 6))
  assert((oneHalf.lessThan(twoThree)), ", lessThan returned incorrect value")

  "lessThan" should "fail" in {
    twoThree.lessThan(oneHalf)
  }

  oneHalf.max(twoThree) should equal(twoThree)

  val threeTwelve = new Rational(3, 12)
  threeTwelve.numer should be equals (1)
  threeTwelve.denom should be equals (4)
}
