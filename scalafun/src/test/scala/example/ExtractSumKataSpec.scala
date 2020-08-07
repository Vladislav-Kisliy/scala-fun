package example

import org.scalatest._

class ExtractSumKataSpec extends FunSuite {
  test("basic tests") {
    assert(ExtractSumKata.subtractSum(10) === "apple")
  }
}
