package DayNine

class NiceSubstring {
  /*
  Given an integer k and a string s, find the length of the longest
   substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2,
 the longest substring with k distinct characters is "bcb".
   */
 val maxchar = 26;

  def isValid(count: Array[Int],k: Int) :Boolean ={
    var counter = 0
    for(i<- 0 until maxchar) {
      if((count(i) > 0) ){
        counter += 1
      }
    }
    k>=counter
  }
  def kUniques(str:String, k: Int): Unit = {
    var u = 0 // number of unique characters
    val n = str.length
    //associate array to store count
    val count = Array.fill(maxchar)(0)
    //traverse the string, fills the associate arrays
    //count the number of unique characters
    for(i<- 0 until n) {
      if(count(str(i)-'a')==0) {
        u += 1
      }
      count(str(i)-'a') += 1
    }
    //if not enough unique chars, returns error
    if(u < k) {
      println("not enough unique chars")
      return
    }
    //otherwise take a window with first elems in it
    //start and end vars
    var current_start = 0
    var current_end = 0
    //values for result longest windows
    var max_window_size = 1
    var max_window_start = 0
    //put the first char, start from the second char,
    //add chars in windows
    count(str(0)-'a') += 1
    for(i<- 0 until n) {
      //add char s(i) to current window
      count(str(i) -'a') += 1
      current_end += 1
      //if more than k unique chars in current windows,
      //remove from the left side
      while (!isValid(count,k)) {
        count(str(current_start)-'a') -= 1
        current_start +=1
      }

      //update max size if required
      if(current_end - current_start +1 > max_window_size) {
        max_window_size = current_end - current_start + 1
        max_window_start = current_start
      }
    }
  }
}
