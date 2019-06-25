package DaySeventeenth

class LongestPalinSubstring {
  def longestPalSubStr(str: String): Int ={
    val n = str.length //get length of input
    /*
    table(i)(j) will be false if substring str(i...j) is not palindrome
    else table(i)(j) will be true

    */
    val table = Array.ofDim[Boolean](n,n)
  //all substrings of length 1 are palindromes
    var maxLength = 1
    for(i<- 0 until n) {
      table(i)(i) = true
    }
    //check for sub-string of length 2
    var start = 0
    for (i<- 0 until n-1) {
      if(str(i) ==str(i+1)) {
        table(i)(i+1) = true
        start = i
        maxLength = 2
      }
    }
    //check for lengths greater than 2. k is length of substring
    for(k<- 3 until n) {
      //fix the staring index
      for(i<- 0 until n-k+1) {
        //get the ending index of substring from starting index i and length k
        var j = i+k-1
        //check for sub-string from ith index to jth index if str(i+1) to str(j-1) is a palindrome
        if(table(i+1)(j-1) && (str(i)==str(j))) {
          table(i)(j) = true
          if(k > maxLength) {
            start = i
            maxLength = k
          }
        }
      }
    }
    println("Longest palindrome substring is: ")
    maxLength
  }

}
