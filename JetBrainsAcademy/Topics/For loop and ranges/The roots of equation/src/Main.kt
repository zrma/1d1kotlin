fun pow(x: Int, n: Int): Int {
    var res = x
    repeat(n - 1) { res *= x }
    return res
}

fun main() {
    val (a, b, c, d) = List(4) { readLine()!!.toInt() }
    (0..1000).filter { a * pow(it, 3) + b * pow(it, 2) + c * it + d == 0 }.forEach(::println)
}
