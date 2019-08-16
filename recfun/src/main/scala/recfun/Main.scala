package recfun

import Array._

object Main {
  def main(args: Array[String]) {
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  val pascalMatrix = ofDim[Int](101, 101)
  var processedRow: Int = 0

  /**
    * Exercise 1
    */
  def pascal(c: Int, r: Int): Int = {
    if (pascalMatrix(r)(c) == 0) {
      for (i <- processedRow to r) {
        pascalMatrix(i)(0) = 1; pascalMatrix(i)(i) = 1;
        for (j <- 1 to i) pascalMatrix(i)(j) =
          pascalMatrix(i - 1)(j - 1) + pascalMatrix(i - 1)(j)
      }
    }
    processedRow = r
    pascalMatrix(r)(c)
  }

  /**
    * Exercise 2
    */
  def balance(chars: List[Char]): Boolean = {
    var result: Boolean = false
    if (!chars.isEmpty) {
      var counter: Int = 0
      for (c <- chars) {
        if (c == '(') counter += 1
        else if (c == ')') counter -= 1
        if (counter < 0) return false
      }
      if (counter == 0) result = true
    }
    result
  }

  /**
    * Exercise 3
    */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money < 0) return 0
    if (coins.isEmpty) {
      if (money == 0) return 1
      else return 0
    }
    else
      countChange(money, coins.tail) + countChange(money - coins.head, coins)
  }


  def countChangeNonRecursive(money: Int, coins: List[Int]): Int = {
    val variants: Array[Int] = new Array[Int](money + 1)
    variants(0) = 1
    for (i <- 0 until coins.length)
      for (j <- 1 to money) {
        if (j - coins(i) >= 0)
          variants(j) += variants(j - coins(i))
      }
    variants(money)
  }
}
