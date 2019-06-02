package DayEleven

class FindWayOut {
  /*
  You are given an M by N matrix consisting of booleans that represents a board.
   Each True boolean represents a wall.
    Each False boolean represents a tile you can walk on.

Given this matrix, a start coordinate, and an end coordinate, return the minimum number
of steps required to reach the end coordinate from the start. If there is no possible path, then return null.
You can move up, left, down, and right. You cannot move through walls. You cannot wrap around the edges of the board.
   */
  def solve(maze: Array[Array[Char]],startX: Int, startY: Int, finishX: Int, finishY : Int) : Int ={
    var counter = 0;
    def checkForImpassibleWall(wallMatrix: Array[Array[Char]], sX: Int, sY: Int, fX: Int, fY: Int):Boolean ={
      if(sX > fX) {
        for(row <- fX to sX) {
          if((wallMatrix(row) contains('f')) != true) return true
        }
      }
      else {
        for (row <- sX to fX) {
          if((wallMatrix(row) contains('f')) != true)return true
        }
      }
      return false
    }
    val impassableWall = checkForImpassibleWall(maze,startX,startY,finishX,finishY)
    print(impassableWall)
    if(impassableWall) return null
    else return 1
  }
}
