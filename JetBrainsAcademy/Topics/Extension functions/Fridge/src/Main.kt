// Do not fix code below
class Fridge {
    fun open() = println(1)
    fun find(productName: String): Product {
        println(productName)
        return 4
    }
    fun close() = println(3)
}

// Write your code here
fun Fridge.take(productName: String): Product {
    open()
    val product = find(productName)
    close()

    return product
}
