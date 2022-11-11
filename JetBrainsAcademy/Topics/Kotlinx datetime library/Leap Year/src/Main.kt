import kotlinx.datetime.*
import java.lang.Exception

fun isLeapYear(year: String): Boolean {
    try {
        Instant.parse("$year-02-29T00:00:00Z")
    } catch (e: Exception) {
        return false
    }
    return true
}

fun main() {
    val year = readln()
    println(isLeapYear(year))
}