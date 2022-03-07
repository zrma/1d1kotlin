package calculator

fun main() {
    while (true) {
        val input = readLine() ?: continue

        when (input) {
            "/exit" -> {
                println("Bye!")
                break
            }
            "/help" -> {
                println("The program calculates the sum of numbers")
                continue
            }
            else -> {
                calc(input)
            }
        }
    }
}

fun calc(input: String) {
    if (input.isEmpty()) {
        return
    }
    if (!input.contains(" ")) {
        println(input)
        return
    }
    val sum = input.split(" ").sumOf { it.toInt() }
    println(sum)
}
