fun main() {
    var tot = 0
    var cur: Int
    do {
        cur = readLine()!!.toInt()
        tot += cur
    } while (cur != 0)
    println(tot)
}
