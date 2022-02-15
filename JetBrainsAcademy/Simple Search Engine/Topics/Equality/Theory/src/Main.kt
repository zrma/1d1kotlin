fun main() {
    val msg1 = "Hi"
    val msg2 = "Hi"

    println(msg1 == msg2) // true
    println(msg1 == "Hello") // false
    println(msg2 != "Hello") // true

    val blueBox = Box(3) // box with 3 balls
    @Suppress("UnnecessaryVariable") val azureBox = blueBox
    val cyanBox = Box(3)
    println(blueBox == azureBox) // true, it's a copy
    println(blueBox === azureBox) // true, azureBox points to the same object

    println(blueBox == cyanBox) // true
    println(blueBox === cyanBox) // false, cyanBox points to another object

    blueBox.addBall() // add a ball to the first box
    println(blueBox == azureBox) // true, the second box also contains 4 balls
    println(blueBox === azureBox) // true, azureBox points to the same object

    println(blueBox == cyanBox) // false
    println(blueBox === cyanBox) // false, cyanBox points to another object

    var two = 2
    val anotherTwo = 2
    @Suppress("DEPRECATED_IDENTITY_EQUALS") println(two === anotherTwo) // true

    two += 1
    println(two) // 3
    println(anotherTwo) // 2

    val box = Box(5) // a box with 5 balls
    box.addBall()

    val newBox = Box(6)
    // newBox = Box(6) // reassignment of value is impossible

    var anotherBox = Box(6)
    println(newBox == anotherBox) // true

    anotherBox = Box(2)
    println(newBox == anotherBox) // false
}

class Box(var ball: Int) {
    fun addBall() = ++ball
    override fun equals(other: Any?) = ball == (other as Box).ball
    override fun hashCode(): Int = ball
}
