fun main() {
    val input = List(3) { readLine()!!.toInt() }
    val sum = input.sum()
    input.forEach {
        if (sum - it == 20) {
            println(true)
            return
        }
    }
    println(false)
}
