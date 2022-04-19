package com.rockthejvm

object ObjectOrientation extends App {

  // java equivalent to 'extends App' = public static void main(String[] args)

  // creating a class and an instance of that class
  class Animal {
    // define fields/properties (which are just vals)
    val age: Int = 0
    // define methods
    def eat() = println("I'm eating...")
  }

  object Animal { // companions - this particularly is called a companion object
    val canLiveForever = false
  }

  val canLiveIndefinitely = Animal.canLiveForever // similar to accessing "static" fields or methods in Java

  val anAnimal = new Animal

  // inheritance
  class Dog extends Animal { // inheriting from class or extending class means inheriting the superclass' fields and methods
  }

  // class definition with arguments i.e. constructor definition
  class Cat(val name: String) extends Animal
  val aCat = new Cat("Larry") // constructor being used to instantiate a Cat object

  // subtype polymorphism
  val aDeclaredAnimal: Animal = new Cat("George")
  aDeclaredAnimal.eat()

  // abstract class
  abstract class WalkingAnimal {
    val hasLegs = true
    def walk(): Unit
  }

  // interface/trait
  trait Carnivore {
    def eat(animal: Animal): Unit // this method is unimplemented since returning a Unit type
  }

  trait Amphibian {
    def swim(animal: Animal): Unit
  }

  trait Philosopher {
    def ?!(thought: String): Unit
  }

  class Crocodile extends Animal with Carnivore with Amphibian {
    override def eat(animal: Animal): Unit = println("I am eating other animals...")
    override def swim(animal: Animal): Unit = println("I am swimming...")
  }

  // method notation
  val aCroc = new Crocodile
  aCroc.eat(aCat)
  aCroc eat aCat // infix notation can be used on methods with only ONE argument - structure: object method argument

  // operators are actually methods in Scala
  val basicMath = 1 + 2
  val anotherBasicMath = 1.+(2) // these 2 are equivalent

  // anon classes
  val dinosaur = new Carnivore {
    override def eat(animal: Animal): Unit = println("I am dino, and I eat everything")
  }

  /*
  What we are telling the compiler is...

  class Carnivore_Anonymous_35728 extends Carnivore {
    override def eat(animal: Animal): Unit = println("I am dino, and I eat everything")
  }

  val dinosaur = new Carnivore_Anonymous_35728
  */

  // singleton object
  object MySingleton { // the only instance of the MySingleton type
    val mySpecialValue = 5342
    def mySpecialMethod(): Int = 5327
    def apply(x: Int): Int = x + 1 // built in method in Scala, meaning we can call it using line 81
  }
  MySingleton.apply(65)
  MySingleton(65)

  case class Person(name: String, age: Int)
  val bob  = Person("Bob", 24) // equivalent to doing Person.apply("Bob", 24) - apply method takes in String name and
  // Int age and returns an instance of Person type

  // exceptions
  try {
    val x: String = null
    x.length
  } catch {
    case e: Exception => "some faulty error message"
  } finally {
    // some code that must be executed no matter what happens above with the try catch
  }

  // generics
  val aList: List[Int] = List(1,2,3) // equivalent to doing List.apply(1,2,3)
  val first = aList.head
  val rest = aList.tail

  // Scala - immutable values/objects
  val reversedList = aList.reverse // returns a NEW list which is the reverse of 'aList'
}