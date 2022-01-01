class Task(val name: String)

// create the Manager singleton here
object Manager {
    var solvedTask: Int = 0
    fun solveTask(task: Task) {
        println("Task ${task.name} solved!")
        solvedTask++
    }
}
