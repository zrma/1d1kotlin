import java.util.*

fun main() {
    val vowels = "aeiouy"
    val input = readLine()!!.lowercase(Locale.getDefault())

    val isVowel = { c: Char -> vowels.contains(c) }
    var res = 0
    var i = 0
    while (i <= input.lastIndex - 2) {
        if (isVowel(input[i]) && isVowel(input[i + 1]) && isVowel(input[i + 2])) {
            res++
            i++
        } else if (!isVowel(input[i]) && !isVowel(input[i + 1]) && !isVowel(input[i + 2])) {
            res++
            i++
        }
        i++
    }
    println(res)
}