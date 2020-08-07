package example

import scala.collection.immutable.ListMap

//Count the number of occurrences of each character and return it as a list of tuples in order of appearance.
// For empty output return an empty list.

object OrderedCountKata {

  def orderedCount(chars: String): List[(Char, Int)] = {
    chars.distinct.map(x => (x, chars.count(_ == x))).toList
  }

  def orderedCountBest(chars: String): List[(Char, Int)] = {
    chars.distinct.map(c => (c, chars.count(_ == c))).toList
  }
}
