package tasklist

import kotlinx.datetime.LocalDate
import java.time.DateTimeException
import java.time.LocalTime
import java.util.*

fun main() {
    val todo = TaskList()

    while (true) {
        print("Input an action (add, print, end):")
        when (readLine()!!.trim()) {
            "add" -> {
                val priority = readPriority()
                val date = readDate()
                val time = readTime()

                print("Input a new task (enter a blank line to end):")
                val taskBody = readTaskBody()
                if (taskBody.isEmpty() || taskBody.size == 1 && taskBody[0].isEmpty()) {
                    println("The task is blank")
                } else {
                    todo.add(Task(priority, date, time, taskBody))
                }
            }

            "print" -> todo.printAll()

            "end" -> {
                @Suppress("SpellCheckingInspection") println("Tasklist exiting!")
                break
            }

            else -> println("The input action is invalid")
        }
    }
}

fun readPriority(): String {
    while (true) {
        print("Input the task priority (C, H, N, L):")
        val priority = readLine()!!.trim()
        if (priority.uppercase() in listOf("C", "H", "N", "L")) {
            return priority.uppercase()
        }
    }
}

fun readDate(): LocalDate {
    while (true) {
        print("Input the date (yyyy-mm-dd):")
        val date = readLine()!!.trim()
        val res = Regex("\\d{4}-\\d{1,2}-\\d{1,2}").find(date)
        if (res == null) {
            println("The input date is invalid")
            continue
        }
        date.split("-").let {
            try {
                return LocalDate(it[0].toInt(), it[1].toInt(), it[2].toInt())
            } catch (e: IllegalArgumentException) {
                println("The input date is invalid")
            } catch (e: DateTimeException) {
                println("The input date is invalid")
            }
        }
    }
}

fun readTime(): LocalTime {
    while (true) {
        print("Input the time (hh:mm):")
        val time = readLine()!!.trim()
        val res = Regex("\\d{1,2}:\\d{1,2}").find(time)
        if (res == null) {
            print("The input time is invalid")
            continue
        }
        time.split(":").let {
            try {
                return LocalTime.of(it[0].toInt(), it[1].toInt())
            } catch (e: IllegalArgumentException) {
                println("The input time is invalid")
            }  catch (e: DateTimeException) {
                println("The input time is invalid")
            }
        }
    }
}

fun readTaskBody(): List<String> {
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

data class Task(val priority: String, val date: LocalDate, val time: LocalTime, val description: List<String>) {
    fun print(idx: Int) {
        println(String.format("%-2d %s %s %s", idx, date, time, priority))
        description.forEach() { println(String.format("%-2s %s", "", it)) }
    }
}