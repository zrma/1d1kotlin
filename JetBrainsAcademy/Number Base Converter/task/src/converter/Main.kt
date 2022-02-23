package converter

fun main() {
    print("Enter number in decimal system:")
    val decimalNumber = readLine()!!.toInt()

    print("Enter target base:")
    val targetBase = readLine()!!.toInt()

    println("Conversion result: ${convert(decimalNumber, targetBase)}")
}

fun convert(decimalNumber: Int, targetBase: Int): String {
    val digits = mutableListOf<Int>()
    var number = decimalNumber
    while (number > 0) {
        digits.add(number % targetBase)
        number /= targetBase
    }
    return digits.reversed().joinToString("") { it.toString() }
}