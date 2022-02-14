import java.util.*

fun main() {
    val color = readLine()!!
    println(Rainbow.valueOf(color.uppercase(Locale.getDefault())).ordinal + 1)
}

enum class Rainbow {
    RED,
    ORANGE,
    YELLOW,
    GREEN,
    BLUE,
    INDIGO,
    VIOLET
}
