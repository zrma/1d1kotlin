package calculator

fun main() {
    val variables = mutableMapOf<String, Int>()

    while (true) {
        val input = readLine() ?: continue

        if (input.startsWith("/")) {
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
                    println("Unknown command")
                    continue
                }
            }
        } else {
            try {
                calc(input.trim(), variables)
            } catch (e: Exception) {
                println(e.message)
            }
        }
    }
}

fun calc(input: String, variables: MutableMap<String, Int>) {
    if (input.isEmpty()) {
        return
    }

    if (input.contains("=")) {
        processAssignment(input, variables)
        return
    }

    if (!input.contains(" ")) {
        processUnary(input, variables)
        return
    }

    val res = calcExpression(input, variables)
    println(res)
}

fun processAssignment(input: String, variables: MutableMap<String, Int>) {
    val tokens = input.split("=").map { it.trim() }
    if (tokens.size != 2) {
        throw Exception("Invalid assignment")
    }

    val (left, right) = tokens

    if (!isValidVariableName(left)) {
        throw Exception("Invalid identifier")
    }
    val isDigit =
        right.toIntOrNull()?.let {
            variables[left] = it
            true
        }
            ?: false
    if (!isDigit) {
        try {
            variables[left] = calcExpression(right, variables)
        } catch (e: Exception) {
            throw Exception("Invalid assignment")
        }
    }
}

fun processUnary(input: String, variables: MutableMap<String, Int>) {
    if (input in variables) {
        println(variables[input] ?: 0)
        return
    }
    if (isValidVariableName(input)) {
        throw Exception("Unknown variable")
    }
    try {
        println(input.toInt())
    } catch (e: Exception) {
        throw Exception("Invalid expression")
    }
}

fun calcExpression(input: String, variables: MutableMap<String, Int>): Int {
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
        if (token.matches("[\\+\\-]+".toRegex())) {
            for (c in token) {
                if (c == '-') {
                    negative = !negative
                }
            }
            continue
        }
        if (!isValidVariableName(token)) {
            throw Exception("Invalid expression")
        }
        if (token !in variables) {
            throw Exception("Unknown variable")
        }
        if (negative) {
            res -= variables[token]!!
        } else {
            res += variables[token]!!
        }
        negative = false
        continue
    }
    return res
}

fun isValidVariableName(variable: String): Boolean {
    return variable.matches(Regex("[a-zA-Z]*"))
}
