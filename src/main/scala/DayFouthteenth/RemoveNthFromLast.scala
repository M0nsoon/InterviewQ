package DayFouthteenth

import java.util


class RemoveNthFromLast {
  val list  = new util.LinkedList[Int]()
  def doIt(k:Int) = {list.remove(list.size-1-k)}


}
object RemoveNthFromLast {
  def main(args: Array[String]): Unit = {
    val a = new RemoveNthFromLast
    a.list.add(1)
    a.list.add(2)
    a.list.add(3)
    a.list.add(4)
    a.doIt(2)
    print(a.list)
  }
}
