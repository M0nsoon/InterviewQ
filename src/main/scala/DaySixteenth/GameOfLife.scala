package DaySixteenth

class GameOfLife {
 class Cell(alive:Boolean) {
   var isAlive:Boolean = alive
   override def toString = if(this isAlive) "x" else "-"
   def isDead = !this.isAlive
 }
  object Grid {
    val width = 10
    val height = 10
    var grid = new Array[Array[Cell]](width,height)

    private def iterGrid(inner: (Int,Int) => Unit, outer:Unit => Unit): Unit = {
      for(y <- 0 until height ) {
        for (x <- 0 until width) {
          inner(x,y)
        }
        outer()
      }
    }
    iterGrid((x,y) => {
      if (x ==0 && y == 0) grid(x)(y) = new Cell(true)
      else if (x == 1 && y == 1) grid(x)(y) = new Cell(true)
      else if (x ==2 && y == 2) grid(x)(y) = new Cell(true)
      else grid(x)(y) = new Cell(false)
    }, Unit => Unit )
    //new grid is calculated from old grid, calculating in place leads to side effects
    def goToNextStep = {
      iterGrid((x,y) => {
        val aCell = grid(x)(y)
        val numberOfAliveNeighbors = numberOfAliveNeighborsOfCellAt(x,y)
        if( aCell isAlive) {
          println("Cell (" + x + ", " + y + ") is alive")
          println("Number of alive neighbors: " + numberOfAliveNeighbors)

          if(numberOfAliveNeighbors <2) kill(aCell)
          else if(numberOfAliveNeighbors >3) kill(aCell)
        }
        else if (numberOfAliveNeighbors ==3) resurrect(aCell)
      }, Unit => Unit )
    }
    def numberOfAliveNeighborsOfCellAt(i: Int, i1: Int):Int ={
      var numberOfAliveNeighbors = 0
      iterNeighbors((x,y) => if (grid(x)(y) isAlive) numberOfAliveNeighbors += 1,x,y)
      return numberOfAliveNeighbors
    }
    def iterNeighbors(f: (Int, Int) => Unit, x: Int, y: Int) = {
      def cellExist(x:Int,y:Int): Boolean ={
        if((x>=0 && x <= width -1) && (y>=0 && y<= height-1))  true else  false

      }
      //top left
      if( cellExist(x-1,y-1)) f(x-1,y-1)
      //top center
      if (cellExist(x, y-1)) f(x,y-1)
      // top right
      if (cellExist(x+1, y-1)) f(x+1,y-1)
      // middle left
      if (cellExist(x-1, y)) f(x-1,y)
      // middle right
      if (cellExist(x+1, y)) f(x+1,y)
      // bottom left
      if (cellExist(x-1, y+1)) f(x-1,y+1)
      // bottom center
      if (cellExist(x, y+1)) f(x,y+1)
      // bottom right
      if (cellExist(x+1, y+1)) f(x+1,y+1)
    }
    def kill(aCell: Cell) = aCell isAlive = false
    def resurrect(aCell:Cell) = aCell isAlive = true
    def isNotDead:Boolean =  {
      var isDead = true
      iterGrid((x,y) => {
        if(grid(x)(y) isAlive) isDead = false
      },Unit=>Unit)
    return !isDead}
    override def toString ={
      var gridStr = ""
      iterGrid((x,y) => {
        gridStr = gridStr + grid(x)(y)
      },Unit => {gridStr = gridStr + "\n"})
      gridStr
    }
  }

  object Main {
    def main(args: Array[String]): Unit = {
      do {
        print(Grid)
        Grid goToNextStep

      }
      while(Grid isNotDead)
      print(Grid)
    }
  }

}
