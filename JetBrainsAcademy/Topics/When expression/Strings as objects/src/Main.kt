fun main() {
    val input = readLine()!!
    println(
        when {
            input.isEmpty() -> input
            input.first() == 'i' -> input.drop(1).toInt().inc()
            input.first() == 's' -> input.drop(1).reversed()
            else -> input
        }
    )
}
