fun iterator(map: Map<String, Int>) {
    map.forEach {
        when {
            it.value % 3 == 0 -> println("Fizz")
            it.value % 5 == 0 -> println("Buzz")
            else -> println("FizzBuzz")
        }
    }
}