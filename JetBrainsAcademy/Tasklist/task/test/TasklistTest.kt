import kotlinx.datetime.*
import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram

class TasklistTest : StageTest<Any>() {

    // Wrong task input
    @DynamicTest(order = 1)
    fun tasklistTest14(): CheckResult {
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
    fun tasklistTest15(): CheckResult {
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
    fun tasklistTest16(): CheckResult {
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
    fun tasklistTest17(): CheckResult {
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
    fun tasklistTest18(): CheckResult {
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
    fun tasklistTest19(): CheckResult {
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
    fun tasklistTest20(): CheckResult {
        val now = Clock.System.now()
        val currentDate = now.toLocalDateTime(TimeZone.of("UTC+2")).date
        val sameDay = currentDate.toString()
        val daysAfter = currentDate.plus(7, DateTimeUnit.DAY).toString()
        val daysBefore = currentDate.minus(7, DateTimeUnit.DAY).toString()

        val inputStrings = arrayListOf(
            arrayOf("H", sameDay, "17:00", "See my dentist\n\n"),
            arrayOf("N", daysAfter, "17:00", "Cinema: get tickets\nCheck movie reviews\n\n"),
            arrayOf("n", daysBefore, "19:00", "Supermarket\nChocolates\nflour\noranges\n\n",),
            arrayOf("l", daysAfter, "12:00", "Buy book\n\n"),
            arrayOf("N", sameDay, "12:00", "Check new software\n\n"),
            arrayOf("C", daysBefore, "16:00", "Fill car tank\n\n"),
            arrayOf("c", daysAfter, "18:15", "Pay phone bill\n\n"),
            arrayOf("l", daysAfter, "18:15", "Pay water bill\n\n"),
            arrayOf("L", daysBefore, "08:05", "Buy flowers\n\n"),
            arrayOf("C", sameDay, "12:00", "Fix printer\n\n"),
            arrayOf("h", daysBefore, "12:00", "Change site\nUse Christmas theme\n\n"),
            arrayOf("l", daysAfter, "12:00", "Present for friend birthday\n\n")
        )

        val outputStrings = arrayListOf(
            arrayOf("1  $sameDay 17:00 H T", "   See my dentist"),
            arrayOf("2  $daysAfter 17:00 N I", "   Cinema: get tickets", "   Check movie reviews"),
            arrayOf("3  $daysBefore 19:00 N O", "   Supermarket", "   Chocolates", "   flour", "   oranges"),
            arrayOf("4  $daysAfter 12:00 L I", "   Buy book"),
            arrayOf("5  $sameDay 12:00 N T", "   Check new software"),
            arrayOf("6  $daysBefore 16:00 C O", "   Fill car tank"),
            arrayOf("7  $daysAfter 18:15 C I", "   Pay phone bill"),
            arrayOf("8  $daysAfter 18:15 L I", "   Pay water bill"),
            arrayOf("9  $daysBefore 08:05 L O", "   Buy flowers"),
            arrayOf("10 $sameDay 12:00 C T", "   Fix printer"),
            arrayOf("11 $daysBefore 12:00 H O", "   Change site", "   Use Christmas theme"),
            arrayOf("12 $daysAfter 12:00 L I", "   Present for friend birthday")
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
        for (s in outputStrings) {
            if (!co.inputNext(*s)) {
                val str = StringBuilder()
                s.forEach { str.appendLine(it) }
                return CheckResult(false, "Your output should contain \"${str.toString()}\"")
            }
            if (!co.inputNext("\n\n"))
                return CheckResult(false, "Each task printout should be followed by a blank line")
        }

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Tasks deletion
    @DynamicTest(order = 8)
    fun tasklistTest21(): CheckResult {
        val now = Clock.System.now()
        val currentDate = now.toLocalDateTime(TimeZone.of("UTC+2")).date
        val sameDay = currentDate.toString()
        val daysAfter = currentDate.plus(7, DateTimeUnit.DAY).toString()
        val daysBefore = currentDate.minus(7, DateTimeUnit.DAY).toString()

        val inputStrings = arrayListOf(
            arrayOf("H", sameDay, "17:00", "See my dentist\n\n"),
            arrayOf("N", daysAfter, "17:00", "Cinema: get tickets\nCheck movie reviews\n\n"),
            arrayOf("n", daysBefore, "19:00", "Supermarket\nChocolates\nflour\noranges\n\n",),
            arrayOf("l", daysAfter, "12:00", "Buy book\n\n")
        )

        val outputStrings = arrayListOf(
            arrayOf("  $sameDay 17:00 H T", "   See my dentist"),
            arrayOf("  $daysAfter 17:00 N I", "   Cinema: get tickets", "   Check movie reviews"),
            arrayOf("  $daysBefore 19:00 N O", "   Supermarket", "   Chocolates", "   flour", "   oranges"),
            arrayOf("  $daysAfter 12:00 L I", "   Buy book")
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
        for ((index, s) in outputStrings.withIndex()) {
            if (!co.inputNext((index +1).toString(), *s)) {
                val str = StringBuilder()
                s.forEach { str.appendLine(it) }
                return CheckResult(false, "Your output should contain \"${index + 1}${str.toString()}\"")
            }
            if (!co.inputNext("\n\n"))
                return CheckResult(false, "Each task printout should be followed by a blank line")
        }

        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        val delIndex = listOf(1, 2, 2, 1)
        for (a in delIndex) {
            co.getNextOutput("delete")
            for ((index, s) in outputStrings.withIndex()) {
                if (!co.inputNext((index + 1).toString(), *s)) {
                    val str = StringBuilder()
                    s.forEach { str.appendLine(it) }
                    return CheckResult(false, "Your output should contain \"${index + 1}${str.toString()}\"")
                }
                if (!co.inputNext("\n\n"))
                    return CheckResult(false, "Each task printout should be followed by a blank line")
            }
            if (!co.inputNext("Input the task number (1-${outputStrings.size}):"))
                return CheckResult(false, "Your output should contain \"Input the task number (1-${outputStrings.size}):\"")
            if (!co.input(a.toString(), "The task is deleted"))
                return CheckResult(false, "Your output should contain \"The task is deleted\"")
            if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")
            outputStrings.removeAt(a - 1)
        }

        if (!co.input("delete", "No tasks have been input"))
            return CheckResult(false, "Your output should contain \"No tasks have been input\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Deletion, Invalid task number
    @DynamicTest(order = 9)
    fun tasklistTest22(): CheckResult {
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
        if (!co.input("A new a task\n\n", "Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        val delStr = listOf("2", "del", "-1", "0")
        if (!co.input("delete", "1  2000-01-01 00:00 N O", "   A new a task\n"))
            return CheckResult(false, "Your output should contain \"1  2000-01-01 00:00 N O\n   A new a task\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")
        for (s in delStr) {
            if (!co.input(s, "Invalid task number", "Input the task number (1-1):"))
                return CheckResult(false, "Your output should contain \"Invalid task number\nInput the task number (1-1):\"")
        }
        if (!co.input("1", "The task is deleted", "Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"The task is deleted\nInput an action (add, print, edit, delete, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")
        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Edit task, Invalid task number
    @DynamicTest(order = 10)
    fun tasklistTest23(): CheckResult {
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

        val delStr = listOf("2", "del", "-1", "0")
        if (!co.input("edit", "1  2000-01-01 00:00 N O", "   My task\n"))
            return CheckResult(false, "Your output should contain \"1  2022-01-01 00:00 N O\n   My task\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")

        for (s in delStr) {
            if (!co.input(s, "Invalid task number", "Input the task number (1-1):"))
                return CheckResult(false, "Your output should contain \"Invalid task number\nInput the task number (1-1):\"")
        }
        if (!co.input("1", "Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")
        if (!co.input("priority", "Input the task priority (C, H, N, L):"))
            return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
        if (!co.input("H", "The task is changed"))
            return CheckResult(false, "Your output should contain \"The task is changed\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("edit", "1  2000-01-01 00:00 H O", "   My task\n"))
            return CheckResult(false, "Your output should contain \"1  2000-01-01 00:00 H O\n   My task\"")
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

        if (!co.input("edit", "1  2001-02-02 00:00 H O", "   My task\n"))
            return CheckResult(false, "Your output should contain \"1  2001-02-02 00:00 H O\n   My task\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")
        if (!co.input("1", "Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")
        if (!co.input("time", "Input the time (hh:mm):"))
            return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
        if (!co.input("12:34", "The task is changed"))
            return CheckResult(false, "Your output should contain \"The task is changed\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("edit", "1  2001-02-02 12:34 H O", "   My task\n"))
            return CheckResult(false, "Your output should contain \"1  2001-02-02 12:34 H O\n   My task\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")
        if (!co.input("1", "Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")
        if (!co.input("task", "Input a new task (enter a blank line to end):"))
            return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
        if (!co.input("My new task\n\n", "The task is changed"))
            return CheckResult(false, "Your output should contain \"The task is changed\"")
        if (!co.inputNext("Input an action (add, print, edit, delete, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, edit, delete, end):\"")

        if (!co.input("edit", "1  2001-02-02 12:34 H O", "   My new task\n"))
            return CheckResult(false, "Your output should contain \"1  2001-02-02 12:34 H O\"\n   My task\"")
        if (!co.inputNext("Input the task number (1-1):"))
            return CheckResult(false, "Your output should contain \"Input the task number (1-1):\"")
        if (!co.input("1", "Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")
        if (!co.input("my field", "Invalid field"))
            return CheckResult(false, "Your output should contain \"Invalid field\"")
        if (!co.inputNext("Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")
        if (!co.input("tags", "Invalid field"))
            return CheckResult(false, "Your output should contain \"Invalid field\"")
        if (!co.inputNext("Input a field to edit (priority, date, time, task):"))
            return CheckResult(false, "Your output should contain \"Input a field to edit (priority, date, time, task):\"")
        if (!co.input("time", "Input the time (hh:mm):"))
            return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
        if (!co.input("3:21", "The task is changed"))
            return CheckResult(false, "Your output should contain \"The task is changed\"")
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


