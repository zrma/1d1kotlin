fun main() {
    val two = 2 // Int
    val ten = 10 // Int

    val twelve = two + ten // 12
    val eight = ten - two // 8
    val twenty = two * ten // 20
    val five = ten / two // 5
    val zero = ten % two // 0, no remainder

    println("$twelve $eight $twenty $five $zero")

    val longNumber1 = 1_000_000_000_000_000
    val longNumber2: Long = 1_000_000
    val longNumber3 = 1000L

    val result = longNumber1 + longNumber2 - longNumber3
    println(result) // 1000000000999000

    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()

    val sum = a + b

    println(sum)

    val a1 = readLine()!!.toLong()
    val b1 = readLine()!!.toLong()

    val sum1 = a1 + b1

    println(sum1)
}
