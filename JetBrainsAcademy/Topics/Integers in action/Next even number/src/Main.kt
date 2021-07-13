fun main() {
    println(readLine()!!.toInt().inc().let { it + it % 2 })
}
