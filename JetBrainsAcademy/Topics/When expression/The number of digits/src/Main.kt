fun main() {
    val input = readLine()!!.toInt()
    println(
        when {
            input < 10 -> "1"
            input < 100 -> "2"
            input < 1000 -> "3"
            else -> "4"
        }
    )
}
