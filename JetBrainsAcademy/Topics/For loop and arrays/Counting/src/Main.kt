fun main() {
    val numbers = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    val target = readLine()!!.toInt()
    println(numbers.count { it == target })
}
