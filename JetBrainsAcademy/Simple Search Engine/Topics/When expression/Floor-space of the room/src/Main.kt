import kotlin.math.sqrt

const val PI = 3.14

fun main() {
    println(
        when (readLine()!!) {
            "triangle" -> getTriangleArea()
            "rectangle" -> getRectangleArea()
            else -> getCircleArea()
        }
    )
}

// NOTE - https://en.wikipedia.org/wiki/Triangle#Using_Heron's_formula
fun getTriangleArea(): Double {
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()
    val s = (a + b + c) / 2
    return sqrt(s * (s - a) * (s - b) * (s - c))
}

fun getRectangleArea(): Double {
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    return a * b
}

fun getCircleArea(): Double {
    val r = readLine()!!.toDouble()
    return PI * r * r
}
