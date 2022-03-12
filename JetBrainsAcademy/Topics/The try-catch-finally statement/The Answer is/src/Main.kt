fun main() {
    val answer: Int =
        try {
            readLine()!!.toInt()
        } catch (_: Exception) {
            42
        } finally {
            println("The answer is a number")
        }
    println(answer)
}
