package DayFour

class FindTheMissing {
  def ShowTheMissing(arr : Array[Int]):Int ={
    val dank = arr.toSet[Int].filter(_>0)
    val dankE = dank.toList
    for(i <- 0 until dankE.length) {
      if((dankE(i)-dankE(i-1)) > 1) return dankE(i-1) +1
    }
    return -1
  }

}
