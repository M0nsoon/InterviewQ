package DayTen

object FindinTest extends App {
  val obj = new FindWordInString
  val set = Set("quick","brown","the","fox")
  val str = "thequickbrownfox"
  var l:List[Int] = List(1,2,3,4)
  //l :+ 4040
  //print(l)
  print(obj.giveSentence(str,set))
}
