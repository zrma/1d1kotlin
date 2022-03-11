fun intDivision(x: String, y: String): Int {
    return try {
        x.toInt() / y.toInt()
    } catch (e: ArithmeticException) {
        println("Exception: division by zero!")
        0
    } catch (e: NumberFormatException) {
        println("Read values are not integers.")
        0
    }
}

fun main() {
    val x = readLine()!!
    val y = readLine()!!
    println(intDivision(x, y))
}
