fun containsKeyAndValue(map: Map<String, String>, value: String): Boolean {
    return value in map.keys && value in map.values
}
