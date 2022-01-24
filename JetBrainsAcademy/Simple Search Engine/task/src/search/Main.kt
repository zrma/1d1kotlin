package search

fun main() {
    val numOfData = readLine()!!.toInt()
    val data = List(numOfData) { readLine()!! }

    while (true) {
        val command = readLine()!!.toInt()
        when (command) {
            1 -> {
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
            2 -> {
                for (datum in data) {
                    println(datum)
                }
            }
            0 -> {
                println("Bye!")
                return
            }
            else -> {
                println("Incorrect option! Try again.")
            }
        }
    }
}
