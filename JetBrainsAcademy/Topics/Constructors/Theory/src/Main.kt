fun main() {
    val size = SizeDefaultAndNamedArguments()
    println(size.area) // 1

    val size1 = SizeDefaultAndNamedArguments(3, 5) // width == 3, height == 5
    println(size1.area) // 15

    val size2 = SizeDefaultAndNamedArguments(width = 3, height = 5) // width == 3, height == 5
    println(size2.area) // 15

    val size3 = SizeDefaultAndNamedArguments(height = 5, width = 3) // width == 3, height == 5
    println(size3.area) // 15

    val sizeWide = SizeDefaultAndNamedArguments(10) // width == 10, height == 1
    println(sizeWide.area) // 10

    val sizeHigh = SizeDefaultAndNamedArguments(height = 10) // width == 1, height == 10
    println(sizeHigh.area) // 10

    val size0 = Size(3, 4)
    println(size0.width)
    println(size0.height)

    val sizeInvalidWidth = SizeWithInitializerBlock1(-1, 4)
    println(sizeInvalidWidth.width)
    println(sizeInvalidWidth.height)

    val sizeInvalidHeight = SizeWithInitializerBlock1(3, -1)
    println(sizeInvalidHeight.width)
    println(sizeInvalidHeight.height)

    val sizeWithInitializerBlock = SizeWithInitializerBlock2(3, 4)
    println(sizeWithInitializerBlock.area)
}

@Suppress("unused")
class SizeWithDefaultConstructor {
    var width: Int = 1
    var height: Int = 1
}

@Suppress("unused", "CanBePrimaryConstructorProperty")
class SizeWithPrimaryConstructor(width: Int, height: Int) {
    val width: Int = width
    val height: Int = height
    val area: Int = width * height
}

@Suppress("unused", "CanBePrimaryConstructorProperty")
class SizeWithConstructorKeyword constructor(width: Int, height: Int) {
    val width: Int = width
    val height: Int = height
    val area: Int = width * height
}

@Suppress("unused", "CanBePrimaryConstructorProperty", "MemberVisibilityCanBePrivate")
class SizeWithPropertyDeclarations1(width: Int, height: Int) {
    val height: Int = height
    val area: Int = width * height
}

@Suppress("unused", "MemberVisibilityCanBePrivate")
class SizeWithPropertyDeclarations2(width: Int, height: Int) {
    val area: Int = width * height
}

class SizeDefaultAndNamedArguments(width: Int = 1, height: Int = 1) {
    val area: Int = width * height
}

class Size(val width: Int, val height: Int)

class SizeWithInitializerBlock1(_width: Int, _height: Int) {
    var width: Int = 0
    var height: Int = 0

    init {
        width =
            if (_width >= 0) _width
            else {
                println("Error, the width should be a non-negative value")
                0
            }
        height =
            if (_height >= 0) _height
            else {
                println("Error, the height should be a non-negative value")
                0
            }
    }
}

class SizeWithInitializerBlock2(_width: Int, _height: Int) {
    private val width = _width
    init {
        println("First initializer block that prints the width $width")
    }
    private val height = _height
    init {
        println("Second initializer block that prints the height $height")
    }
    val area = width * height
}
