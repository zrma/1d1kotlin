package search

import java.io.File
import java.util.*

fun main(args: Array<String>) {
    val dataFile = args[1]
    val data = File(dataFile).readLines()
    val index = buildIndex(data)

    while (true) {
        when (readLine()!!.toInt()) {
            1 -> {
                val strategy = readLine()!!
                val targets = readLine()!!.split(" ")

                when (strategy) {
                    "ALL" -> {
                        var results = index.values.flatten().toSet()
                        for (target in targets) {
                            if (target !in index) {
                                results = emptySet()
                                break
                            }
                            results = results.intersect(index[target]!!.toSet())
                        }
                        for (result in results) {
                            println(data[result])
                        }
                    }
                    "ANY" -> {
                        var results = emptySet<Int>()
                        for (target in targets) {
                            if (target !in index) {
                                continue
                            }
                            results = results.union(index[target]!!.toSet())
                        }
                        for (result in results) {
                            println(data[result])
                        }
                    }
                    else -> {
                        var results = index.values.flatten().toSet()
                        for (target in targets) {
                            if (target !in index) {
                                continue
                            }
                            results = results.subtract(index[target]!!.toSet())
                        }
                        for (result in results) {
                            println(data[result])
                        }
                    }
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

fun buildIndex(data: List<String>): TreeMap<String, List<Int>> {
    val result = TreeMap<String, List<Int>>(String.CASE_INSENSITIVE_ORDER)
    for ((index, datum) in data.withIndex()) {
        for (word in datum.split(" ")) {
            result[word] = result.getOrDefault(word, listOf()) + index
        }
    }
    return result
}
