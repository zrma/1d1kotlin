fun main() {
    var res = 0
    repeat(readLine()!!.toInt()) {
        if (readLine()!!.toInt() > 0) {
            ++res
        }
    }
    println(res)
}
