import java.util.*

fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    val n = readLine()!!.toInt()

    Collections.rotate(input, n)
    println(input.joinToString(" "))
}
