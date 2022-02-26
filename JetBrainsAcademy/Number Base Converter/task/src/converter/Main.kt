package converter

import kotlin.math.pow

fun main() {
    while (true) {
        print("Do you want to convert /from decimal or /to decimal? (To quit type /exit)")
        when (readLine()) {
            "/from" -> from()
            "/to" -> to()
            else -> break
        }
    }
}

fun from() {
    print("Enter number in decimal system:")
    val decimalNumber = readLine()!!.toInt()

    print("Enter target base:")
    val targetBase = readLine()!!.toInt()

    println("Conversion result: ${convertFromDecimal(decimalNumber, targetBase)}")
}

fun convertFromDecimal(decimalNumber: Int, targetBase: Int): String {
    val digits = mutableListOf<Char>()
    var number = decimalNumber
    while (number > 0) {
        val digit = number % targetBase
        if (digit < 10) {
            digits.add(digit.digitToChar())
        } else {
            digits.add('a' + (digit - 10))
        }
        number /= targetBase
    }
    return digits.reversed().joinToString("") { it.toString() }
}

fun to() {
    print("Enter source number:")
    val sourceNumber = readLine()!!

    print("Enter source base:")
    val sourceBase = readLine()!!.toInt()

    println("Conversion to decimal result: ${convertToDecimal(sourceNumber, sourceBase)}")
}

fun convertToDecimal(sourceNumber: String, sourceBase: Int): Int {
    var decimalNumber = 0
    var power = 0
    for (digit in sourceNumber.reversed()) {
        decimalNumber += charToInt(digit) * sourceBase.toDouble().pow(power).toInt()
        power++
    }
    return decimalNumber
}

fun charToInt(char: Char): Int {
    return char.digitToIntOrNull() ?: (char - 'a' + 10)
}