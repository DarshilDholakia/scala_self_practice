package com.rockthejvm

object Basics extends App {
  val meaningOfLife: Int = 42

  val aBoolean: Boolean = false
  val aBooleanV2 = false

  //strings and string operations
  val aString = "I love Scala!"
  val aComposedString = "I " + "Love " + "Scala!"
  val anInterpolatedString = s"Is Harden a good buy for the 6ers = $aBoolean" //s"" enables the injection of another
  // value inside a string

  // expressions = structures that can be reduced to a value
  val anExpression = 2 + 3

  // if-expression
  val ifExpression = if (meaningOfLife > 43) 56 else 999
  val chainedIfExpression =
    if (meaningOfLife > 43) 56
    else if (meaningOfLife < 0) -2
    else if (meaningOfLife > 999) 78
    else 0

  // code blocks (is an expression too) - can contain definitions, functions, classes, other code blocks...
  val aCodeBlock = {
    //definitions
    val aLocalValue = 67

    aLocalValue + 3 // ALWAYS HAVE TO RETURN SOMETHING, this expression is the last expression of the block,
    // therefore this is the value of the entire code block
  }

  // defining a function
  def myFunction(x: Int, y: String): String = {
    y + " " + x
  } // code block opened with curly brackets = what is returned by this function - can be done since code block is
  // also an expression

  // recursive functions
  def factorial(n: Int): Int = {
    if (n <= 1) 1
    else n * factorial(n - 1)
  }
  /*
  factorial(5) = 5 * factorial(4) = 5 * 4 * 3 * 2 * 1
  factorial(4) = 4 * factorial(3) = 4 * 3 * 2 * 1
  factorial(3) = 3 * factorial(2) = 3 * 2 * 1
  factorial(2) = 2 * factorial(1) = 2 * 1
  factorial(1) = 1
  */

  def myUnitReturningFunction(): Unit = {
    println("I don't love returning Unit")
  }


}
