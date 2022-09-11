package tasklist

fun main() {
    val todo = ToDoList()

    print("Input the tasks (enter a blank line to end):")
    while (true) {
        val input = readLine()!!.trim()
        if (input.isEmpty()) {
            break
        }
        todo.add(input)
    }

    todo.printAll()
}

class ToDoList {
    fun printAll() {
        if (items.isEmpty()) {
            println("No tasks have been input")
        } else {
            items.forEachIndexed() { index, item ->
                println(String.format("%-2d %s", index + 1, item))
            }
        }
    }

    fun add(input: String) {
        items.add(input)
    }

    private val items = mutableListOf<String>()
}