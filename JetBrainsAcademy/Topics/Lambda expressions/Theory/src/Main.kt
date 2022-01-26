fun main() {
    val mul1 =
        fun(a: Int, b: Int): Int {
            return a * b
        }

    val mul2 = { a: Int, b: Int -> a * b }

    println(mul1(2, 3)) // prints "6"
    println(mul2(2, 3)) // prints "6" too

    fun isNotDot(c: Char): Boolean = c != '.'
    val originalText = "I don't know... what to say..."
    val textWithoutDots0 = originalText.filter(::isNotDot)
    val textWithoutDots1 = originalText.filter { c -> c != '.' }
    val textWithoutDots2 = originalText.filter { it != '.' }
    println(textWithoutDots0)
    println(textWithoutDots1)
    println(textWithoutDots2)

    val textWithoutSmallDigits0 =
        originalText.filter {
            val isNotDigit = !it.isDigit()
            val stringRepresentation = it.toString()

            isNotDigit || stringRepresentation.toInt() >= 5
        }
    val textWithoutSmallDigits1 =
        originalText.filter {
            if (!it.isDigit()) {
                return@filter true
            }

            it.toString().toInt() >= 5
        }
    println(textWithoutSmallDigits0)
    println(textWithoutSmallDigits1)

    var count = 0

    val changeAndPrint = {
        ++count
        println(count)
    }

    println(count) // 0
    changeAndPrint() // 1
    count += 10
    changeAndPrint() // 12
    println(count) // 12

    fun placeArgument(value: Int, f: (Int, Int) -> Int): (Int) -> Int {
        return { i -> f(value, i) }
    }
    println(placeArgument(2) { a, b -> a * b }(3)) // prints "6"

    fun sum(a: Int, b: Int): Int = a + b

    val increment = placeArgument(1, ::sum)
    val triple = placeArgument(3, mul2)

    println(increment(4)) // 5
    println(increment(40)) // 41
    println(triple(4)) // 12
    println(triple(40)) // 120
}
