fun main() {
    println("Before the try-catch block") // it will be printed
    try {
        println("Inside the try block before an exception") // it will be printed
        @Suppress("DIVISION_BY_ZERO") println(2 / 0) // it throws ArithmeticException
        println("Inside the try block after the exception") // it won't be printed
    } catch (e: ArithmeticException) {
        println("Division by zero!") // it will be printed
    }

    println("After the try-catch block") // it will be printed

    try {
        @Suppress("DIVISION_BY_ZERO") val d = (2 / 0).toDouble()
    } catch (e: Exception) {
        println(e.message)
    }
}
