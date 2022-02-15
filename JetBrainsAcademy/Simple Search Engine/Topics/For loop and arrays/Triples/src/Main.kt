fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    var count = 0
    for (i in 0..input.lastIndex - 2) {
        val cur = input[i]
        if (input[i + 1] == cur + 1 && input[i + 2] == cur + 2) {
            ++count
        }
    }
    println(count)
}
