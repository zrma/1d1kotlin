fun main() {
    val (target, from, to) = List(3) { readLine()!!.toInt() }
    println(target in from..to)
}
