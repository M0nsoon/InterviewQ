package DayFive

 class ConstructPair[A,B] {
  /*
  cons(a, b) constructs a pair, and car(pair) and cdr(pair)
   returns the first and last element of that pair.
    For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.

Given this implementation of cons:

def cons(a, b):
    def pair(f):
        return f(a, b)
    return pair

Implement car and cdr.
   */
  case class Paire(a:A,b:B) {
  }
  def cons(a:A,b:B): Paire = Paire(a,b)
   def car(paire: Paire) = paire.a
   def cdr(paire: Paire) = paire.b
}
