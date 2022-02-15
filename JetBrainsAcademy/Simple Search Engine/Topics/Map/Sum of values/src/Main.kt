fun summator(map: Map<Int, Int>): Int {
    return map.filterKeys { it % 2 == 0 }.values.sum()
}
