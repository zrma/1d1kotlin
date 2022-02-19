fun main() {
    val time0 = List(3) { readLine()!!.toInt() }.reduce { a, b -> 60 * a + b }
    val time1 = List(3) { readLine()!!.toInt() }.reduce { a, b -> 60 * a + b }

    println(time1 - time0)
}
