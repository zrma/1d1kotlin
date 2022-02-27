import java.math.BigInteger

fun main() {
    val a = BigInteger(readLine()!!)
    val b = BigInteger(readLine()!!)

    println((a + b + (a - b).abs()) / BigInteger.TWO)
}