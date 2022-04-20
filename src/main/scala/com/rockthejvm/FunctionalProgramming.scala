package com.rockthejvm

object FunctionalProgramming extends App {
  // apply method
  class Person(name: String) {
    def apply(age: Int) = println(s"I have aged $age years")
  }

  val bob = new Person("Bob")
  bob.apply(43)
  bob(43) // equivalent to bob.apply(43)

  // FunctionX - Incrementer
  val simpleIncrementer = new Function1[Int, Int] {
    override def apply(arg: Int): Int = arg + 1
  }
  simpleIncrementer.apply(23)
  simpleIncrementer(23) // equivalent to simpleIncrementer.apply(23)

  // FunctionX - stringConcatenator
  val stringConcatenator = new Function2[String, String, String] {
    override def apply(arg1: String, arg2: String): String = arg1 + arg2
  }
  stringConcatenator("I love ", "Scala")

  // map/flatMap chaining
  val allPairs = List(1,2,3).flatMap(number => List('a','b','c').map(letter => s"$number-$letter"))
  println(allPairs)

  // for comprehensions - equivalent to map/flatMap chain above
  val alternativePairs = for {
    number <- List(1,2,3)
    letter <- List("a","b","c")
  } yield s"$number-$letter"
  println(alternativePairs)

  // COLLECTIONS
  // Lists
  val aList = List(1,2,3,4,5)
  val aPrependedList = 0 :: aList // :: applicable to a List --> List(0,1,2,3,4,5)
  val anExtendedList = 0 +: aList :+ 6 // +: prepends to a list and :+ appends to a list --> List(0,1,2,3,4,5,6)

  // Sequences
  val aSequence: Seq[Int] = Seq(1,2,3) // Seq.apply(1,2,3)
  val accessedElement = aSequence.apply(1) // RHS equivalent to doing aSequence(1), the number at index 1 = 2

  // Vectors
  val aVector = Vector(1,2,3,4,5)

  // Sets
  val aSet = Set(1,2,3,4,1,2,3) // Set(1,2,3,4)
  val setHas5 = aSet.contains(5) // this will yield false
  val anAddedSet = aSet + 5 // RHS === aSet.+(5) since '+' is a method name ---> Set(1,2,3,4,5)
  val aRemovedSet = aSet - 3 // Set(1,2,4,5)

  // Ranges
  val aRange = 1 to 1000
  val twoByTwo = aRange.map(x => 2*x).toList // List(2,4,6,8...,2000)

  // Tuples
  val aTuple = ("Bon Jovi", "Rock", 1982)

  // Maps
  val aMap: Map[String, Int] = Map(
    ("Daniel", 12345),
    "Jane" -> 23456 // this is equivalent to ("Jane", 23456)
  )
}
