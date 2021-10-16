fun main() {
    val len = readLine()!!.toInt()
    if (len == 1) {
        println(readLine()!!.toInt())
        return
    }

    var max0 = Int.MIN_VALUE
    var max1 = Int.MIN_VALUE

    repeat(len) {
        val input = readLine()!!.toInt()
        when {
            max0 < input -> {
                max1 = max0
                max0 = input
            }
            max1 < input -> max1 = input
        }
    }
    println(max0 * max1)
}
