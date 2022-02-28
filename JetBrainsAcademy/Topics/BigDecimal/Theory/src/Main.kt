import java.math.BigDecimal

fun main() {
    val firstBigDecimal = BigDecimal("10000000000000.5897654329")
    val secondBigDecimal = BigDecimal(readln()) // Store the input number

    println(firstBigDecimal)
    println(secondBigDecimal)

    val bigDecimal0 = BigDecimal(1.000000000000059E13)
    println(bigDecimal0)

    val number1 = 100000.50000
    val bigDecimal1 = number1.toBigDecimal()
    println(bigDecimal1)

    val zero = BigDecimal.ZERO // 0
    val one = BigDecimal.ONE   // 1
    val ten = BigDecimal.TEN   // 10
    println(zero)
    println(one)
    println(ten)

    println(0.1 + 0.2) // 0.30000000000000004

    val first = BigDecimal("0.2")
    val second = BigDecimal("0.1")

    val addition = first + second   // 0.3
    val subtraction = first - second   // 0.1
    val multiplication = first * second // 0.02
    val division = first / second   // 2.0
    val remainder = first % second // 0.0
    println("addition $addition")
    println("subtraction $subtraction")
    println("multiplication $multiplication")
    println("division $division")
    println("remainder $remainder")

    var third = BigDecimal("0.2")
    val decrement = --third //  -0.8
    val increment = ++third //  0.2
    val reverse = -third  //  -0.2
    val module = third.abs()  //  0.2
    val power = third.pow(3)
    println("decrement $decrement")
    println("increment $increment")
    println("reverse $reverse")
    println("module $module")
    println("power $power")
}
