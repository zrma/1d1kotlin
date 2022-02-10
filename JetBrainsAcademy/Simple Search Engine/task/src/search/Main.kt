package search

import java.io.File

fun main(args: Array<String>) {
    val dataFile = args[1]
    val data = File(dataFile).readLines()
    val index = buildIndex(data)

    while (true) {
        when (readLine()!!.toInt()) {
            1 -> {
                val target = readLine()!!
                if (target in index) {
                    index[target]!!.forEach { println(data[it]) }
                } else {
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

fun buildIndex(data: List<String>): Map<String, List<Int>> {
    val result = mutableMapOf<String, List<Int>>()
    for ((index, datum) in data.withIndex()) {
        for (word in datum.split(" ")) {
            result[word] = result.getOrDefault(word, listOf()) + index
        }
    }
    return result
}
