import java.util.*

fun main() {
    println(isRainbow(readLine()!!))
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

fun isRainbow(color: String): Boolean {
    for (enum in Rainbow.values()) {
        if (color.uppercase(Locale.getDefault()) == enum.name) return true
    }
    return false
}
