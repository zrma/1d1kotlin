import java.lang.Integer.max

fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    var maxCnt = 1
    var cnt = 1
    input.zipWithNext().forEach {
        if (it.first > it.second) {
            cnt = 1
        } else {
            cnt++
            maxCnt = max(cnt, maxCnt)
        }
    }
    println(maxCnt)
}
