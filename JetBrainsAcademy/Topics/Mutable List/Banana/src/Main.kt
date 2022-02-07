fun solution(strings: MutableList<String>, str: String): MutableList<String> {
    strings.replaceAll { if (it == str) "Banana" else it }
    return strings
}
