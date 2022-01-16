import java.util.*

fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    Collections.rotate(input, 1)
    println(input.joinToString(" "))
}
