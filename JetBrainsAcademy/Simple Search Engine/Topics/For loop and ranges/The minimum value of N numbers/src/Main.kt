import java.lang.Integer.min

fun main() {
    var res = Int.MAX_VALUE
    repeat(readLine()!!.toInt()) { res = min(res, readLine()!!.toInt()) }
    println(res)
}
