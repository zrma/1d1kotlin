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

    // Blank task and print without tasks
    @DynamicTest(order = 2)
    fun tasklistTest06(): CheckResult {
        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")
        if (!co.input("print", "No tasks have been input"))
            return CheckResult(false, "Your output should contain \"No tasks have been input\"")
        if (!co.inputNext("Input an action (add, print, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        if (!co.input("add", "Input a new task (enter a blank line to end):"))
            return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
        if (!co.input("   ", "The task is blank"))
            return CheckResult(false, "Your output should contain \"The task is blank\"")
        if (!co.inputNext("Input an action (add, print, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        if (!co.input("print", "No tasks have been input"))
            return CheckResult(false, "Your output should contain \"No tasks have been input\"")
        if (!co.inputNext("Input an action (add, print, end):"))
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        if (!co.input("end", "Tasklist exiting!"))
            return CheckResult(false, "Your output should contain \"Tasklist exiting!\"")

        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    // Normal execution
    @DynamicTest(order = 3)
    fun tasklistTest07(): CheckResult {
        val inputStrings = listOf(
            "See my dentist on 14/1/22\n\n",
            "Supermarket\nChocolates\nflour\noranges\n\n",
            "Change site\nUse Christmas theme\n\n",
            "Buy book\n\n",
            "Fix printer\n\n",
            "Cinema: get tickets\nCheck movie reviews\n\n",
            "Present for friend birthday\n\n",
            "Check new software\n\n",
            "Pay phone bill\n\n",
            "Fill car tank\n\n",
            "Buy flowers\n\n",
            "Pay water bill\n\n"
        )
        val outputStrings = arrayOf(
            arrayOf("1  See my dentist on 14/1/22"),
            arrayOf("2  Supermarket", "   Chocolates", "   flour", "   oranges"),
            arrayOf("3  Change site", "   Use Christmas theme"),
            arrayOf("4  Buy book"),
            arrayOf("5  Fix printer"),
            arrayOf("6  Cinema: get tickets", "   Check movie reviews"),
            arrayOf("7  Present for friend birthday"),
            arrayOf("8  Check new software"),
            arrayOf("9  Pay phone bill"),
            arrayOf("10 Fill car tank"),
            arrayOf("11 Buy flowers"),
            arrayOf("12 Pay water bill")
        )

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        for (s in inputStrings) {
            if (!co.input("add", "Input a new task (enter a blank line to end):"))
                return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
            if (!co.input(s, "Input an action (add, print, end):"))
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

    // Input lines are trimmed
    @DynamicTest(order = 4)
    fun tasklistTest08(): CheckResult {
        val inputStrings = listOf("     Fix printer  \n\n",
            "\tCinema: get tickets\n\tCheck movie reviews\n\n",
            "      Present for friend birthday\n\n",
            "  \t  Check new software\n\n"
        )
        val outputStrings = arrayOf(arrayOf("1  Fix printer"),
            arrayOf("2  Cinema: get tickets", "   Check movie reviews"),
            arrayOf("3  Present for friend birthday"),
            arrayOf("4  Check new software")
        )

        val co = CheckOutput()
        if ( !co.start("Input an action (add, print, end):") )
            return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")

        for (s in inputStrings) {
            if (!co.input("add", "Input a new task (enter a blank line to end):"))
                return CheckResult(false, "Your output should contain \"Input a new task (enter a blank line to end):\"")
            if (!co.input(s, "Input an action (add, print, end):"))
                return CheckResult(false, "Your output should contain \"Input an action (add, print, end):\"")
        }

        co.getNextOutput("print")
        for (s in outputStrings) {
            if (!co.inputNext(*s)) {
                val str = StringBuilder()
                s.forEach { str.appendLine(it) }
                return CheckResult(false, "The input lines should be trimmed; your output should contain  \"${str.toString()}\"")
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


