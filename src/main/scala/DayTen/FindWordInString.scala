package DayTen

class FindWordInString {
  /*
    Given a dictionary of words and a string made up of those words (no spaces),
    return the original sentence in a list.
     If there is more than one possible reconstruction, return any of them.
    If there is no possible reconstruction, then return null.

    For example, given the set of words 'quick', 'brown', 'the', 'fox',
    and the string "thequickbrownfox", you should return ['the', 'quick', 'brown', 'fox'].
   */
  def giveSentence(str: String, dict: Set[String]) :List[String] ={
    var res:List[String] = List()
    var pos =  List.fill(str.length-1)(-1)
    pos(0) = 0
    for(i<- 0 until str.length) {
      if(pos(i)!= -1) {
        for(j <- i+1 until str.length) {
          var sub = str.substring(i,j)
          if(dict.contains(sub)){
            res = res :+ sub
            pos(j) =i;
          }
        }
      }
    }
    res
  }
}
