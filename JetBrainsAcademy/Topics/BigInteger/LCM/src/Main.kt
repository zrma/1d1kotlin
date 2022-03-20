import java.math.BigInteger

fun main() {
    val a = readLine()!!.toBigInteger()
    val b = readLine()!!.toBigInteger()
    println(lcm(a, b))
}

fun lcm(a: BigInteger, b: BigInteger): BigInteger {
    return a * b / gcd(a, b)
}

fun gcd(a: BigInteger, b: BigInteger): BigInteger {
    return if (b == BigInteger.ZERO) a else gcd(b, a % b)
}
