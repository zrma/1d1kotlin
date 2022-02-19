fun main() {
    val (x, y, z) = List(3) { readLine()!!.toBoolean() }
    print(!(x && y) || z)
}
