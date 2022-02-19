import java.util.*

fun main() {
    var i = 0

    while (i < 5) {
        println(i)
        i++
    }

    println("Completed")

    var letter = 'A'

    while (letter <= 'Z') {
        print(letter)
        letter++
    }

    val scanner = Scanner(System.`in`)
    while (scanner.hasNext()) {
        val next = scanner.next()
        println(next)
    }

    do {
        val n = readLine()!!.toInt()
        println(n)
    } while (n > 0)
}
