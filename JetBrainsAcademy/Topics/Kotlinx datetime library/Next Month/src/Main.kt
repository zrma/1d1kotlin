import kotlinx.datetime.DateTimePeriod
import kotlinx.datetime.Instant
import kotlinx.datetime.TimeZone
import kotlinx.datetime.plus

fun nextMonth(date: String): String {
    return Instant.parse(date).plus(DateTimePeriod(months = 1), TimeZone.UTC).toString()
}

fun main() {
    val date = readln()
    println(nextMonth(date))
}