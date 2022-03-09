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

    var res = 0
    var negative = false
    val tokens = input.split(" ").toMutableList()
    while (tokens.isNotEmpty()) {
        val token = tokens.removeAt(0)
        if (token.isEmpty()) {
            continue
        }
        val isDigit =
            token.toIntOrNull()?.let {
                if (negative) {
                    res -= it
                } else {
                    res += it
                }
                negative = false
                true
            }
                ?: false
        if (isDigit) {
            continue
        }
        for (c in token) {
            if (c == '-') {
                negative = !negative
            }
        }
    }
    println(res)
}
