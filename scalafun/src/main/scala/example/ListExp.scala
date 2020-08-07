package example

import example.Spiral.spiral

object ListExp {

  def main(args: Array[String]) = {
    val appender = new ListAppender()
    println(appender.append[Int](List(1, 2, 3), List(2, 3, 4)))
    val messList = List("line", "3", 4.12, true)
    println(appender.append(List(1, 2, 3), messList))
//    println(appender.append[Int](List(1, 2, 3), messList))

    val intList01: List[Int] = List(1, 2, 3, 4, 6)
    val intList02: List[Int] = List(11, 22, 3, 4, 6)
    val stringList01: List[String] = List("11", "22", "3", "4", "6")

    val name: String = null
    if (name.eq("Stas")) println("Yes, it's me")


    val appendRes01 = appender.append(intList01, intList02)
    println(appendRes01)
    val appendRes02 = appender.append(intList01, stringList01)
//    val appendRes03: List[Int] = appender.append(intList01, stringList01)
    val appendRes03: List[Int] = appender.append(intList01, intList02)
    println(appendRes03)
    println(intList01 ::: intList02 ::: stringList01 ::: messList)

    val abcde: List[Char] = List('a', 'b', 'c', 'd', 'e')
    println(abcde.indices zip abcde)
    println(abcde zip abcde)
    println(abcde zip List(1, 2, 3, 4))

    val even = (i: Int) => i % 2 == 0
    println(intList02 filter even)
    println(intList02 partition even)

    println(sumLeft(intList01))
    box("Vasya")

  }

  def sumLeft(list: List[Int]): Int = (list foldLeft 0) (_ + _)

  def box(s: String)= {
    val border = "-" * (s.length + 2)
    print(f"$border%n|$s|%n$border%n")
  }

//  def sumRight(list: List[Long]): Long = (list foldRight 0) (_ + _)
}
