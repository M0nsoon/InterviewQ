package DayTwelve

 class LockedTree() {
/*
Implement locking in a binary tree. A binary tree node can be locked or unlocked only if all of its descendants or ancestors are not locked.

Design a binary tree node class with the following methods:

is_locked, which returns whether the node is locked
lock, which attempts to lock the node. If it cannot be locked, then it should return false. Otherwise, it should lock it and return true.
unlock, which unlocks the node. If it cannot be unlocked, then it should return false. Otherwise, it should unlock it and return true.
 */
  case class Node(left:Node,self: Int,right:Node, parent: Node) {
  var locked = false
  var lockedDescendantCount = 0

}
   def is_locked(node: Node):Boolean =node.locked

   def lock(node: Node): Boolean = {
     if(is_locked(node)) return true
     if(!canLockOrUnLock(node)) return false
     node.locked = true
     var parentNode: Node = node.parent
     while(parentNode != null) {
       parentNode.lockedDescendantCount += 1
       parentNode = parentNode.parent
     }
     true
   }
   def unlock(node: Node):Boolean = {
     if(!is_locked(node)) return true
     if(!canLockOrUnLock(node)) return false
     node.locked = false
     var parentNode: Node = node.parent
     while(parentNode!=null) {
       parentNode.lockedDescendantCount -= 1
       parentNode = parentNode.parent
     }
     true
   }
   def canLockOrUnLock(node: Node): Boolean = {
     if(node.lockedDescendantCount > 0) false
     var parentNode = node.parent
     while(parentNode != null) {
       if(parentNode.locked) return false
       parentNode = parentNode.parent
     }
     true
   }
}
