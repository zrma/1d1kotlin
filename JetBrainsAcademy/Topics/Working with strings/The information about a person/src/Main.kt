import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val (firstName, lastName, age) = List(3) { scanner.next() }
    println("${firstName.first()}. $lastName, $age years old")
}
