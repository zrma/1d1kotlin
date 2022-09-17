fun main() {
    val argument = readLine()!!
    println(check(argument)?.length ?: 0)
}

// do not change function below

fun check(name: String): String? {
    return if (name.length > 5) null else name
}