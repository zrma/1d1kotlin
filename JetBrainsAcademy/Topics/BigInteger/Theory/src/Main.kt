import java.math.BigInteger

fun main() {
    // val y: Int = 62957291795228763406253098 // compilation error: The value is out of range

    var a: Int = Int.MAX_VALUE // 2147483647
    a += 2 // -2147483647
    println(a) // -2147483647

    val number0 = BigInteger("62957291795228763406253098")
    println(number0)

    val number1 = BigInteger.valueOf(1000000000)
    println(number1)

    val zero = BigInteger.ZERO // 0
    val one = BigInteger.ONE   // 1
    val ten = BigInteger.TEN   // 10
    println(zero)
    println(one)
    println(ten)

    val numToBigInt = 1234.toBigInteger()
    val strToBigInt = "1234".toBigInteger()
    println(numToBigInt)
    println(strToBigInt)

    val eleven = ten + one             // 10 + 1 = 11
    val nine = ten - one               // 10 - 1 = 9
    val oneHundredTen = ten * eleven   // 10 * 11 = 110
    val twelve = oneHundredTen / nine  // integer division = 12
    val two = oneHundredTen % nine     // remainder = 2

    println(twelve)
    println(two)

    val minusOne = -one // -1
    println(minusOne)

    val (result, remainder) = oneHundredTen.divideAndRemainder(nine) // 12 and 2
    println(result)
    println(remainder)

    val minusEight = BigInteger("-8")
    println(minusEight.abs()) // 8

    val eight = BigInteger.valueOf(8)
    val six = BigInteger.valueOf(6)
    println(eight.gcd(six)) // 2
}
