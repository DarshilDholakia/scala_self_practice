package com.rockthejvm

object PatternMatching extends App {
  // Switch expression
  val anInteger = 55
  val order = anInteger match {
    case 1 => "first"
    case 2 => "second"
    case 3 => "third"
    case _ => anInteger + "th"
  }

  case class Person(name: String, age: Int)
  val bob = Person("Bob", 43) // creating an instance of the case class. No need to do new Person() since Person case
  // class automatically creates a companion object with .apply method therefore RHS === Person.apply("Bob", 43)

  val personGreeting = bob match {
    case Person(n, a) => s"Hi, my name is $n and I am $a years old."
    case _ => "Something else"
  }

  // deconstructing Tuples
  val aTuple = ("Bon Jovi", "Rock")
  val bandDescription = aTuple match {
    case (band, genre) => s"$band belongs to the genre $genre" // if the tuple conforms to a 2 member structure...
    case _ => "Don't know what you are talking about!"
  }

  // decomposing Lists
  val aList = List(1,2,3)
  val listDescription = aList match {
    case List(_, 2, _) => "List contains 2 in the 2nd position"
    case _ => "unknown list" // _ case = best practice (however, it's not mandatory) since if PM doesn't match anything
    // a MatchError will be thrown which will crash the system
  }

}
