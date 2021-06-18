import kotlin.math.sqrt

fun main() {
    val num = 100
    val res: Double = sqrt(num.toDouble())
    println(res) // 10.0
    println(num) // 100, it is not modified

    val long: Long = num.toLong() // 100
    println(long)

    val n1 = 125
    val ch: Char = n1.toChar() // '}'
    val n2: Int = ch.toInt() // 125
    println(n2)

    val d: Double = 12.5
    val n: Long = d.toLong() // 12
    println(d)
    println(n)

    val res1: Int = d.toInt() // 12
    val res2: Int = n.toInt() // 12
    println(res1)
    println(res2)

    val bigNum: Long = 100_000_000_000_000

    val overFlow: Int = bigNum.toInt() // 276447232; oops
    println(overFlow)

    val floatNumber = 10f
    val doubleNumber = 1

    // val shortNumber = floatNumber.toShort() // avoid this
    val shortNumber = floatNumber.toInt().toShort() // correct way
    val byteNumber = doubleNumber.toByte() // correct way
    println(shortNumber)
    println(byteNumber)

    val n0 = 8 // Int
    val d0 = 10.09 // Double
    val c0 = '@' // Char
    val b0 = true // Boolean

    val s1 = n0.toString() // "8"
    val s2 = d0.toString() // "10.09"
    val s3 = c0.toString() // "@"
    val s4 = b0.toString() // "true"
    println("$s1 $s2 $s3 $s4")

    val n3 = "8".toInt() // Int
    val d3 = "10.09".toDouble() // Double
    val b3 = "true".toBoolean() // Boolean
    println("$n3 $d3 $b3")

    val b00 = "false".toBoolean() // false
    val b01 = "tru".toBoolean() // false
    val b02 = "true".toBoolean() // true
    val b03 = "TRUE".toBoolean() // true
    println("$b00 $b01 $b02 $b3")

    val something = readLine()!!

    val d4 = something.toDouble()
    val f4 = d4.toFloat()
    val i4 = f4.toInt()
    val b4 = i4.toByte()

    println(d4)
    println(f4)
    println(i4)
    println(b4)
    println(something.toBoolean())
}
