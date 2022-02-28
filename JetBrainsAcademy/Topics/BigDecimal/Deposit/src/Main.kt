import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val startingAmount = readLine()!!.toBigDecimal()
    val interestRate = readLine()!!.toBigDecimal()
    val numberOfYears = readLine()!!.toInt()

    val finalAmount = startingAmount * (BigDecimal.ONE + interestRate.divide(BigDecimal(100))).pow(numberOfYears)
    println("Amount of money in the account: ${finalAmount.setScale(2, RoundingMode.CEILING)}")
}