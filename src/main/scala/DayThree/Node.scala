package DayThree

 class Node {
  /*
  Given the root to a binary tree, implement serialize(root), which serializes the tree into a string,
   and deserialize(s), which deserializes the string back into the tree.

For example, given the following Node class

class Node:
    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
The following test should pass:

node = Node('root', Node('left', Node('left.left')), Node('right'))
assert deserialize(serialize(node)).left.left.val == 'left.left'
   */

   case class Tree[String]( var left:Tree[String],inhalt:String,var right:Tree[String]) {
   }
   object Serializer {
     private val pattern = """^(\d+)\((.*)\)$""".r //regex is used here. ".r" is used to convert the string, to make sure it contains pattern
     private val treeOpen = '('
     private val treeClose = ')'
     private val separator = ','
     private val separatorLength = 1

     def serialize(node: Tree[String]):String = node match {
       case Tree(left,value,right) => { val leftStr = serialize(left)
                                        val rightStr = serialize(right)
         s"$value$treeOpen$leftStr$separator$rightStr$treeClose"} //using Regex to identify

       case Tree(null,value,null) => value

     }
     def deserialize(str:String):Tree[String] = str match {
       case pattern(value,inner) => val (left,right) = splitInner(inner)
                                    Tree(deserialize(left),value,deserialize(right))

       case _ => Tree(null,null,null)
     }
     private def splitInner(str: String): (String,String) ={
       var balance = 0
       //here we use takeWhile instead of filter.
       //Filter returns all the elements that satisfy predicate
       //takeWhile returns the longest prefix whose elements satisfy the predicate
       var left = str.takeWhile {
         case `treeOpen` => balance+=1; true
         case `treeClose` => balance -=1;true
         case `separator` if balance ==0 => false
         case _ => true
       }
       val right = str.drop(left.length + separatorLength)

       (left,right)
     }
   }

}
