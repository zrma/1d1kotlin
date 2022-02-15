fun solution(numbers: List<Int>) {
    println(numbers.filter { it % 2 == 0 }.joinToString(" "))
}
