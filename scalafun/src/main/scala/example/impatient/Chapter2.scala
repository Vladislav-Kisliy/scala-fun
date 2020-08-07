package example.impatient

import scala.util.Random

object Chapter2 {

  def signum(v: Int): Int = {
    var result = 0
    if (v > 0) result = 1
    else if (v < 0) result = -1
    result
  }

  def countdown(n: Int) = {
    for (i <- n to 0 by -1) println("Count down =" + i)
  }

  def product(s: String): Long = {
    //    var pr: Long = 1;
    //    for (i <- s) pr = pr * i
    //    pr
    if (s.length == 1) s.charAt(0).toLong
    else s.head * product(s.tail)
  }

  def randomizer(array: Array[Int], max: Int) = {
    for (i <- array.indices) array(i) = Random.nextInt(max + 1)
  }

  def main(args: Array[String]) = {
    println(signum(0))
    countdown(5)
    countdown(-5)

    println(product("Hello"))
    val arr = new Array[Int](10)
    randomizer(arr, 12)
    println(arr.toList)
    arr.grouped(2)
      .flatMap{
        case Array(x,y) => Array(y,x)
        case Array(x) => Array(x)
      }.toArray
    arr.grouped(2).flatMap(_.reverse).toArray
    (for {b <- arr.grouped(2); c <- b.reverse} yield c).toArray
//      .map(case Array(a, b) => (b, a))
//    collect { case Array(x: Int, y: Int, _*) => (y,x) }
  }
}
