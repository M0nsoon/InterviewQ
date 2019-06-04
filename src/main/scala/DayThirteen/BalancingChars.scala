package DayThirteen

class BalancingChars {
    //balancing chars in array
  def balance(chars : List[Char]):Boolean = {
    def valid(expr: List[Char], count: Int): Int = {

      if (expr.isEmpty) count
      else if (expr.head == '(')
        valid(expr.tail, count + 1)
      else if (expr.head == ')' && count > 0)
        valid(expr.tail, count - 1)
      else valid(expr.tail, count)
    }
    if (chars.count(_ == '(' ) == chars.count(_ == ')')) valid(chars,0) == 0
    else false
  }

}
