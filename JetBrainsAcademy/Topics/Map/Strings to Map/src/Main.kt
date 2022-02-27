fun stringToMap(first: String, second: String, third: String): Map<String, Int> {
    return mapOf(
        first to first.length,
        second to second.length,
        third to third.length
    )
}