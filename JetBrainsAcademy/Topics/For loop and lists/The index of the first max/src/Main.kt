fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    var maxIdx = 0
    var maxVal = input[0]
    input.withIndex().forEach {
        if (it.value > maxVal) {
            maxIdx = it.index
            maxVal = it.value
        }
    }
    println(maxIdx)
}
