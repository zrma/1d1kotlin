fun main() {
    val input = List(readLine()!!.toInt()) { readLine()!!.toInt() }
    val (p, m) = readLine()!!.split(" ").map { it.toInt() }
    if (input.contains(p) && input.contains(m)) {
        println("YES")
    } else {
        println("NO")
    }
}
