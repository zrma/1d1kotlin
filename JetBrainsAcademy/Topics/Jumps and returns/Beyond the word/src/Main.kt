fun main() {
    val removeTarget = readLine()!!
    @Suppress("SpellCheckingInspection") val result = "abcdefghijklmnopqrstuvwxyz".toMutableList()

    for (token in removeTarget) {
        result.remove(token)
    }
    println(result.joinToString(""))
}
