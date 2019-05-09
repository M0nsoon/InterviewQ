package DayOne

class ArraySum {
  /*
  Given a list of numbers and a number k, return whether
   any two numbers from the list add up to k.

For example, given [10, 15, 3, 7] and k of 17,
 return true since 10 + 7 is 17.
   */
  def checkArray(arr:Array[Int],k:Int):Boolean ={
    var top = 0
    var bot = arr.length-1
    while(top<bot){
      if((arr(top)+arr(bot)==k)) return true
      else if((arr(top)+arr(bot))<k) top+=1
      else bot-=1
    }
     false
  }
}