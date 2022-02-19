fun main() {
    val name = readLine()!!
    if (name == "HIDDEN") {
        greeting()
    } else {
        greeting(name)
    }
}

fun greeting(name: String = "secret user") {
    println("Hello, $name!")
}
