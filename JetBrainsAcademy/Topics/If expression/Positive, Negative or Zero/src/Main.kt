fun main() {
    val input = readLine()!!.toInt()
    when {
        input < 0 -> println("negative")
        input > 0 -> println("positive")
        else -> println("zero")
    }
}
