fun removing(currentMap: MutableMap<Int, String>, value: String): MutableMap<Int, String> {
    return currentMap.filterValues { it != value }.toMutableMap()
}
