fun main() {
    val input = readLine()!!.map { it.digitToInt() }
    if (input.subList(0, 3).sum() == input.subList(3, 6).sum()) {
        println("Lucky")
    } else {
        println("Regular")
    }
}
