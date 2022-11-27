package tasklist

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import java.io.File
import java.lang.reflect.ParameterizedType
import java.time.DateTimeException
import java.time.LocalTime
import java.util.*

fun main() {
    val todo = TaskList()

    val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
    val type: ParameterizedType = Types.newParameterizedType(List::class.java, Task::class.java)
    val taskListAdapter: JsonAdapter<List<Task>> = moshi.adapter(type)


    @Suppress("SpellCheckingInspection") val jsonFile = File("tasklist.json")
    if (jsonFile.exists()) {
        taskListAdapter.fromJson(jsonFile.readText())?.let { todo.tasks = it.toMutableList() }
    }

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

        taskListAdapter.toJson(todo.tasks.toList())?.let { jsonFile.writeText(it) }
    }
}

fun initSampleTodo(todo: TaskList) {
    todo.add(
        Task(
            "N", "2022-11-20", "19: 00", listOf("Supermarket", "milk", "cookies", "butter")
        )
    )
    todo.add(
        Task(
            "N", "2022-11-21", "19:0", listOf("Remember to review the code for the TaskList", " project.")
        )
    )
    todo.add(
        Task(
            "N", "2022-11-22", "19: 00", listOf(
                "Find resources about Ansi colors and cursor ",
                "movement.",
                "Don't forget to look into the stage 6 links ",
                "about it."
            )
        )
    )

    todo.printAll()
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

fun readDate(): String {
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
                return LocalDate(it[0].toInt(), it[1].toInt(), it[2].toInt()).toString()
            } catch (e: IllegalArgumentException) {
                println("The input date is invalid")
            } catch (e: DateTimeException) {
                println("The input date is invalid")
            }
        }
    }
}

fun readTime(): String {
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
                return LocalTime.of(it[0].toInt(), it[1].toInt()).toString()
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
        var input = scanner.nextLine().trim()
        if (input.isEmpty()) {
            break
        }

        val limit = 44
        while (input.length > limit) {
            val s = input.take(limit)
            res.add(s)
            input = input.drop(limit)
        }
        if (input.isNotEmpty()) {
            res.add(input)
        }
    }
    return res
}

class TaskList {
    fun printAll(): Boolean {
        if (tasks.isEmpty()) {
            println("No tasks have been input")
            return false
        }

        println("+----+------------+-------+---+---+--------------------------------------------+")
        println("| N  |    Date    | Time  | P | D |                   Task                     |")
        println("+----+------------+-------+---+---+--------------------------------------------+")

        tasks.forEachIndexed() { index, item ->
            item.print(index + 1)
            println("+----+------------+-------+---+---+--------------------------------------------+")
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

    var tasks = mutableListOf<Task>()
}

data class Task(var priority: String, var date: String, var time: String, var description: List<String>) {
    fun print(idx: Int) {
        val date = date.split("-").let {
            LocalDate(it[0].toInt(), it[1].toInt(), it[2].toInt())
        }
        val time = time.split(":").let {
            LocalTime.of(it[0].toInt(), it[1].toInt())
        }
        println(
            String.format(
                "| %-2d | %s | %s | %s | %s |%-44s|",
                idx,
                date,
                time,
                priorityToColor(priority),
                dueToColor(overdue()),
                description[0]
            )
        )
        description.drop(1).forEach {
            println(String.format("|    |            |       |   |   |%-44s|", it))
        }
    }

    private fun overdue(): String {
        val currentDate = Clock.System.now().toLocalDateTime(TimeZone.of("UTC+0")).date
        val numberOfDays = currentDate.daysUntil(date.split("-").let {
            LocalDate(it[0].toInt(), it[1].toInt(), it[2].toInt())
        })
        return when {
            numberOfDays < 0 -> "O"
            numberOfDays == 0 -> "T"
            else -> "I"
        }
    }
}

fun priorityToColor(priority: String): String {
    return when (priority) {
        "C" -> "\u001B[101m \u001B[0m"
        "N" -> "\u001B[102m \u001B[0m"
        "H" -> "\u001B[103m \u001B[0m"
        else -> "\u001B[104m \u001B[0m"
    }
}

fun dueToColor(due: String): String {
    return when (due) {
        "O" -> "\u001B[101m \u001B[0m"
        "I" -> "\u001B[102m \u001B[0m"
        else -> "\u001B[103m \u001B[0m"
    }
}