import kotlin.math.absoluteValue

fun getLastDigit(n: Int) = n.absoluteValue % 10

/* Do not change code below */
fun main() {
    val a = readLine()!!.toInt()
    println(getLastDigit(a))
}
