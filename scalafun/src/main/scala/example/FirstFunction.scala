package example

object FirstFunction extends App {
  println("Ups!")
  val increase1 = (x: Int) => x + 1
  println("Increase 10 =" + increase1(10))
  val increase999 = (x: Int) => x + 999
  println("Increase 10 =" + increase999(10))
  val increaseAndPrint = (x: Int) => {
    println("Inside function")
    x + 1
  }
  println("Increase 10 =" + increaseAndPrint(10))
  val numbers = List(-11, -10, -5, 0, 5, 10)
  println("Filter =" + numbers.filter(x => x > 0))
}
