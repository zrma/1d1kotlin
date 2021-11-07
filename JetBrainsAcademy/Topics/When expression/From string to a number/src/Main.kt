const val ONE = 1
const val TWO = 2
const val THREE = 3
const val FOUR = 4
const val FIVE = 5
const val SIX = 6
const val SEVEN = 7
const val EIGHT = 8
const val NINE = 9

fun main() {
    println(
        when (readLine()!!) {
            "one" -> ONE
            "two" -> TWO
            "three" -> THREE
            "four" -> FOUR
            "five" -> FIVE
            "six" -> SIX
            "seven" -> SEVEN
            "eight" -> EIGHT
            "nine" -> NINE
            else -> 0
        }
    )
}
