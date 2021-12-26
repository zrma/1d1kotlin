fun main() {
    println("main() started")
    count(1, 10)
    println("main() complete")

    val casper = Cat("Casper", -1)
}

fun count(from: Int, to: Int) {
    println("count() started")
    var start = from
    while (start < to) {
        println(start)
        start++
    }
    println("count() complete")
}

class Cat(val name: String, val age: Int) {
    private val enoughCat = false // Of course, it's a false, there are never enough cats!
    init {
        check(!enoughCat) { "You cannot add a new cat" } // IllegalStateException
        require(age >= 0) { "Invalid age: $age" } // IllegalArgumentException
    }
}
