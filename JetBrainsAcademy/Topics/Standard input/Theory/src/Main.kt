import java.util.*

fun main() {
    val line0 = readLine()!!
    println(line0)

    val scanner = Scanner(System.`in`)
    val line = scanner.nextLine() // read a whole line, i.e. "Hello, Kotlin"
    val num = scanner.nextInt() // read a number, i.e. 123
    val string = scanner.next() // read a string, i.e. "Hello"

    println(line)
    println(num)
    println(string)

    val num1 = scanner.nextInt() // reads the first number
    val num2 = scanner.nextInt() // reads the second number

    println(num2) // prints the second number
    println(num1) // prints the first number
}
