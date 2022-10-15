fun solution(names: List<String>): Int {
    return names.withIndex().indexOfFirst { it.index % 2 == 1 && it.value.startsWith("T") }
}