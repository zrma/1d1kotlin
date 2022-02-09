fun helpingTheRobot(
    purchases: Map<String, Int>,
    addition: Map<String, Int>
): MutableMap<String, Int> {
    val result = purchases.toMutableMap()
    addition.forEach { (key, value) -> result[key] = result.getOrDefault(key, 0) + value }
    return result
}
