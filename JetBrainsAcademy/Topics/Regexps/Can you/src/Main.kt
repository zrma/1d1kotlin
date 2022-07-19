fun main() {
    val answer = readln()
    val regex = "I can(\'t)? do my homework on time!"
    println(answer.matches(regex.toRegex()))
}