@Suppress("SpellCheckingInspection")
fun isVowel(c: Char): Boolean = "aeiou".contains(c, ignoreCase = true)

fun main() {
    val letter = readLine()!!.first()

    println(isVowel(letter))
}
