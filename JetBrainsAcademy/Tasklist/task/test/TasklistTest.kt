import org.hyperskill.hstest.dynamic.DynamicTest
import org.hyperskill.hstest.stage.StageTest
import org.hyperskill.hstest.testcase.CheckResult
import org.hyperskill.hstest.testing.TestedProgram

class TasklistTest : StageTest<Any>() {

    @DynamicTest(order = 1)
    fun tasklistTest01(): CheckResult {
        val co = CheckOutput()
        if ( !co.start("Input the tasks (enter a blank line to end):") )
            return CheckResult(false, "Your output should contain \"Input the tasks (enter a blank line to end):\"")

        val inputTasks = """
            Task #1
            task 2 
            task &3
            Task   4
            task  5
            
            
        """.trimIndent()
        val outputTasksArray = """
            1  Task #1
            2  task 2
            3  task &3
            4  Task   4
            5  task  5
        """.trimIndent().lines().toTypedArray()
        if (!co.input(inputTasks, *outputTasksArray))
            return CheckResult(false, "Your output should contain the sequenced task list")
        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    @DynamicTest(order = 2)
    fun tasklistTest02(): CheckResult {
        val co = CheckOutput()
        if ( !co.start("Input the tasks (enter a blank line to end):") )
            return CheckResult(false, "Your output should contain \"Input the tasks (enter a blank line to end):\"")

        val inputTasks = """
            Change colors at site
            Dentist on 15/1
            Present for friend birthday
            Supermarket. Milk, eggs, butter.
            Fix the printer.
            Cinema: get tickets
            Buy book
            Check new software
            Finish hyperskill project
            Pay phone bill
            Pay water bill
            
            
        """.trimIndent()
        val outputTasksArray = """
            1  Change colors at site
            2  Dentist on 15/1
            3  Present for friend birthday
            4  Supermarket. Milk, eggs, butter.
            5  Fix the printer.
            6  Cinema: get tickets
            7  Buy book
            8  Check new software
            9  Finish hyperskill project
            10 Pay phone bill
            11 Pay water bill
        """.trimIndent().lines().toTypedArray()
        if (!co.input(inputTasks, *outputTasksArray))
            return CheckResult(false, "Your output should contain the sequenced task list")
        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    @DynamicTest(order = 3)
    fun tasklistTest03(): CheckResult {
        val co = CheckOutput()
        if ( !co.start("Input the tasks (enter a blank line to end):") )
            return CheckResult(false, "Your output should contain \"Input the tasks (enter a blank line to end):\"")

        val inputTasks = """
Change colors at site
        Dentist on 15/1
         Present for friend birthday
               Supermarket. Milk, eggs, butter.
               Fix the printer.
                 Cinema: get tickets
            
            
        """.trimIndent()
        val outputTasksArray = """
            1  Change colors at site
            2  Dentist on 15/1
            3  Present for friend birthday
            4  Supermarket. Milk, eggs, butter.
            5  Fix the printer.
            6  Cinema: get tickets
        """.trimIndent().lines().toTypedArray()
        if (!co.input(inputTasks, *outputTasksArray))
            return CheckResult(false, "Your output should contain the sequenced task list; input lines should be trimmed")
        if (!co.programIsFinished() )
            return CheckResult(false, "The application didn't exit.")
        return CheckResult.correct()
    }

    @DynamicTest(order = 4)
    fun tasklistTest04(): CheckResult {
        val co = CheckOutput()
        if ( !co.start("Input the tasks (enter a blank line to end):") )
            return CheckResult(false, "Your output should contain \"Input the tasks (enter a blank line to end):\"")
        if (!co.input("", "No tasks have been input"))
            return CheckResult(false, "Your output should contain  \"No tasks have been input\"")
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


