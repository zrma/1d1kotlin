fun main() {
    accessSmartHome()
}

// turns the music on and off
fun controlMusic() {
    println("on/off?")
    when (readLine()) {
        "on" -> println("The music is on")
        "off" -> println("The music is off")
        else -> println("Invalid operation")
    }
}

// verifies the password and gives the access to Smart home actions if the password is correct
fun accessSmartHome() {
    val password = "76543210"
    print("Enter password: ")
    val passwordInput = readLine()
    if (passwordInput == password) chooseAction() else println("Incorrect password!")
}

// main menu for choosing the action
fun chooseAction() {
    val speakersState = "on"

    // adding new action 4
    println("Choose the object: 1 – speakers, 2 – lamp, 3 – door, 4 – kettle")
    when (readLine()) {
        "1" -> {
            // asking the user about the speakers
            when (speakersState) {
                "on" -> {
                    // ...
                }
                "off" -> {
                    // ...
                }
                else -> {
                    // ...
                }
            }
        }
        "2" -> {
            // asking the user about the lights...
        }
        "3" -> {
            // asking the user about the door...
        }
        else -> {
            // ...
            controlMusic()
        }
    // ...
    }
}
