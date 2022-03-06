package calculator

fun main() {
    while (true) {
        val input = readLine() ?: continue
        if (input == "/exit") {
            println("Bye!")
            break
        }
        if (input.isEmpty()) {
            continue
        }
        if (!input.contains(" ")) {
            println(input)
            continue
        }
        val args = input.split(" ").map { it.toInt() }
        if (args.size != 2) {
            println(input)
            continue
        }
        val (a, b) = args
        println(a + b)
    }
}
