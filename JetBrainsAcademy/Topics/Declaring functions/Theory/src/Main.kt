/** The function returns its argument */
fun identity(a: Int): Int {
    return a
}

/** The function returns the sum of two Ints */
fun sum(a: Int, b: Int): Int {
    return a + b
}

/** The function just returns 3 */
fun get3(): Int {
    return 3
}

fun max(
    a: Int,
    b: Int,
): Int { // you can swap arguments without worrying about commas
    return if (a > b) {
        a
    } else {
        b
    }
}

/** The function prints the values of a and b */
fun printAB(a: Int, b: Int) {
    println(a)
    println(b)
}

/** The function prints the sum of a and b */
fun printSum(a: Int, b: Int) {
    println(a + b)
}

fun extractLastDigit(number: Int): Int {
    return number % 10
}

fun isPositive(number: Int): Boolean {
    return number > 0
}

/** It returns "Hello" */
fun getGreeting(): String {
    return "hello" // Ends the function
    // println("hello") // Will not be executed
}

fun sumSingleExpr(a: Int, b: Int): Int = a + b

fun sayHello(): Unit = println("Hello")

fun isPositiveSingleExpr(number: Int): Boolean = number > 0

fun sumSingleExprTypeInferred(a: Int, b: Int) = a + b // Int

fun sayHelloSingleExprTypeInferred() = println("Hello") // Unit

fun isPositiveSingleExprTypeInferred(number: Int) = number > 0 // Boolean

fun theAnswerShort() = 42 // short and clear

fun theAnswerCommon(): Int { // equivalent common function
    return 42
}

fun main() {
    val result1 = sum(2, 5)
    println(result1) // 7

    val result2 = sum(result1, 4)
    println(result2) // 11

    println(identity(1000)) // 1000
    println(sum(200, 300)) // 500
    println(get3()) // 3

    println(max(3, 5))
    printAB(3, 5)
    printSum(3, 5)

    println(extractLastDigit(369))
    println(isPositive(-5))

    getGreeting()

    sumSingleExpr(1, 2)
    sumSingleExprTypeInferred(1, 2)

    sayHello()
    sayHelloSingleExprTypeInferred()

    isPositiveSingleExpr(123)
    isPositiveSingleExprTypeInferred(-123)

    println(theAnswerShort())
    println(theAnswerCommon())
}
