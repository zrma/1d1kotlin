fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    try {
        println(a / b)
    } catch (e: ArithmeticException) {
        println("Division by zero, please fix the second argument!")
    }
}
