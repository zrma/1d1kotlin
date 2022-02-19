fun main() {
    val inputs = List(3) { readLine()!!.split(" ").map { it.toInt() } }
    val resultX = mutableListOf(1, 2, 3, 4, 5)
    val resultY = mutableListOf(1, 2, 3, 4, 5)
    for (input in inputs) {
        resultX.remove(input[0])
        resultY.remove(input[1])
    }
    println(resultX.joinToString(" ") { it.toString() })
    println(resultY.joinToString(" ") { it.toString() })
}
