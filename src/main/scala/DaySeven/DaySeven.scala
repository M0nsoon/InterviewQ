package DaySeven

class DaySeven {
/*
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.

For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.

You can assume that the messages are decodable. For example, '001' is not allowed.
 */
  def waysToDecode(input:String):Int ={
    assert(input(0) != 0)
    var res = input.length
    for(i <- 0 until input.length-1) {
      if(input(i) == '1') res += 1
      else if(input(i) == '2') {
        if(input(i+1) <= '6') res +=1
      }
    }
    res
  }
}
