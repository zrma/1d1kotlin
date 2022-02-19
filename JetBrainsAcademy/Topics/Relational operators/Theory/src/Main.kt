fun main() {
    val one = 1
    val two = 2
    val three = 3
    val four = 4

    val oneIsOne = one == one // true
    println(oneIsOne)

    val res1 = two <= three // true
    val res2 = two != four // true
    val res3 = two > four // false
    val res4 = one == three // false

    println(res1)
    println(res2)
    println(res3)
    println(res4)

    val number = 1000
    val result = number + 10 > number + 9 // 1010 > 1009 is true
    println(result)

    val oneAsLong: Long = 1
    val zeroAsInt: Int = 0

    println(oneAsLong >= zeroAsInt) // OK, prints true
    // println(oneAsLong == zeroAsInt) // Error
    println(oneAsLong == zeroAsInt.toLong()) // OK, prints false

    println((number > 100) && (number < 200))
    println(number in 101..199)

    val left = 100
    val right = 200
    val guessNumber = readLine()!!.toInt()

    val inRange = guessNumber in left..right // joining two expressions using AND
    println(inRange)
}
