import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    if (List(readLine()!!.toInt()) { readLine()!!.toInt() }
            .containsAll(List(2) { scanner.nextInt() })
    ) {
        println("YES")
    } else {
        println("NO")
    }
}
