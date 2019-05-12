package DayTwo
class ArrayProducts {
    /*
    Given an array of integers, return a new array such that
    each element at index i of the new array is the product of all the numbers in the original array except the one at i.

    For example, if our input was [1, 2, 3, 4, 5],
    the expected output would be [120, 60, 40, 30, 24].
     If our input was [3, 2, 1], the expected output would be [2, 3, 6].
     */
  def createTheNew(arr: Array[Int]) : Array[Int] = {
    val res = Array[Int](arr.length)
    var pointer = 1
    res(0) = 1
    for(i <- 0 until arr.length) {
      res(i) = res(i-1)*arr(i-1)
    }
    for (i <- (0 until arr.length) reverse) {
      pointer=pointer*arr(i)
      res(i-1)=pointer*res(i-1)
      }

    res
  }
}
