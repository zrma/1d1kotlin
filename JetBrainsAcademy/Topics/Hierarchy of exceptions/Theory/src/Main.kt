fun main() {
    @Suppress("DIVISION_BY_ZERO") val example = 2 / 0 // throws ArithmeticException

    val string = "It's not a number"
    val number = string.toInt() // throws NumberFormatException

    val sequence = "string"
    @Suppress("KotlinConstantConditions")
    println(sequence[10]) // throws StringIndexOutOfBoundsException
}
