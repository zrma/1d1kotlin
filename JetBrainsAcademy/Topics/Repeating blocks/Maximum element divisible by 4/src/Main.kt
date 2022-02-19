fun main() {
    var res = 0
    repeat(readLine()!!.toInt()) {
        val n = readLine()!!.toInt()
        if (n % 4 == 0 && n > res) {
            res = n
        }
    }
    println(res)
}
