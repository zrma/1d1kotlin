import kotlin.math.*

fun main() {
    val (x0, y0) = readLine()!!.split(" ").map { it.toDouble() }
    val (x1, y1) = readLine()!!.split(" ").map { it.toDouble() }

    val uv = dot(x0, y0, x1, y1)
    val u = distance(x0, y0, 0.0, 0.0)
    val v = distance(x1, y1, 0.0, 0.0)

    val cos = uv / (u * v)
    val degree = acos(cos) * 180.0 / PI

    println(degree.roundToInt())
}

fun dot(x0: Double, y0: Double, x1: Double, y1: Double): Double {
    return (x0 * x1) + (y0 * y1)
}

fun distance(x0: Double, y0: Double, x1: Double, y1: Double): Double {
    return sqrt((x0 - x1).pow(2) + (y0 - y1).pow(2))
}