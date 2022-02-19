fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    println(
        when (input.contains(readLine()!!.toInt())) {
            true -> "YES"
            false -> "NO"
        }
    )
}
