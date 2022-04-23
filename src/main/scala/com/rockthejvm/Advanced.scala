package com.rockthejvm

import scala.concurrent.ExecutionContext.Implicits.global // importing the global implicit
import scala.concurrent.Future
import scala.util.{Failure, Success, Try}

object Advanced extends App {
  // lazy evaluation
  lazy val aLazyValue = 2
  lazy val lazyValueWithSideEffect = {
    println("I am so very lazy!")
    43
  }

  val eagerValue = lazyValueWithSideEffect + 1

  // pseudo-collections: Option, Try
  def methodWhichCanReturnNull(): String = "Hello Scala"

  // without the Option type...
  if (methodWhichCanReturnNull() == null) {
    // some defensive code against null
  }

  // with the Option type...
  val anOption = Option(methodWhichCanReturnNull()) // Some("Hello Scala")
  // Option: Some(value) OR None

  // applying PM to an Option type
  val stringProcessing = anOption match {
    case Some(string) => s"I have obtained a valid string: $string"
    case None => "I obtained nothing"
  }

  // without Try "pseudo-collection"...
  def methodWhichCanThrowException(): String = throw new RuntimeException
  try {
    methodWhichCanThrowException()
  } catch {
    case e: Exception => "defend against exception"
  }

  // with Try "pseudo-collection"...
  val aTry = Try(methodWhichCanThrowException())

  val anotherStringProcessing = aTry match {
    case Success(value) => s"I have obtained a valid string: $value"
    case Failure(exception) => s"I have obtained an $exception"
  }

  // Asynchronous Programming
  val aFuture = Future({
    println("Loading...")
    Thread.sleep(1000) // this line will block the running thread by 1s
    println("I have computed a value")
  })
//  Thread.sleep(986) // 985ms does not print the "I have computed a value"
  // this above line gives the Future a chance to finish evaluating thus "I have computed a value"
  // now prints

  // IMPLICITS
  // implicit args
  def aMethodWithImplicitArgs(implicit arg: Int) = arg + 1
  implicit val myImplicitInt: Int = 46
  println(aMethodWithImplicitArgs) // aMethodWithImplicitArgs(myImplicitInt): 47

  // implicit conversions
  implicit class myRichInteger(n: Int) {
    def isEven() = n%2 == 0 // this method returns true if 'n' is even
  }
  println(23.isEven()) // compiler searches for an implicit wrapper on a class and hopes that that
  // class contains the isEven() method - this line === new myRichInteger(23).isEven()
}
