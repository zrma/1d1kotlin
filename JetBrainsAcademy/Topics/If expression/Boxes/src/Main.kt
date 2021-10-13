fun main() {
    val box1 = readLine()!!.split(" ").map { it.toInt() }.sorted()
    val box2 = readLine()!!.split(" ").map { it.toInt() }.sorted()

    val pair = box1.zip(box2)

    when {
        pair.all { it.first == it.second } -> println("Box 1 = Box 2")
        pair.all { it.first <= it.second } -> println("Box 1 < Box 2")
        pair.all { it.first >= it.second } -> println("Box 1 > Box 2")
        else -> println("Incomparable")
    }
}
