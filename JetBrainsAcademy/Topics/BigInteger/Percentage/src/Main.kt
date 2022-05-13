import java.math.BigInteger

fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()

    val sum = a + b

    val res0 = a.multiply(BigInteger.valueOf(100)) / sum
    val res1 = b.multiply(BigInteger.valueOf(100)) / sum

    println("$res0% $res1%")
}
