import java.util.*

fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    val rotate = readLine()!!.toInt() % input.size

    Collections.rotate(input, rotate)
    println(input.joinToString(" "))
}
