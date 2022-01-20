package search

fun main() {
    val numOfData = readLine()!!.toInt()
    val data = List(numOfData) { readLine()!! }
    val numOfTarget = readLine()!!.toInt()
    repeat(numOfTarget) {
        val target = readLine()!!
        var found = false
        for (datum in data) {
            if (datum.contains(target, ignoreCase = true)) {
                println(datum)
                found = true
            }
        }
        if (!found) {
            println("No matching people found.")
        }
    }
}
