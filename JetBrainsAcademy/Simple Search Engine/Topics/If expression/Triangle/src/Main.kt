fun main() {
    val (a, b, c) = List(3) { readLine()!!.toInt() }.sorted()
    println(if (a + b > c) "YES" else "NO")
}
