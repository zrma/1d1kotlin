fun main() {
    val num = readLine()!!.toInt()

    sequenceOf(2, 3, 5, 6).filter { num % it == 0 }.forEach { println("Divided by $it") }
}
