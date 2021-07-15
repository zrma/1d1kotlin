fun divide(a: Long, b: Long): Double = a.toDouble() / b

fun main() {
    val a = readLine()!!.toLong()
    val b = readLine()!!.toLong()
    println(divide(a, b))
}
