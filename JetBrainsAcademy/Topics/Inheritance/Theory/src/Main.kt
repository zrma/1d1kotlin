// You can experiment here, it won’t be checked

fun main(args: Array<String>) {
    val spiderManBook = Comics(60, "The Universe", 8.99F)
    print(spiderManBook.getFullInfo())

    val centralBooklet = Booklet(5, 0.14F)
    print(centralBooklet.getUSDCost())

    println(isBigBook(spiderManBook))
    println(isBigBook(centralBooklet))
}

open class Book(val pages: Int, private val author: String, var cost: Float = 0F) {
    fun getFullInfo(): String {
        return "$pages pages, $author author, $$cost cost"
    }
}

class Comics(pages: Int, author: String, cost: Float) : Book(pages, author, cost)

class Booklet(pages: Int, cost: Float) : Book(pages, "", cost) {
    fun getUSDCost(): String {
        return "$$cost cost"
    }

    fun getEuroCost(): String {
        return "€$cost cost"
    }
}

fun isBigBook(book: Book): Boolean {
    return book.pages >= 100
}