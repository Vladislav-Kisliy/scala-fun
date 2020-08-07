package example

import Element.elem

abstract class Element {
  def contents: Array[String]

  def height: Int = contents.length

  def width: Int =
    if (height == 0) 0 else contents(0).length

  def above(that: Element): Element = {
    val this1 = this widen that.width
    val that1 = that widen this.width
    elem(this1.contents ++ that1.contents)
  }


  def beside(that: Element): Element =
    elem(
      for (
        (line1, line2) <- this.contents zip that.contents
      ) yield line1 + line2
    )

  def widen(w: Int): Element =
    if (w <= width) this
    else {
      val left = elem(' ', (w - width) / 2, height)
      val right = elem(' ', w - width - left.width, height)
      left beside this beside right
    }

  def heighten(h: Int): Element =
    if (h <= height) this
    else {
      val top = elem(' ', width, (h - height) / 2)
      val bot = elem(' ', width, h - height - top.height)
      top above this above bot
    }

  override def toString: String = contents mkString "\n"

}

object Element {

  private class ArrayElement(s: Array[String]) extends Element {
    override def contents: Array[String] = s
  }

  private class LineElement(line: String) extends Element {
    val contents = Array(line)

    override def width = line.length

    override def height = 1
  }

  private class UniformElemnt(chr: Char, width: Int, height: Int) extends Element {
    private val line = chr.toString * width

    def contents = Array.fill(height)(line)
  }

  def elem(contents: Array[String]): Element =
    new ArrayElement(contents)

  def elem(chr: Char, width: Int, height: Int): Element =
    new UniformElemnt(chr, width, height)

  def elem(line: String): Element = new LineElement(line)
}
