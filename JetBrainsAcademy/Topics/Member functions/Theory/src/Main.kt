import kotlin.random.Random

fun main() {
    MyClass().print()
    MyClassWithProperty(10).printProperty()

    val pharaoh = Cat("Pharaoh") // Create a cat named "Pharaoh"

    repeat(5) {
        pharaoh.say() // it says "meow" or "zzz"
    }

    pharaoh.wakeUp() // wake the cat up
    pharaoh.say() // it says "meow"
}

class MyClass {
    fun print() = println("Hello from print")
}

class MyClassWithProperty(var property: Int) {
    fun printProperty() {
        println(this.property)
    }
}

class Cat(val name: String) {
    var sleeping: Boolean = false

    fun say() {
        if (sleeping) {
            println("zzz")
        } else {
            println("meow")

            if (Random.nextDouble() < 0.5) {
                sleeping = true
            }
        }
    }

    fun wakeUp() {
        sleeping = false
    }
}
