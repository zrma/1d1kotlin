fun main() {
    var outer = 10
    @Suppress("KotlinConstantConditions")
    if (outer > 0) {
        val inner = 10
        print(inner)
    } else {
        // beyond the if block
        print(outer)
        // print(inner) // Unresolved reference: inner
    }
    // beyond the if-else expression
    print(outer)
    // print(inner) // Unresolved reference: inner

    outer = 5
    while (outer < 10) {
        var inner = 10
        inner *= 2
        print(inner)
        outer++
    } // prints 2020202020
    // print(inner)  // Unresolved reference: inner

    val identifier = "Variable in fun main()"
    localScope()
    println(identifier) // prints "Variable in fun main()"

    var id = 5
    @Suppress("ConstantConditionIf")
    if (true) {
        id = 6

        @Suppress("NAME_SHADOWING") val id = 10
        println(id) // prints 10
    }
    println(id) // prints 6

    println(top) // prints "Top-level variable"
    localScopePrint() // prints "Top-level variable"
}

fun localScope() {
    val identifier = "Variable in the function localScope()"
    println(identifier) // prints "Variable in the function localScope()"
}

const val top = "Top-level variable"

fun localScopePrint() {
    println(top)
}
