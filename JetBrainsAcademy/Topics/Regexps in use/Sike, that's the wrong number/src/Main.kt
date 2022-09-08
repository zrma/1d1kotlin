fun main() {
    val number = readln()

    val regex = Regex("[A-Z|a-z]")
    println(number.replace(regex, ""))
}