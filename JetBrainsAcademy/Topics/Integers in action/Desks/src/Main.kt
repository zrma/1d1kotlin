fun main() {
    println(List(3) { readLine()!!.toInt().inc() / 2 }.sum())
}
