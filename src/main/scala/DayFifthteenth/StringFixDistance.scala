package DayFifthteenth
/*
The edit distance between two strings refers to the minimum number of character insertions, deletions, and substitutions required to change one string to the other. For example, the edit distance between “kitten” and “sitting” is three: substitute the “k” for “s”, substitute the “e” for “i”, and append a “g”.

Given two strings, compute the edit distance between them.
 */
class StringFixDistance {
      def ShowHowManySteps(a:String,b:String):Int ={
        val lendiff = b.length - a.length
        var res = 0
        for(i <- 0 until a.length) {
            if(a(i) != b(i)) res += 1
        }
        res = res + lendiff
        res

      }
}
