package DaySeventeenth

class Stocking {
  def mostProfit(arr: Array[Double]):Double ={
    var smallest = arr(0);
    var PossibleProfit: Array[Double] = Array()
    var profit = 0
    for(i<- 0 until arr.length) {
      if(arr(i) < smallest) {
        smallest = arr(i)
      }
      for (j<- i+1 until arr.length) {
        PossibleProfit = PossibleProfit :+ (arr(j)-arr(i))
      }

    }
    PossibleProfit.max
  }

}
