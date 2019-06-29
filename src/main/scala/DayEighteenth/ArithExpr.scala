package DayEighteenth

class ArithExpr {
  abstract class BinTree
  case class Operator(left:BinTree, operator: Expr, right:BinTree) extends  BinTree
  case class Number(value: Int) extends BinTree

  def isOperator(c: Char ): Boolean ={
    if(c == '+' || c=='-' || c=='*' || c=='/') true
    else false
  }
  trait Expr{
    def apply(left:Int,right:Int):Int
  }
  object Add extends Expr {
    override def apply(left: Int, right: Int): Int = left + right
  }
  object Minus extends Expr {
    override def apply(left: Int, right: Int): Int = left - right
  }
  object Multiply extends Expr {
    override def apply(left: Int, right: Int): Int = left * right
  }
  object Divide extends Expr{
    override def apply(left: Int, right: Int): Int = left / right
  }
  def evaluate(tree: BinTree):Int = tree match {
    case Number(n) => n
    case Operator(left,operator,right) => operator.apply(evaluate(left),evaluate(right))
  }

}
