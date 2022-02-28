package converter

import java.math.BigInteger
import kotlin.math.pow

fun main() {
    while (true) {
        print("Enter two numbers in format: {source base} {target base} (To quit type /exit)")
        val input = readLine() ?: continue
        if (input == "/exit") break

        val (source, target) = input.split(" ")

        convertLoop(source.toInt(), target.toBigInteger())
    }
}

fun convertLoop(source: Int, target: BigInteger) {
    while (true) {
        print("Enter number in base $source to convert to base $target (To go back type /back)")
        val number = readLine()
        if (number == null || number == "/back") return

        val decimal = convertToDecimal(number, source)
        val result = convertFromDecimal(decimal, target)
        println("Conversion result: $result")
    }
}

fun convertFromDecimal(decimalNumber: BigInteger, targetBase: BigInteger): String {
    val digits = mutableListOf<Char>()
    var number = decimalNumber
    while (number > BigInteger.ZERO) {
        val digit = (number % targetBase).toInt()
        if (digit < 10) {
            digits.add(digit.digitToChar())
        } else {
            digits.add('a' + (digit - 10))
        }
        number /= targetBase
    }
    return digits.reversed().joinToString("") { it.toString() }
}

fun convertToDecimal(sourceNumber: String, sourceBase: Int): BigInteger {
    var decimalNumber = BigInteger.ZERO
    var power = 0
    for (digit in sourceNumber.reversed()) {
        val cur = charToInt(digit).toBigInteger() * sourceBase.toBigInteger().pow(power)
        decimalNumber = decimalNumber.add(cur)
        power++
    }
    return decimalNumber
}

fun charToInt(char: Char): Int {
    return char.digitToIntOrNull() ?: (char - 'a' + 10)
}