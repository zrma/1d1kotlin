package calculator

fun main() {
    val (a, b) = readLine()!!.split(" ").map { it.toInt() }
    println(a + b)
}
