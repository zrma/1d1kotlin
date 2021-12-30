fun main() {
    var res = Int.MIN_VALUE
    var cur = 0
    do {
        cur = readLine()!!.toInt()
        res = res.coerceAtLeast(cur)
    } while (cur != 0)
    println(res)
}
