package DayNine

class NiceSubstring {
  /*
  Given an integer k and a string s, find the length of the longest
   substring that contains at most k distinct characters.

For example, given s = "abcba" and k = 2,
 the longest substring with k distinct characters is "bcb".
   */
  def findTheSubstring(str: String, k:Int):String ={

  if(str.foreach(x => (str.count(_ ==x))) != k) "This String is not Eligible"
  else {
    //find the char with k times appearance
    val charr = str.filter(x => str.filter(_ ==x) ==k)
    var index = 0;
    var temp =0
    for(i<- 0 until str.length){
      //find the k-th appearance of the char in element
      if((str(i) == charr)&&(index==k)) {
        index +=1
      temp = i}
    }
    //cut the original string from the first appearance to the k-th appearance
    str.slice(str.indexOf(charr),temp)
  }
  }
}
