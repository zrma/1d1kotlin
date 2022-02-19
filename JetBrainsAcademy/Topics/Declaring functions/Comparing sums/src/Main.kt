fun sum(a: Int, b: Int) = a + b

fun isGreater(a0: Int, a1: Int, b0: Int, b1: Int) = sum(a0, a1) > sum(b0, b1)

fun main() {
    val number1 = readLine()!!.toInt()
    val number2 = readLine()!!.toInt()
    val number3 = readLine()!!.toInt()
    val number4 = readLine()!!.toInt()

    println(isGreater(number1, number2, number3, number4))
}
