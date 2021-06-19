import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val (hour, minute, second) = List(3) { scanner.nextInt() }
    val (day, month, year) = List(3) { scanner.nextInt() }
    println("$hour:$minute:$second $day/$month/$year")
}
