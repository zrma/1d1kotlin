package converter

import java.math.BigDecimal
import java.math.BigInteger
import java.math.RoundingMode

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

        if (number.contains(".")) {
            val (integer, fraction) = number.split(".")

            val decimalInteger = toDecimalInteger(integer, source)
            val resultInteger = fromDecimalInteger(decimalInteger, target)

            val decimalFraction = toDecimalFraction(fraction, source)
            val fromDecimalFraction = fromDecimalFraction(decimalFraction, target.toBigDecimal())

            println("Conversion result: $resultInteger.$fromDecimalFraction")
        } else {
            val decimal = toDecimalInteger(number, source)
            val result = fromDecimalInteger(decimal, target)
            println("Conversion result: $result")
        }
    }
}

fun fromDecimalInteger(decimalNumber: BigInteger, targetBase: BigInteger): String {
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
    if (digits.isEmpty()) {
        return "0"
    }
    return digits.reversed().joinToString("") { it.toString() }
}

fun toDecimalInteger(sourceNumber: String, sourceBase: Int): BigInteger {
    var result = BigInteger.ZERO
    for (digit in sourceNumber) {
        result = result.multiply(BigInteger.valueOf(sourceBase.toLong()))
        result = result.add(charToInt(digit).toBigInteger())
    }
    return result
}

fun fromDecimalFraction(decimalNumber: BigDecimal, targetBase: BigDecimal): String {
    val digits = mutableListOf<Char>()
    var number = decimalNumber
    while (number > BigDecimal.ZERO && digits.size < 5) {
        number *= targetBase
        val digit = number.toInt()
        if (digit == 0) {
            digits.add('0')
            continue
        }
        number -= digit.toBigDecimal()
        if (digit < 10) {
            digits.add(digit.digitToChar())
        } else {
            digits.add('a' + (digit - 10))
        }
    }
    if (digits.size < 5) {
        repeat(5 - digits.size) {
            digits.add('0')
        }
    }
    return digits.joinToString("") { it.toString() }
}

fun toDecimalFraction(sourceNumber: String, sourceBase: Int): BigDecimal {
    var result = BigDecimal.ZERO
    var base = BigDecimal(1.0)
    for (digit in sourceNumber) {
        base = base.divide(BigDecimal(sourceBase.toLong()), 10, RoundingMode.CEILING)
        result = result.add(charToInt(digit).toBigDecimal().multiply(base))
    }
    return result
}

fun charToInt(char: Char): Int {
    return char.digitToIntOrNull() ?: (char - 'a' + 10)
}