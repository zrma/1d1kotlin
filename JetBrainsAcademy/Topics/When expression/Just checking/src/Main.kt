const val VALID = 2
const val INVALID_BEGIN = 1
const val INVALID_END = 4

fun main() {
    println(
        when (readLine()!!.toInt()) {
            VALID -> "Yes!"
            in INVALID_BEGIN..INVALID_END -> "No!"
            else -> "Unknown number"
        }
    )
}
