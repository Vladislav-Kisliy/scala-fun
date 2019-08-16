package recfun

import org.scalatest.FunSuite


import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

/**
Write a recursive function which verifies the balancing of parentheses in a string, which we represent as a List[Char] not a String. For example, the function should return true for the following strings:

(if (zero? x) max (/ 1 x))
I told him (that it’s not (yet) done). (But he wasn’t listening)

The function should return false for the following strings:

:-)
())(

The last example shows that it’s not enough to verify that a string contains the same number of opening and closing parentheses.

Do this exercise by implementing the balance function in Main.scala. Its signature is as follows:

There are three methods on List[Char] that are useful for this exercise:

chars.isEmpty: Boolean returns whether a list is empty
chars.head: Char returns the first element of the list
chars.tail: List[Char] returns the list without the first element

Hint: you can define an inner function if you need to pass extra parameters to your function.

Testing: You can use the toList method to convert from a String to aList[Char]: e.g. "(just an) example".toList.
**/
@RunWith(classOf[JUnitRunner])
class BalanceSuite extends FunSuite {
  import Main.balance

//  balance: '(if (zero? x) max (/ 1 x))' is balanced::10
  test("balance: '(if (zero? x) max (/ 1 x))' is balanced") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList))
  }

  test("balance: 'I told him ...' is balanced") {
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList))
  }

  test("balance: ':-)' is unbalanced") {
    assert(!balance(":-)".toList))
  }

  test("balance: counting is not enough") {
    assert(!balance("())(".toList))
  }

  test("balance: a lot (") {
    assert(balance("(sdsdssd(((sdsdsd(sdsdsd(ssss)ddd) fff ) dfdf) ))".toList))
  }

  test("balance: corner cases is unbalanced") {
    assert(!balance("(((hello)there)you)(".toList))
  }
//    [Test Description] balance: corner cases [Observed Error] Main.balance(scala.this.Predef.augmentString("").toList) was true false positive [Lost Points] 10
}
