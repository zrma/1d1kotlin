import kotlin.math.ceil

fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val n = readLine()!!.toInt()
    println(b / n - ceil(a.toDouble() / n).toInt() + 1)
}
