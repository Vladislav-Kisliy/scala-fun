package example.impatient

import java.io.File
import java.util.Scanner

import example.impatient.`trait`.{ShortLogger, SomeClass}

import scala.collection.mutable

object Chapter4 {

  def wordCounterMutable(filename: String): Map[String, Int] = {
    val in = new Scanner(new File(filename))
    val result = scala.collection.mutable.Map[String, Int]()
    while (in.hasNext()) {
      val word = in.next()
      if (result.contains(word)) {
        result(word) = result(word) + 1
      } else {
        result(word) = 1
      }
    }
    result.toMap
  }

  def wordCounterImutable(filename: String): Map[String, Int] = {
    val in = new Scanner(new File(filename))
    var result = Map[String, Int]()
    while (in.hasNext()) {
      val word = in.next()
      if (result.contains(word)) {
        result = result + (word -> (result(word) + 1))
      } else {
        result = result + (word -> (1))
      }
    }
    result
  }

  def wordCounterMutableSorted(filename: String) = {
    val in = new Scanner(new File(filename))
    val result = scala.collection.mutable.SortedMap[String, Int]()
    while (in.hasNext()) {
      val word = in.next()
      if (result.contains(word)) {
        result(word) = result(word) + 1
      } else {
        result(word) = 1
      }
    }
    result
  }

  def minMax(values: Array[Int]): (Int, Int) = {
    values.foldLeft((values(0), values(0))) {
      case ((min, max), e) => (math.min(min, e), math.max(max, e))
    }
  }

  def ltqgt(values: Array[Int], v: Int): (Int, Int, Int) = {
    var eqCnt = 0
    var ltCnt = 0
    var gtCnt = 0
    for (x <- values) {
      if (x < v) ltCnt += 1
      if (x > v) gtCnt += 1
      if (x == v) eqCnt += 1
    }

    (ltCnt, eqCnt, gtCnt)
  }

  def main(args: Array[String]) = {
    println("Reading file")
    //    println(wordCounterMutable("/home/vlad/Dropbox/tpe/docker.txt"))
    //    println(wordCounterImutable("/home/vlad/Dropbox/tpe/docker.txt"))
    println("Sorted results")
    println(wordCounterMutableSorted("/home/vlad/Dropbox/tpe/docker.txt"))
    println(minMax(Array(1, 2, -30, 43, 5, 6, 7, 89, 77, 67)))

    println(ltqgt(Array(1, 2, -30, 43, 5, 6, 7, 89, 77, 67), 10))
    println(ltqgt(Array(1, 2, -30, 43, 5, 6, 7, 89, 77, 67), 43))

    println("Hello_my little" zip "(World)")

    val counter = new Counter
    counter.increment()
    val n = counter.current

    val person = new Person("Vasya")
    println("Person Vasya name=" + person.name)
    println("Person Vasya age=" + person.age)
    println("Person Vasya description=" + person.description)
    person.age = 12
//    person.name = "Petya"
//    person.description = "Petya"
    println("Person Vasya description=" + person.description)
    val value = 1 << 3
    System.out.println("out =" + value)

  }
}
