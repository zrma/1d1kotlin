const val UP = 1
const val DOWN = 2
const val LEFT = 3
const val RIGHT = 4
const val STAY = 0

fun main() {
    val input = readLine()!!.toInt()
    println(
        when (input) {
            UP -> "move up"
            DOWN -> "move down"
            LEFT -> "move left"
            RIGHT -> "move right"
            STAY -> "do not move"
            else -> "error!"
        }
    )
}
