fun main() {
    var (target, left, right) = List(3) { readLine()!!.toInt() }
    if (left > right) {
        right = left.also { left = right }
    }
    val result = target in left..right
    println(result)
}
