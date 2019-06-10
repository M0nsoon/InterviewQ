package DayFifthteenth
/*
Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.

Recall that the median of an even-numbered list is the average of the two middle numbers.
 */

class MedianSequence {
    def giveMedians(list: List[Int]):Unit ={
      var lib : Set[Int] = Set()
      lib = lib + list(0)
      for(i <- 0 until list.length ) {
        if( lib contains list(i) ) println(list(0))
        else println((list(0) + list(i))/2.0)
      }
    }


}
object MedianSequence {
  def main(args: Array[String]): Unit = {
    val a = new MedianSequence
    val list = List(2,1,5,7,2,0,5)
    a.giveMedians(list)
  }
}
