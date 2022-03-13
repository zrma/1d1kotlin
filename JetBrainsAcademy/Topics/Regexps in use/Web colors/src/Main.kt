fun main() {
    val text = readLine()!!
    val regexColors = "#[0-9a-fA-F]{6}\\b".toRegex()
    // write your code here
    for (match in regexColors.findAll(text)) {
        println(match.value)
    }
}
