fun pepTalk(name: String): String {
    val array = name.split(" ").toTypedArray()
    val firstName = array[0]
    val secondName = array[1]
    return "Don't lose the towel, traveler $firstName $secondName!"
}
// do not change the function above

fun main() {
    val name = readLine()!!

    val advice =
        try {
            pepTalk(name) // fix this function call
        } catch (_: Exception) {
            "Don't lose the towel, nameless one."
        } finally {
            println("Good luck!")
        }
    print(advice)
}
