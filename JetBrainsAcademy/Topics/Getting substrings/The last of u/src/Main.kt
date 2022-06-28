import java.util.*

fun main() {
    val string = readln()
    val heads = string.substringBeforeLast("u")
    val tails = string.substringAfterLast("u")
    println(heads + "u" + tails.uppercase())
}