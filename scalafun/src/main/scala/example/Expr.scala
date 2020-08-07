package example

sealed abstract class Expr {

  case class Var(name: String) extends Expr

  case class Number(num: Double) extends Expr

  case class UnOp(operator: String, args: Expr) extends Expr

  case class BinOp(operator: String,
                   left: Expr, right: Expr) extends Expr

  def describe(e: Expr): String = e match {
    case Number(_) => "a number"
    case Var(_) => "a variable"
    case _ => throw new RuntimeException
  }
}
