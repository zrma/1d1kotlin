import java.util.*

fun main() {
    println(RainbowWithString.RED.color)
    println(RainbowFinal.RED.rgb)

    val rgb = RainbowFinal.RED
    rgb.printFullInfo()

    val color0: Rainbow = Rainbow.RED
    println(color0.name)

    val color1: Rainbow = Rainbow.GREEN
    println(color1.ordinal)

    println(isRainbow("black"))

    println(Rainbow.valueOf("RED"))

    println(RainbowFinal.findByRgb("#FF0001"))
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

enum class Status {
    OPEN,
    PENDING,
    IN_PROGRESS,
    RESOLVED,
    REJECTED,
    CLOSED
}

enum class Materials {
    GLASS,
    WOOD,
    FABRIC,
    METAL,
    PLASTIC,
    CERAMICS,
    CONCRETE,
    ROCK
}

enum class RainbowWithString(val color: String) {
    RED("Red"),
    ORANGE("Orange"),
    YELLOW("Yellow"),
    GREEN("Green"),
    BLUE("Blue"),
    INDIGO("Indigo"),
    VIOLET("Violet")
}

enum class RainbowFinal(val color: String, val rgb: String) {
    RED("Red", "#FF0000"),
    ORANGE("Orange", "#FF7F00"),
    YELLOW("Yellow", "#FFFF00"),
    GREEN("Green", "#00FF00"),
    BLUE("Blue", "#0000FF"),
    INDIGO("Indigo", "#4B0082"),
    VIOLET("Violet", "#8B00FF"),
    NULL("", "");

    companion object {
        fun findByRgb(rgb: String): RainbowFinal {
            for (enum in RainbowFinal.values()) {
                if (rgb == enum.rgb) return enum
            }
            return NULL
        }
    }

    fun printFullInfo() {
        println("Color - $color, rgb - $rgb")
    }
}

fun isRainbow(color: String): Boolean {
    for (enum in Rainbow.values()) {
        if (color.uppercase(Locale.getDefault()) == enum.name) return true
    }
    return false
}
