class Vehicle(var name: String) {
    // add name

    // create constructor

    inner class Engine(var horsePower: Int) {
        // add horsePower

        // create constructor

        fun start() {
            println("RRRrrrrrrr....")
        }

        // create function printHorsePower()
        fun printHorsePower() {
            println("The $name vehicle has $horsePower horsepower.")
        }
    }
}
