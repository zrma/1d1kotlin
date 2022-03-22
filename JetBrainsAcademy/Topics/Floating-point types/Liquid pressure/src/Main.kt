const val GRAVITY = 9.8

fun main() {
    val densityOfLiquid = readLine()!!.toDouble()
    val heightOfColumn = readLine()!!.toDouble()

    val liquidPressure = densityOfLiquid * heightOfColumn * GRAVITY
    println(liquidPressure)
}
