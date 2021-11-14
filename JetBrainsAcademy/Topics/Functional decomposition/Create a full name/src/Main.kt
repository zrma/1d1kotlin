// use this code as a source of inspiration for your function
@Suppress("unused")
fun getFullNames() {
    val firstName1 = readLine()
    val lastName1 = readLine()
    println("$firstName1 $lastName1")

    val firstName2 = readLine()
    val lastName2 = readLine()
    println("$firstName2 $lastName2")

    val firstName3 = readLine()
    val lastName3 = readLine()
    println("$firstName3 $lastName3")
}

// implement your function here
@Suppress("unused")
fun createFullName(firstName: String, lastName: String): String {
    return "$firstName $lastName"
}
