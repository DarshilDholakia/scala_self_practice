package com.rockthejvm

object ContextualAbstraction {

  // context parameters/arguments
  val aList = List(2,1,3,4)
  val anOrderedList = aList.sorted // contextual argument: (descendingOrdering)

  // using 'using' and 'given' is analogous to an implicit val
  given descendingOrdering: Ordering[Int] = Ordering.fromLessThan(_ > _) // (a,b) => a > b

  // traits are just interfaces containing unimplemented methods
  trait Combinator[A] { // instead of Combinator, it's also called a Monoid
    def combine(x: A, y: A): A // this method takes 2 args of type A and returns a value of type A
  }

  // intCombinator is just an instance of the trait Combinator[A] where A is Int
  given intCombinator: Combinator[Int] = new Combinator[Int] {
    override def combine(x: Int, y: Int) = x + y
  }

  def combineAll[A](list: List[A])(using combinator: Combinator[A]): A =
    list.reduce((a,b) => combinator.combine(a,b))

  val theSum = combineAll(aList) // 2nd phantom argument: (intCombinator) due to use of 'using' and 'given'

  def main(args: Array[String]): Unit = {
    println(theSum)
  }
}
