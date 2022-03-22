import java.util.*

fun main() {
    val one = 1.0
    val negNumber = -1.75

    val pi = 3.1415

    @Suppress("RedundantExplicitType") val b: Float = 8.75f
    println(b)

    val e = 2.71828f
    println(e)

    val number = one + 1.5 // 2.5
    println(number)

    val c = b + negNumber // 7, Double, the type is inferred from the context
    println(c)

    val squaredPi = pi * pi // 9.86902225
    println(squaredPi / 2) // prints 4.934511125

    println(3.3 / 3) // prints 1.0999999999999999

    val num = 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1 + 0.1
    println(num) // it prints 0.9999999999999999

    val f = readln().toFloat() // Float
    val d = readln().toDouble() // Double
    println(f)
    println(d)

    val base = readln().toDouble()
    val height = readln().toDouble()

    val area = (base * height) / 2

    println(area)

    val floatNum = readln().format(Locale.US).toFloat()
    println(floatNum)
}
