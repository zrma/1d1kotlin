fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    val (p, m) = readLine()!!.split(" ").map { it.toInt() }

    println(
        when (input.zipWithNext().any {
                it.first == p && it.second == m || it.first == m && it.second == p
            }
        ) {
            true -> "NO"
            false -> "YES"
        }
    )
}
