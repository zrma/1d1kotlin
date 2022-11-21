import com.google.gson.JsonElement
import kotlinx.datetime.*
import org.hyperskill.hstest.common.JsonUtils
import org.hyperskill.hstest.common.JsonUtils.getJson
import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram
import org.hyperskill.hstest.testing.expect.Expectation.expect
import org.hyperskill.hstest.testing.expect.json.JsonChecker.*
import java.io.File

class TasklistTest : StageTest<Any>() {
    // Wrong task input
    @DynamicTest(order = 1)
    fun tasklistTest28(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val inputStrings = listOf("input", "task", "",  "123", " ")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")
        for (s in inputStrings) {
            if (!co.input(s, "The input action is invalid"))
                return CheckResult(false, "Your output should contain \"The input action is invalid\"")
            if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")
        }

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Wrong priority is input
    @DynamicTest(order = 2)
    fun tasklistTest29(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val inputStrings = listOf("normal", "Critical", "low",  "high", " ")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("add", "Input the task priority (C, H, N, L):"))
            return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")

        for (s in inputStrings) {
            if (!co.input(s, "Input the task priority (C, H, N, L):"))
                return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
        }

        if (!co.input("N", "Input the date (yyyy-mm-dd):"))
            return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
        if (!co.input("2022-1-1", "Input the time (hh:mm):"))
            return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
        if (!co.input("0:0", "Input a new task (enter a blank line to end):"))
            return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
        if (!co.input("Happy new year!\n\n", "Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Wrong date is input
    @DynamicTest(order = 3)
    fun tasklistTest30(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val inputStrings = listOf("2021-2-29", "2021-13-1", "2021-12-32",  "thisDay", " ")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("add", "Input the task priority (C, H, N, L):"))
            return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
        if (!co.input("N", "Input the date (yyyy-mm-dd):"))
            return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")

        for (s in inputStrings) {
            if (!co.input(s, "The input date is invalid"))
                return CheckResult(false, "Your output should contain \"The input date is invalid\"")
            if (!co.inputNext("Input the date (yyyy-mm-dd):"))
                return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
        }

        if (!co.input("2022-1-1", "Input the time (hh:mm):"))
            return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
        if (!co.input("0:0", "Input a new task (enter a blank line to end):"))
            return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
        if (!co.input("Happy new year!\n\n", "Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Wrong time is input
    @DynamicTest(order = 4)
    fun tasklistTest31(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val inputStrings = listOf("24:00", "12:60", "12.12",  "thisTime", " ")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("add", "Input the task priority (C, H, N, L):"))
            return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
        if (!co.input("N", "Input the date (yyyy-mm-dd):"))
            return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
        if (!co.input("2022-1-1", "Input the time (hh:mm):"))
            return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")

        for (s in inputStrings) {
            if (!co.input(s, "The input time is invalid"))
                return CheckResult(false, "Your output should contain \"The input time is invalid\"")
            if (!co.inputNext("Input the time (hh:mm):"))
                return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
        }

        if (!co.input("0:0", "Input a new task (enter a blank line to end):"))
            return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
        if (!co.input("Happy new year!\n\n", "Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Blank task is input
    @DynamicTest(order = 5)
    fun tasklistTest32(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("add", "Input the task priority (C, H, N, L):"))
            return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
        if (!co.input("N", "Input the date (yyyy-mm-dd):"))
            return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
        if (!co.input("2022-1-1", "Input the time (hh:mm):"))
            return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
        if (!co.input("0:0", "Input a new task (enter a blank line to end):"))
            return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
        if (!co.input("     ", "The task is blank"))
            return CheckResult(false, "Your output should contain \"The task is blank\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // No tasks have been input
    @DynamicTest(order = 6)
    fun tasklistTest33(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val inputStrings = listOf("print", "edit", "delete")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        for (s in inputStrings) {
            if (!co.input(s, "No tasks have been input"))
                return CheckResult(false, "Your output should contain \"No tasks have been input\"")
            if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\""
                )
        }

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Normal task addition
    @DynamicTest(order = 7)
    fun tasklistTest34(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val now = Clock.System.now()
        val currentDate = now.toLocalDateTime(TimeZone.of("UTC+2")).date
        val sameDay = currentDate.toString()
        val daysAfter = currentDate.plus(7, DateTimeUnit.DAY).toString()
        val daysBefore = currentDate.minus(7, DateTimeUnit.DAY).toString()

        val inputStrings = arrayListOf(
            arrayOf("C", sameDay, "17:00", "See my dentist\n\n"),
            arrayOf("h", daysAfter, "17:00", "Cinema: get tickets\nCheck movie reviews\n\n"),
            arrayOf("n", daysBefore, "19:00", "Supermarket\nChocolates\nflour\noranges\n\n",),
            arrayOf("l", daysAfter, "12:00", "Buy book\n\n")
        )

        val outputStrings = arrayListOf(
            arrayOf("| 1  | $sameDay | 17:00 | \u001B[101m \u001B[0m | \u001B[103m \u001B[0m |See my dentist                              |"),
            arrayOf("| 2  | $daysAfter | 17:00 | \u001B[103m \u001B[0m | \u001B[102m \u001B[0m |Cinema: get tickets                         |",
                "|    |            |       |   |   |Check movie reviews                         |"),
            arrayOf("| 3  | $daysBefore | 19:00 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |Supermarket                                 |",
                "|    |            |       |   |   |Chocolates                                  |",
                "|    |            |       |   |   |flour                                       |",
                "|    |            |       |   |   |oranges                                     |"),
            arrayOf("| 4  | $daysAfter | 12:00 | \u001B[104m \u001B[0m | \u001B[102m \u001B[0m |Buy book                                    |")
        )

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        for (taskInput in inputStrings) {
            if (!co.input("add", "Input the task priority (C, H, N, L):"))
                return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
            if (!co.input(taskInput[0], "Input the date (yyyy-mm-dd):"))
                return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
            if (!co.input(taskInput[1], "Input the time (hh:mm):"))
                return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
            if (!co.input(taskInput[2], "Input a new task (enter a blank line to end):"))
                return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
            if (!co.input(taskInput[3], "Input an action (add, print, edit, delete, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")
        }

        co.getNextOutput("print")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        for (s in outputStrings) {
            if (!co.inputNext(*s)) {
                val str = StringBuilder()
                s.forEach { str.appendLine(it) }
                return CheckResult(false, "Your output should contain \"${str.toString()}\"")
            }
            if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
                return CheckResult(false, "Wrong dividing line." +
                        "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")
        }
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Tasks deletion
    @DynamicTest(order = 8)
    fun tasklistTest35(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val now = Clock.System.now()
        val currentDate = now.toLocalDateTime(TimeZone.of("UTC+2")).date
        val sameDay = currentDate.toString()
        val daysAfter = currentDate.plus(7, DateTimeUnit.DAY).toString()
        val daysBefore = currentDate.minus(7, DateTimeUnit.DAY).toString()

        val inputStrings = arrayListOf(
            arrayOf("N", daysAfter, "17:00", "Cinema: get tickets\n\n"),
            arrayOf("l", daysBefore, "12:00", "Buy book\n\n")
        )

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        for (taskInput in inputStrings) {
            if (!co.input("add", "Input the task priority (C, H, N, L):"))
                return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
            if (!co.input(taskInput[0], "Input the date (yyyy-mm-dd):"))
                return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
            if (!co.input(taskInput[1], "Input the time (hh:mm):"))
                return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
            if (!co.input(taskInput[2], "Input a new task (enter a blank line to end):"))
                return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
            if (!co.input(taskInput[3], "Input an action (add, print, edit, delete, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")
        }

        co.getNextOutput("delete")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        if (!co.inputNext("| 1  | $daysAfter | 17:00 | \u001B[102m \u001B[0m | \u001B[102m \u001B[0m |Cinema: get tickets                         |"))
            return CheckResult(false, "Your output should contain" +
                    " \"| 1  | $daysAfter | 17:00 | \u001B[102m \u001B[0m | \u001B[102m \u001B[0m |Cinema: get tickets                         |\"")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Wrong dividing line." +
                    "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")
        if (!co.inputNext("| 2  | $daysBefore | 12:00 | \u001B[104m \u001B[0m | \u001B[101m \u001B[0m |Buy book                                    |"))
            return CheckResult(false, "Your output should contain" +
                    " \"| 2  | $daysBefore | 12:00 | \u001B[104m \u001B[0m | \u001B[101m \u001B[0m |Buy book                                    |\"")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Wrong dividing line." +
                    "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")

        if (!co.inputNext("Input the task number (1-2):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-2):\"")

        if (!co.input("1", "The task is deleted"))
            return CheckResult(false, "Your output should contain \"The task is deleted\"")

        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        co.getNextOutput("delete")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        if (!co.inputNext("| 1  | $daysBefore | 12:00 | \u001B[104m \u001B[0m | \u001B[101m \u001B[0m |Buy book                                    |"))
            return CheckResult(false, "Your output should contain" +
                    " \"| 2  | $daysBefore | 12:00 | \u001B[104m \u001B[0m | \u001B[101m \u001B[0m |Buy book                                    |\"")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Wrong dividing line." +
                    "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")

        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-2):\"")

        if (!co.input("1", "The task is deleted"))
            return CheckResult(false, "Your output should contain \"The task is deleted\"")

        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("delete", "No tasks have been input"))
            return CheckResult(false, "Your output should contain \"No tasks have been input\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("print", "No tasks have been input"))
            return CheckResult(false, "Your output should contain \"No tasks have been input\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Task editing
    @DynamicTest(order = 9)
    fun tasklistTest36(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("add", "Input the task priority (C, H, N, L):"))
            return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
        if (!co.input("N", "Input the date (yyyy-mm-dd):"))
            return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
        if (!co.input("2000-1-1", "Input the time (hh:mm):"))
            return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
        if (!co.input("0:0", "Input a new task (enter a blank line to end):"))
            return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
        if (!co.input("My task\n\n", "Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        co.getNextOutput("edit")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        if (!co.inputNext("| 1  | 2000-01-01 | 00:00 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |My task                                     |"))
            return CheckResult(false, "Your output should contain" +
                    " \"| 1  | 2000-01-01 | 00:00 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |My task                                     |\"")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Wrong dividing line." +
                    "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")
        if (!co.input("1", "Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")

        if (!co.input("priority", "Input the task priority (C, H, N, L):"))
            return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
        if (!co.input("H", "The task is changed"))
            return CheckResult(false, "Your output should contain \"The task is changed\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        co.getNextOutput("edit")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        if (!co.inputNext("| 1  | 2000-01-01 | 00:00 | \u001B[103m \u001B[0m | \u001B[101m \u001B[0m |My task                                     |"))
            return CheckResult(false, "Your output should contain" +
                    " \"| 1  | 2000-01-01 | 00:00 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |My task                                     |\"")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Wrong dividing line." +
                    "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")
        if (!co.input("1", "Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")


        if (!co.input("date", "Input the date (yyyy-mm-dd):"))
            return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
        if (!co.input("2001-2-2", "The task is changed"))
            return CheckResult(false, "Your output should contain \"The task is changed\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        co.getNextOutput("edit")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        if (!co.inputNext("| 1  | 2001-02-02 | 00:00 | \u001B[103m \u001B[0m | \u001B[101m \u001B[0m |My task                                     |"))
            return CheckResult(false, "Your output should contain" +
                    " \"| 1  | 2001-02-02 | 00:00 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |My task                                     |\"")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Wrong dividing line." +
                    "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")
        if (!co.input("1", "Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")

        if (!co.input("time", "Input the time (hh:mm):"))
            return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
        if (!co.input("12:34", "The task is changed"))
            return CheckResult(false, "Your output should contain \"The task is changed\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        co.getNextOutput("edit")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        if (!co.inputNext("| 1  | 2001-02-02 | 12:34 | \u001B[103m \u001B[0m | \u001B[101m \u001B[0m |My task                                     |"))
            return CheckResult(false, "Your output should contain" +
                    " \"| 1  | 2001-02-02 | 12:34 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |My task                                     |\"")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Wrong dividing line." +
                    "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")
        if (!co.input("1", "Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"The task is deleted\nInput a field to edit (priority, date, time, task):\"")

        if (!co.input("task", "Input a new task (enter a blank line to end):"))
            return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
        if (!co.input("My new task\n\n", "The task is changed"))
            return CheckResult(false, "Your output should contain \"The task is changed\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        co.getNextOutput("print")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        if (!co.inputNext("| 1  | 2001-02-02 | 12:34 | \u001B[103m \u001B[0m | \u001B[101m \u001B[0m |My new task                                 |"))
            return CheckResult(false, "Your output should contain" +
                    " \"| 1  | 2001-02-02 | 12:34 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |My new task                                 |\"")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Wrong dividing line." +
                    "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")

        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")
        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Check JSON file saving
    @DynamicTest(order = 10)
    fun tasklistTest37(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (jsonFile.exists()) jsonFile.delete()
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to delete a JSON file.")
        }

        val now = Clock.System.now()
        val currentDate = now.toLocalDateTime(TimeZone.of("UTC+2")).date
        val sameDay = currentDate.toString()
        val daysAfter = currentDate.plus(7, DateTimeUnit.DAY).toString()
        val daysBefore = currentDate.minus(7, DateTimeUnit.DAY).toString()

        val inputStrings = arrayListOf(
            arrayOf("C", sameDay, "17:00", "See my dentist\n\n"),
            arrayOf("h", daysAfter, "17:00", "Cinema: get tickets\nCheck movie reviews\n\n"),
            arrayOf("n", daysBefore, "19:00", "Supermarket\nChocolates\nflour\noranges\n\n",),
            arrayOf("l", daysAfter, "12:00", "Buy book\n\n")
        )

        val outputStrings = arrayListOf(
            arrayOf("| 1  | $sameDay | 17:00 | \u001B[101m \u001B[0m | \u001B[103m \u001B[0m |See my dentist                              |"),
            arrayOf("| 2  | $daysAfter | 17:00 | \u001B[103m \u001B[0m | \u001B[102m \u001B[0m |Cinema: get tickets                         |",
                "|    |            |       |   |   |Check movie reviews                         |"),
            arrayOf("| 3  | $daysBefore | 19:00 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |Supermarket                                 |",
                "|    |            |       |   |   |Chocolates                                  |",
                "|    |            |       |   |   |flour                                       |",
                "|    |            |       |   |   |oranges                                     |"),
            arrayOf("| 4  | $daysAfter | 12:00 | \u001B[104m \u001B[0m | \u001B[102m \u001B[0m |Buy book                                    |")
        )

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        for (taskInput in inputStrings) {
            if (!co.input("add", "Input the task priority (C, H, N, L):"))
                return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
            if (!co.input(taskInput[0], "Input the date (yyyy-mm-dd):"))
                return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
            if (!co.input(taskInput[1], "Input the time (hh:mm):"))
                return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
            if (!co.input(taskInput[2], "Input a new task (enter a blank line to end):"))
                return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
            if (!co.input(taskInput[3], "Input an action (add, print, edit, delete, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")
        }

        co.getNextOutput("print")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        for (s in outputStrings) {
            if (!co.inputNext(*s)) {
                val str = StringBuilder()
                s.forEach { str.appendLine(it) }
                return CheckResult(false, "Your output should contain \"${str.toString()}\"")
            }
            if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
                return CheckResult(false, "Wrong dividing line." +
                        "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")
        }
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")

        try {
            val jsonFile = File("tasklist.json")
            if (!jsonFile.exists())
                return CheckResult(false, "The file tasklist.json hasn't been created, after the end action.")
            val jsonText = jsonFile.readText()
            if (jsonText.isBlank())
                return CheckResult(false, "The file tasklist.json is blank.")
            val t = JsonUtils.getType(getJson(jsonText))
            if (t != "array")
                return CheckResult(false, "Wrong JSON format. JSON string is not an array.")
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to check if a file exists.")
        }

        return CheckResult.correct()
    }

    // Check JSON file loading
    @DynamicTest(order = 11)
    fun tasklistTest38(): CheckResult {
        try {
            val jsonFile = File("tasklist.json")
            if (!jsonFile.exists())
                return CheckResult(false, "The file tasklist.json doesn't exist.")
            val jsonText = jsonFile.readText()
            if (jsonText.isBlank())
                return CheckResult(false, "The file tasklist.json is blank.")
            val t = JsonUtils.getType(getJson(jsonText))
            if (t != "array")
                return CheckResult(false, "Wrong JSON format. JSON string is not an array.")
        } catch (e: Exception) {
            return CheckResult(false, "An exception was thrown, while trying to check if a file exists.")
        }

        val now = Clock.System.now()
        val currentDate = now.toLocalDateTime(TimeZone.of("UTC+2")).date
        val sameDay = currentDate.toString()
        val daysAfter = currentDate.plus(7, DateTimeUnit.DAY).toString()
        val daysBefore = currentDate.minus(7, DateTimeUnit.DAY).toString()

        val outputStrings = arrayListOf(
            arrayOf("| 1  | $sameDay | 17:00 | \u001B[101m \u001B[0m | \u001B[103m \u001B[0m |See my dentist                              |"),
            arrayOf("| 2  | $daysAfter | 17:00 | \u001B[103m \u001B[0m | \u001B[102m \u001B[0m |Cinema: get tickets                         |",
                "|    |            |       |   |   |Check movie reviews                         |"),
            arrayOf("| 3  | $daysBefore | 19:00 | \u001B[102m \u001B[0m | \u001B[101m \u001B[0m |Supermarket                                 |",
                "|    |            |       |   |   |Chocolates                                  |",
                "|    |            |       |   |   |flour                                       |",
                "|    |            |       |   |   |oranges                                     |"),
            arrayOf("| 4  | $daysAfter | 12:00 | \u001B[104m \u001B[0m | \u001B[102m \u001B[0m |Buy book                                    |")
        )

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, edit, delete, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        co.getNextOutput("print")
        if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+",
                "| N  |    Date    | Time  | P | D |                   Task                     |",
                "+----+------------+-------+---+---+--------------------------------------------+"))
            return CheckResult(false, "Your output header isn't correct\"")
        for (s in outputStrings) {
            if (!co.inputNext(*s)) {
                val str = StringBuilder()
                s.forEach { str.appendLine(it) }
                return CheckResult(false, "Your output should contain \"${str.toString()}\"")
            }
            if (!co.inputNext("+----+------------+-------+---+---+--------------------------------------------+"))
                return CheckResult(false, "Wrong dividing line." +
                        "Your output should contain \"+----+------------+-------+---+---+--------------------------------------------+\"")
        }
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")

        return CheckResult.correct()
    }
}

class CheckOutput {
    private var main: TestedProgram = TestedProgram()
    var position = 0
    private var caseInsensitive = true
    private var trimOutput = true
    private val arguments= mutableListOf<String>()
    private var isStarted = false
    private var lastOutput = ""

    private fun checkOutput(outputString: String, vararg checkStr: String): Boolean {
        var searchPosition = position
        for (cStr in checkStr) {
            val str = if (caseInsensitive) cStr.lowercase() else cStr
            val findPosition = outputString.indexOf(str, searchPosition)
            if (findPosition == -1) return false
            if ( outputString.substring(searchPosition until findPosition).isNotBlank() ) return false
            searchPosition = findPosition + str.length
        }
        position = searchPosition
        return true
    }

    fun start(vararg checkStr: String): Boolean {
        return if (!isStarted) {
            var outputString = main.start(*arguments.toTypedArray())
            lastOutput = outputString
            if (trimOutput) outputString = outputString.trim()
            if (caseInsensitive) outputString = outputString.lowercase()
            isStarted = true
            checkOutput(outputString, *checkStr)
        } else false
    }

    fun stop() {
        main.stop()
    }

    fun input(input: String, vararg checkStr: String): Boolean {
        if (main.isFinished) return false
        var outputString = main.execute(input)
        lastOutput = outputString
        if (trimOutput) outputString = outputString.trim()
        if (caseInsensitive) outputString = outputString.lowercase()
        position = 0
        return checkOutput(outputString, *checkStr)
    }

    fun inputNext(vararg checkStr: String): Boolean {
        var outputString = lastOutput
        if (trimOutput) outputString = outputString.trim()
        if (caseInsensitive) outputString = outputString.lowercase()
        return checkOutput(outputString, *checkStr)
    }

    fun getNextOutput(input: String): String {
        if (main.isFinished) return ""
        val outputString = main.execute(input)
        lastOutput = outputString
        position = 0
        return  outputString
    }

    fun getLastOutput(): String { return lastOutput }
    fun programIsFinished(): Boolean  = main.isFinished
    fun setArguments(vararg args: String) { arguments.addAll(args.toMutableList()) }
    fun setCaseSensitivity(caseInsensitive: Boolean) { this.caseInsensitive = caseInsensitive }
    fun setOutputTrim(trimOutput: Boolean) { this.trimOutput = trimOutput}
}


