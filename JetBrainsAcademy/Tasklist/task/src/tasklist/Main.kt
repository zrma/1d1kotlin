package tasklist

import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import java.time.DateTimeException
import java.time.Instant
import java.time.LocalTime
import java.time.ZoneId
import java.util.*

fun main() {
    val todo = TaskList()

    while (true) {
        print("Input an action (add, print, edit, delete, end):")
        when (readLine()!!.trim()) {
            "add" -> {
                val priority = readPriority()
                val date = readDate()
                val time = readTime()

                print("Input a new task (enter a blank line to end):")
                val taskBody = readTaskBody()
                if (taskBody.isEmpty() || taskBody.size == 1 && taskBody[0].isEmpty()) {
                    println("The task is blank")
                    continue
                }
                todo.add(Task(priority, date, time, taskBody))
            }

            "print" -> todo.printAll()

            "edit" -> {
                if (todo.printAll()) {
                    todo.edit()
                }
            }

            "delete" -> {
                if (todo.printAll()) {
                    todo.delete()
                }
            }

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
            } catch (e: DateTimeException) {
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
    fun printAll(): Boolean {
        if (tasks.isEmpty()) {
            println("No tasks have been input")
            return false
        }

        tasks.forEachIndexed() { index, item ->
            item.print(index + 1)
            println()
        }
        return true
    }

    fun add(task: Task) {
        tasks.add(task)
    }

    fun delete() {
        while (true) {
            print("Input the task number (1-${tasks.size}):")
            try {
                val index = readLine()!!.trim().toInt()
                tasks.removeAt(index - 1)
                println("The task is deleted")
                break
            } catch (e: Exception) {
                println("Invalid task number")
                continue
            }
        }
    }

    fun edit() {
        while (true) {
            print("Input the task number (1-${tasks.size}):")
            try {
                val index = readLine()!!.trim().toInt()
                val task = tasks[index - 1]
                editTask(task)
                break
            } catch (e: Exception) {
                println("Invalid task number")
                continue
            }
        }
    }

    private fun editTask(task: Task) {
        while (true) {
            print("Input a field to edit (priority, date, time, task):")
            when (readLine()!!.trim()) {
                "priority" -> {
                    task.priority = readPriority()
                }

                "date" -> {
                    task.date = readDate()
                }

                "time" -> {
                    task.time = readTime()
                }

                "task" -> {
                    println("Input a new task (enter a blank line to end):")
                    val taskBody = readTaskBody()
                    if (taskBody.isEmpty() || taskBody.size == 1 && taskBody[0].isEmpty()) {
                        println("The task is blank")
                        continue
                    }
                    task.description = taskBody
                }

                else -> {
                    println("Invalid field")
                    continue
                }
            }
            println("The task is changed")
            break
        }
    }

    private val tasks = mutableListOf<Task>()
}

data class Task(var priority: String, var date: LocalDate, var time: LocalTime, var description: List<String>) {
    fun print(idx: Int) {
        println(String.format("%-2d %s %s %s %s", idx, date, time, priority, overdue()))
        description.forEach() { println(String.format("%-2s %s", "", it)) }
    }

    private fun overdue(): String {
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+0")).date
        val numberOfDays = currentDate.daysUntil(date)
        return when {
            numberOfDays < 0 -> "O"
            numberOfDays == 0 -> "T"
            else -> "I"
        }
    }
}
