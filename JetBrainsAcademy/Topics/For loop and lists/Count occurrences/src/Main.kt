fun main() {
    val list = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    val target = readLine()!!.toInt()
    println(list.count { it == target })
}
