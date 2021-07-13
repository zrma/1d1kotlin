fun main() {
    val (first, second) = List(2) { readLine()!!.toInt()..readLine()!!.toInt() }
    val target = readLine()!!.toInt()
    println(target in first || target in second)
}
