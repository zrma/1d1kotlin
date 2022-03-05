fun main() {
    val size1 = Size(3, 4)
    val size2 = Size(5, 1)
    println(size1)
    println(size2)

    // val size = Size() // Error! No values passed for parameters _width and _height

    val size3 = SizeWithMultipleConstructors(7) // uses 1st constructor
    val size4 = SizeWithMultipleConstructors(0, 7) // uses 2nd constructor
    val size5 = SizeWithMultipleConstructors(0, 7.0) // uses 3rd constructor
    val size6 = SizeWithMultipleConstructors(7.0, 0) // uses 4th constructor
    println(size3)
    println(size4)
    println(size5)
    println(size6)

    val outerObject = SizeVarReassigning(5, 8)
    @Suppress("UNUSED_VARIABLE") val innerObject = SizeVarReassigning(2, 3, outerObject)
}

@Suppress("ConvertSecondaryConstructorToPrimary")
class Size {
    var width: Int = 0
    var height: Int = 0

    constructor(_width: Int, _height: Int) {
        width = _width
        height = _height
    }
}

// preferable solution
@Suppress("unused")
class SizeWithNoConstructor() {
    var width: Int = 0
    var height: Int = 0
}

// or this way
@Suppress("ConvertSecondaryConstructorToPrimary", "unused")
class SizeWithNoArgsConstructor {
    var width: Int = 0
    var height: Int = 0

    constructor() {}
}

class SizeWithMultipleConstructors {
    var width: Int = 0
    var height: Int = 0

    constructor(_height: Int) {
        height = _height
    }

    constructor(_width: Int, _height: Int) {
        this.width = _width
        this.height = _height
    }

    constructor(x: Int, y: Double) {
        width = x
        height = y.toInt()
    }

    constructor(_height: Double, _width: Int) {
        width = _width
        height = _height.toInt()
    }
}

@Suppress("unused")
class SizeWithConstructorValueAssigning(var width: Int, var height: Int) {
    // whatever you want
}

@Suppress("ConvertSecondaryConstructorToPrimary", "unused")
class SizeWithReassigning {
    private val width: Int
    private val height: Int
    private val area: Int

    constructor(width: Int, height: Int) {
        this.width = width
        this.height = height
        this.area = width * height
    }
}

// class SizeValReassigningError() {
//    constructor(val width: Int, val height: Int) { // error, val is not allowed
//    }
// }

class SizeVarReassigning(private val width: Int, private val height: Int) {
    var area: Int = width * height

    init {
        println("Object with area equal to $area is created")
    }

    constructor(width: Int, height: Int, outerSize: SizeVarReassigning) : this(width, height) {
        outerSize.area -= this.area
        println("Updated outer object's area is equal to ${outerSize.area}")
    }
}
