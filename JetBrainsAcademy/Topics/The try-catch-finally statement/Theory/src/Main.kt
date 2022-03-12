fun main() {
    try {
        println("Inside the try block")
        @Suppress("DIVISION_BY_ZERO") println(2 / 0) // throws ArithmeticException
    } catch (e: Exception) {
        println("Inside the catch block")
    } finally {
        println("Inside the finally block")
    }

    println("After the try-catch-finally block")

    try {
        @Suppress("DIVISION_BY_ZERO") val a = 0 / 0 // throws ArithmeticException
    } finally {
        println("End of the try block") // will be executed
    }
    println("End of the program") // will not be printed

    val number0: Int =
        try {
            "abc".toInt()
        } catch (e: NumberFormatException) {
            0
        }
    println(number0) // 0

    val number1: Int =
        try {
            "2a".toInt()
        } catch (e: NumberFormatException) {
            0
        } finally {
            println("Inside the finally block")
        }
    println(number1)

    try {
        test()
    } catch (e: IllegalStateException) {
        println("IllegalStateException")
    }

    val string2 = "abc"
    val number2 =
        try {
            string2.toInt()
        } catch (e: NumberFormatException) {
            -1
        }
    println(number2) // -1

    val string3 = "abc"
    var number3 = 0 // try to avoid var if possible
    @Suppress("LiftReturnOrAssignment")
    try {
        number3 = string3.toInt()
    } catch (e: NumberFormatException) {
        number3 = -1
    }
    println(number3) // -1
}

fun test() {
    val result =
        try {
            @Suppress("DIVISION_BY_ZERO") val a = 0 / 0 // throws ArithmeticException
        } catch (e: ArithmeticException) {
            throw IllegalStateException(e) // do not forget to deal with it
        }

    println("Working with result")
}
