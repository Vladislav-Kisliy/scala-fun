package example

object Hello extends Greeting with App {
  implicit def intToRational(x: Int) = new Rational(x)

  println(greeting)
  println("What?!")
  val oneHalf = new Rational(1, 2)
  println("oneHalf =" + oneHalf)
  println("oneHalf =" + oneHalf * 2)
  println("oneHalf =" + 2 * oneHalf)

  println(FileMatcher.filesContaining("*"))
  println(FirstFunction.containsOdd(List(1, 2, 4, 34, 6, 2, 6, -1)))
  println(FirstFunction.twice(_ + 13, 2))
}


trait Greeting {
  lazy val greeting: String = "hello"
}
