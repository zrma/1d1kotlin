fun main() {
    val (var1, op, var2) = readLine()!!.split(" ")

    val num1 = var1.toLong()
    val num2 = var2.toLong()

    println(
        when (op) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 == 0L) "Division by 0!" else num1 / num2
            else -> "Unknown operator"
        }
    )
}
