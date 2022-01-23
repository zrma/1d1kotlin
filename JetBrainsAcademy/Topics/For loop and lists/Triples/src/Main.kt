fun main() {
    val size = readLine()!!.toInt()
    val input = List(size) { readLine()!!.toInt() }

    var triplesCount = 0
    for (i in 0..size - 3) {
        if (input[i] + 1 == input[i + 1] && input[i + 1] + 1 == input[i + 2]) {
            triplesCount++
        }
    }
    println(triplesCount)
}
