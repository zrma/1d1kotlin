class City(val name: String) {
    var population: Int = 0
        set(value) {
            field =
                when {
                    value < 0 -> 0
                    value > 50_000_000 -> 50_000_000
                    else -> value
                }
        }
}
