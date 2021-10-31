fun main() {
    class Emptiness {
        // empty body
    }

    @Suppress("RedundantExplicitType", "UNUSED_VARIABLE") val empty0: Emptiness = Emptiness()
    @Suppress("UNUSED_VARIABLE") val empty1 = Emptiness()

    class Patient {
        var name: String = "Unknown"
        var age: Int = 0
        var height: Double = 0.0
    }

    val patient = Patient()
    println(patient.name) // prints "Unknown"
    println(patient.age) // prints "0"
    println(patient.height) // prints "0.0"

    val john = Patient()
    john.name = "John"
    john.age = 30
    john.height = 180.0

    val alice = Patient()
    alice.name = "Alice"
    alice.age = 22
    alice.height = 165.0

    println("${john.name}: ${john.age} yrs, ${john.height} cm")
    println("${alice.name}: ${alice.age} yrs, ${alice.height} cm")
}
