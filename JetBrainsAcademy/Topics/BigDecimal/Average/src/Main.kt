import java.math.BigDecimal
import java.math.RoundingMode

fun main() {
    val first = readLine()!!.toBigDecimal()
    val second = readLine()!!.toBigDecimal()
    val third = readLine()!!.toBigDecimal()
    val result = (first + second + third) / BigDecimal(3.0)
    println(result.toBigInteger())
}