import java.util.*

fun main() {
    val arr = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    val scanner = Scanner(System.`in`)
    val (p, m) = List(2) { scanner.nextInt() }

    val occurred = arr.zipWithNext { a, b -> a == p && b == m || a == m && b == p }.any { it }
    if (occurred) {
        println("NO")
    } else {
        println("YES")
    }
}
