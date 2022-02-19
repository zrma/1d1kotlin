fun main() {
    val input = List(3) { readLine()!!.toInt() }
    val asc = input.zipWithNext { a, b -> a <= b }.all { it }
    val desc = input.zipWithNext { a, b -> a >= b }.all { it }
    println(asc || desc)
}
