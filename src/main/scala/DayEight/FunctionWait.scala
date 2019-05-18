package DayEight

class FunctionWait {
  /*
  Implement a job scheduler which takes in a function f and an integer n,
  and calls f after n milliseconds.
   */
  def pythagoras(a:Int, b:Int,c:Long):Unit = {
    val first: Long = System.currentTimeMillis()
    Thread.sleep(c)
    math.sqrt(math.pow(a,2) + math.pow(b,2))
    val second:Long = System.currentTimeMillis()
    val third = second-first;
    println("waited " + third)

  }

}
