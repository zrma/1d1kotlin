enum class DaysOfTheWeek(val label: String) {
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday"),
    SATURDAY("Saturday")
}

fun main() {
    val days = DaysOfTheWeek.values()
    for (day in days) {
        println(day.name)
    }
}