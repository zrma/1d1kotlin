import kotlin.math.*

fun main() {
    val abs = abs(-10) // 10
    val dAbs = abs(-10.33) // 10.33
    println(abs)
    println(dAbs)

    val min = min(11, 81) // 11
    val max = max(20, 30) // 30
    println(min)
    println(max)

    val sqrt = sqrt(2.0) // 1.4142...
    val square = 5.0.pow(2.0) // 25.0
    val cube = 2.0.pow(3.0) // 8.0
    println(sqrt)
    println(square)
    println(cube)

    val e = E // 2.718
    val ln = ln(e) // 1
    val log = log(16.0, 4.0) // 2
    val logSum = ln(exp(2.0) * exp(3.0)) // 5
    println(e)
    println(ln)
    println(log)
    println(logSum)

    val pi = PI // pi is 3.1415...

    val sin = sin(pi / 2) // 1.0
    val cos = cos(pi) // -1.0
    val tan = tan(pi / 4) // 0.99999999... (an inaccurate result)
    println(sin)
    println(cos)
    println(tan)

    val a = 3.toDouble()
    val b = 4.toDouble()
    val c = hypot(a, b) // c is 5.0, function works with Double or Float
    println(c)

    val floor = floor(3.78) // 3.0
    val ceil = ceil(4.15) // 5.0
    println(floor)
    println(ceil)

    val negativeFloor = floor(-3.78) // -4.0
    val negativeCeil = ceil(-4.15) // -4.0
    println(negativeFloor)
    println(negativeCeil)

    val roundDown = round(4.15) // 4.0
    val roundUp = (4.75).roundToInt() // 5, Int
    println(roundDown)
    println(roundUp)

    val roundDownToEven = round(2.5) // 2.0
    val roundUpToEven = round(3.5) // 4.0
    println(roundDownToEven)
    println(roundUpToEven)

    val size1 = 6
    val size2 = 6
    val angle = 60

    val double1 = size1.toDouble() // pow works with double
    val double2 = size2.toDouble()
    val radianAngle = angle * PI / 180 // cos requires an angle in radians

    val res = sqrt(double1.pow(2.0) + double2.pow(2.0) - 2 * double1 * double2 * cos(radianAngle))
    print(res) // 5.999999999999999, inaccurate, but the correct result
}
