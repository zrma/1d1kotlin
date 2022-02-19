fun main() {
    val input = readLine()!!
    println(
        when (isPalindrome(input)) {
            true -> "yes"
            false -> "no"
        }
    )
}

fun isPalindrome(input: String): Boolean {
    var i = 0
    var j = input.lastIndex
    while (i < j) {
        if (input[i] != input[j]) {
            return false
        }
        i++
        j--
    }
    return true
}
