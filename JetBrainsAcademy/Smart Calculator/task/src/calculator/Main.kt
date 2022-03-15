package calculator

import java.util.*

class List()

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

    if (processUnary(input, variables)) {
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

    val digit = right.toIntOrNull()
    if (digit != null) {
        variables[left] = digit
        return
    }
    try {
        variables[left] = calcExpression(right, variables)
    } catch (e: Exception) {
        throw Exception("Invalid assignment")
    }
}

fun processUnary(input: String, variables: MutableMap<String, Int>): Boolean {
    if (input in variables) {
        println(variables[input] ?: 0)
        return true
    }
    if (isValidVariableName(input)) {
        throw Exception("Unknown variable")
    }
    val digit = input.toIntOrNull()
    if (digit != null) {
        println(digit)
        return true
    }
    return false
}

fun calcExpression(input: String, variables: MutableMap<String, Int>): Int {
    val expr = infixToPostfix(input, variables)
    return calcPostfix(expr)
}

fun calcPostfix(queue: MutableList<String>): Int {
    val stack = Stack<Int>()
    val operators =
        mapOf(
            "+" to 1,
            "-" to 1,
            "*" to 2,
            "/" to 2,
        )

    while (queue.isNotEmpty()) {
        val token = queue.removeAt(0)
        if (token in operators) {
            val a = stack.pop()
            val b = stack.pop()
            val result =
                when (token) {
                    "+" -> a + b
                    "-" -> b - a
                    "*" -> a * b
                    "/" -> b / a
                    else -> throw Exception("Unknown operator")
                }
            stack.push(result)
        } else {
            val digit = token.toIntOrNull() ?: throw Exception("Invalid expression")
            stack.push(digit)
        }
    }
    return stack.pop()
}

fun infixToPostfix(input: String, variables: MutableMap<String, Int>): MutableList<String> {
    val queue: Queue<String> = LinkedList()
    val operators =
        mapOf(
            "+" to 1,
            "-" to 1,
            "*" to 2,
            "/" to 2,
        )

    val stack = Stack<String>()
    val output = mutableListOf<String>()

    val tokens = parseExpr(input)

    while (tokens.isNotEmpty() || queue.isNotEmpty()) {
        val token = tokens.removeAt(0).trim()
        if (token == "") {
            continue
        }

        when {
            token == "(" -> {
                stack.push(token)
            }
            token == ")" -> {
                try {
                    while (stack.peek() != "(") {
                        output.add(stack.pop())
                    }
                    stack.pop()
                } catch (e: Exception) {
                    // unmatched parentheses
                    // ex: 4 + 5) → `(` is missing
                    throw Exception("Invalid expression")
                }
            }
            operators.contains(token) -> {
                if (stack.isEmpty()) {
                    stack.push(token)
                } else {
                    while (stack.isNotEmpty() &&
                        operators.contains(stack.peek()) &&
                        operators[token]!! <= operators[stack.peek()]!!) {
                        output.add(stack.pop())
                    }
                    stack.push(token)
                }
            }
            else -> {
                var digit = token.toIntOrNull()
                if (digit == null) {
                    if (!isValidVariableName(token)) {
                        throw Exception("Invalid identifier")
                    }
                    digit = variables[token] ?: throw Exception("Unknown variable")
                }
                output.add(digit.toString())
            }
        }
    }
    while (stack.isNotEmpty()) {
        output.add(stack.pop())
    }
    return output
}

fun removeDuplicatedOps(input: String): String {
    var str = input
    while (str.contains("++") || str.contains("--") || str.contains("+-") || str.contains("-+")) {
        mapOf("++" to "+", "--" to "+", "+-" to "-", "-+" to "-").forEach {
            str = str.replace(it.key, it.value)
        }
    }
    return str
}

fun parseExpr(input: String): MutableList<String> {
    var str = input.replace(" ", "")
    if (str.contains("**") || str.contains("//")) {
        throw Exception("Invalid expression")
    }
    str = removeDuplicatedOps(str)
    arrayOf("*", "/", "(", ")", "+", "-").forEach { str = str.replace(it, " $it ") }
    return str.split(" ").toMutableList()
}

fun isValidVariableName(variable: String): Boolean {
    return variable.matches(Regex("[a-zA-Z]*"))
}
