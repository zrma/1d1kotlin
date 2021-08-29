fun main() {
    var idx = 0
    var max = Int.MIN_VALUE
    repeat(readLine()!!.toInt()) {
        val cur = readLine()!!.toInt()
        if (cur > max) {
            max = cur
            idx = it
        }
    }
    println(idx)
}
