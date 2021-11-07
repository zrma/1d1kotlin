fun main() {
    val (var1, op, var2) = readLine()!!.split(" ")

    val a = var1.toInt()
    val b = var2.toInt()

    when (op) {
        "+" -> println(a + b)
        "-" -> println(a - b)
        "*" -> println(a * b)
        else -> println("Unknown operator")
    }

    when (op) {
        "+", "plus" -> println(a + b)
        "-", "minus", -> println(a - b) // trailing comma
        "*", "times" -> println(a * b)
        else -> println("Unknown operator")
    }

    when (op) {
        "+", "plus" -> {
            val sum = a + b
            println(sum)
        }
        "-", "minus" -> {
            val diff = a - b
            println(diff)
        }
        "*", "times" -> {
            val product = a * b
            println(product)
        }
        else -> println("Unknown operator")
    }

    val result =
        when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            else -> "Unknown operator"
        }
    println(result)

    println(
        when (op) {
            "+" -> a + b
            "-" -> a - b
            "*" -> a * b
            else -> "Unknown operator"
        }
    )

    val (var11, var12, var13) = readLine()!!.split(" ")

    val a1 = var11.toInt()
    val b1 = var12.toInt()
    val c1 = var13.toInt()

    println(
        when (c1) {
            a1 + b1 -> "$c1 equals $a1 plus $b1"
            a1 - b1 -> "$c1 equals $a1 minus $b1"
            a1 * b1 -> "$c1 equals $a1 times $b1"
            else -> "We do not know how to calculate $c1"
        }
    )

    when (readLine()!!.toInt()) {
        0 -> println("n is zero")
        in 1..10 -> println("n is between 1 and 10 (inclusive)")
        in 25..30 -> println("n is between 25 and 30 (inclusive)")
        else -> println("n is outside a range")
    }

    val n = readLine()!!.toInt()

    when {
        n == 0 -> println("n is zero")
        n in 100..200 -> println("n is between 100 and 200")
        n > 300 -> println("n is greater than 300")
        n < 0 -> println("n is negative")
    // else-branch is optional here
    }
}
