package tasklist

import java.util.*

fun main() {
    val todo = TaskList()

    while (true) {
        print("Input an action (add, print, end):")
        val input = readLine()!!.trim()
        when (input) {
            "add" -> {
                print("Input a new task (enter a blank line to end):")
                val lines = readLines()
                if (lines.isEmpty() || lines.size == 1 && lines[0].isEmpty()) {
                    println("The task is blank")
                } else {
                    todo.add(Task(lines))
                }
            }

            "print" -> todo.printAll()

            "end" -> {
                @Suppress("SpellCheckingInspection")
                println("Tasklist exiting!")
                break
            }

            else -> println("The input action is invalid")
        }
    }
}

fun readLines(): List<String> {
    val res = mutableListOf<String>()
    val scanner = Scanner(System.`in`)
    while (scanner.hasNextLine()) {
        val input = scanner.nextLine().trim()
        if (input.isEmpty()) {
            break
        }
        res.add(input)
    }
    return res
}

class TaskList {
    fun printAll() {
        if (tasks.isEmpty()) {
            println("No tasks have been input")
        } else {
            tasks.forEachIndexed() { index, item ->
                item.print(index + 1)
                println()
            }
        }
    }

    fun add(task: Task) {
        tasks.add(task)
    }

    private val tasks = mutableListOf<Task>()
}

data class Task(val description: List<String>) {
    fun print(idx: Int) {
        description.forEachIndexed() { index, item ->
            if (index == 0) {
                println(String.format("%-2d %s", idx, item))
            } else {
                println(String.format("%-2s %s", "", item))
            }
        }
    }
}