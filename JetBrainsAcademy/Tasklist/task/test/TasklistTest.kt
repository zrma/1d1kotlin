import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram

class TasklistTest : StageTest<Any>() {

    // Wrong task input
    @DynamicTest(order = 1)
    fun tasklistTest05(): CheckResult {
        val inputStrings = listOf("input", "task", "",  "123", " ")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")
        for (s in inputStrings) {
            if (!co.input(s, "The input action is invalid"))
                return CheckResult(false, "Your output should contain \"The input action is invalid\"")
            if (!co.inputNext("Input an action (add, print, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")
        }

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Wrong priority is input
    @DynamicTest(order = 2)
    fun tasklistTest09(): CheckResult {
        val inputStrings = listOf("normal", "Critical", "low",  "high", " ")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

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
        if (!co.input("Happy new year!\n\n", "Input an action (add, print, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Wrong date is input
    @DynamicTest(order = 3)
    fun tasklistTest10(): CheckResult {
        val inputStrings = listOf("2021-2-29", "2021-13-1", "2021-12-32",  "thisDay", " ")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

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
        if (!co.input("Happy new year!\n\n", "Input an action (add, print, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Wrong time is input
    @DynamicTest(order = 4)
    fun tasklistTest11(): CheckResult {
        val inputStrings = listOf("24:00", "12:60", "12.12",  "thisTime", " ")
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

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
        if (!co.input("Happy new year!\n\n", "Input an action (add, print, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Blank task is input
    @DynamicTest(order = 5)
    fun tasklistTest12(): CheckResult {
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

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
        if (!co.inputNext("Input an action (add, print, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Normal execution
    @DynamicTest(order = 6)
    fun tasklistTest13(): CheckResult {
        val inputStrings = arrayListOf(
            arrayOf("H", "2022-1-14", "17:00", "See my dentist on 14/1/22\n\n"),
            arrayOf("N", "2022-12-20", "17:00", "Cinema: get tickets\nCheck movie reviews\n\n"),
            arrayOf("n", "2021-12-13", "19:00", "Supermarket\nChocolates\nflour\noranges\n\n",),
            arrayOf("l", "2022-01-20", "12:00", "Buy book\n\n"),
            arrayOf("N", "2022-01-08", "12:00", "Check new software\n\n"),
            arrayOf("C", "2021-1-20", "16:00", "Fill car tank\n\n"),
            arrayOf("c", "2022-1-22", "18:15", "Pay phone bill\n\n"),
            arrayOf("l", "2022-1-22", "18:15", "Pay water bill\n\n"),
            arrayOf("L", "2022-1-22", "08:05", "Buy flowers\n\n"),
            arrayOf("C", "2021-12-19", "12:00", "Fix printer\n\n"),
            arrayOf("h", "2021-12-1", "12:00", "Change site\nUse Christmas theme\n\n"),
            arrayOf("l", "2022-2-22", "12:00", "Present for friend birthday\n\n")
        )

        val outputStrings = arrayListOf(
            arrayOf("1  2022-01-14 17:00 H", "   See my dentist on 14/1/22"),
            arrayOf("2  2022-12-20 17:00 N", "   Cinema: get tickets", "   Check movie reviews"),
            arrayOf("3  2021-12-13 19:00 N", "   Supermarket", "   Chocolates", "   flour", "   oranges"),
            arrayOf("4  2022-01-20 12:00 L", "   Buy book"),
            arrayOf("5  2022-01-08 12:00 N", "   Check new software"),
            arrayOf("6  2021-01-20 16:00 C", "   Fill car tank"),
            arrayOf("7  2022-01-22 18:15 C", "   Pay phone bill"),
            arrayOf("8  2022-01-22 18:15 L", "   Pay water bill"),
            arrayOf("9  2022-01-22 08:05 L", "   Buy flowers"),
            arrayOf("10 2021-12-19 12:00 C", "   Fix printer"),
            arrayOf("11 2021-12-01 12:00 H", "   Change site", "   Use Christmas theme"),
            arrayOf("12 2022-02-22 12:00 L", "   Present for friend birthday")
        )

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        for (taskInput in inputStrings) {
            if (!co.input("add", "Input the task priority (C, H, N, L):"))
                return CheckResult(false, "Your output should contain \"Input the task priority (C, H, N, L):\"")
            if (!co.input(taskInput[0], "Input the date (yyyy-mm-dd):"))
                return CheckResult(false, "Your output should contain \"Input the date (yyyy-mm-dd):\"")
            if (!co.input(taskInput[1], "Input the time (hh:mm):"))
                return CheckResult(false, "Your output should contain \"Input the time (hh:mm):\"")
            if (!co.input(taskInput[2], "Input a new task (enter a blank line to end):"))
                return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
            if (!co.input(taskInput[3], "Input an action (add, print, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")
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


