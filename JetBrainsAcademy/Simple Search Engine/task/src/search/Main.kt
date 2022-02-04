package search

import java.io.File

fun main(args: Array<String>) {
    val dataFile = args[1]
    val data = File(dataFile).readLines()

    while (true) {
        when (readLine()!!.toInt()) {
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
