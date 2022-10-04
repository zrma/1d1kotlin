import kotlin.math.*

fun main() {
    val a = readLine()!!.toDouble()
    val b = readLine()!!.toDouble()
    val c = readLine()!!.toDouble()

    val d = b * b - 4 * a * c
    var x1 = (-b - sqrt(d)) / (2 * a)
    var x2 = (-b + sqrt(d)) / (2 * a)
    if (x1 > x2) {
        x1 = x2.also { x2 = x1 }
    }
    println("$x1 $x2")
}