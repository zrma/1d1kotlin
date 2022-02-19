import java.util.*

fun main() {
    val (str, num) = readLine()!!.split(" ")
    val seq = str.toMutableList()
    if (num.toInt() < str.length) {
        Collections.rotate(seq, str.length - num.toInt())
    }
    println(seq.joinToString(""))
}
