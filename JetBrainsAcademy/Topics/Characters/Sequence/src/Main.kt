fun main() {
    val input = List(3) { readLine()!!.single() }
    println(input.zipWithNext { a, b -> a.inc() == b }.all { it })
}
