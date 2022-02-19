class Vehicle {
    // add name
    var name: String = ""

    // create constructor
    constructor(name: String) {
        this.name = name
    }

    // create inner class Body
    inner class Body {
        // add color
        var color: String = ""

        // create constructor
        constructor(color: String) {
            this.color = color
        }

        // create method
        fun printColor() {
            println("The $name vehicle has a $color body.")
        }
    }
}
