fun solution(products: List<String>, product: String) {
    println(products.withIndex().filter { it.value == product }.map { it.index }.joinToString(" "))
}
