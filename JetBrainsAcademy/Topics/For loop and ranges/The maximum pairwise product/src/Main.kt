fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }

    var max = input.first()
    for (i in 0 until input.lastIndex) {
        for (j in i + 1..input.lastIndex) {
            max = (input[i] * input[j]).coerceAtLeast(max)
        }
    }
    println(max)
}
