package example

object Hello extends Greeting with App {
  implicit def intToRational(x: Int) = new Rational(x)

  println(greeting)
  println("What?!")
  val oneHalf = new Rational(1, 2)
  println("oneHalf =" + oneHalf)
  println("oneHalf =" + oneHalf * 2)
  println("oneHalf =" + 2 * oneHalf)
}

trait Greeting {
  lazy val greeting: String = "hello"
}
