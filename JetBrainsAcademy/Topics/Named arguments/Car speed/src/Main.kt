fun main() {
    val actualSpeed = readLine()!!.toInt()
    val limitOfRoad = readLine()

    if (limitOfRoad == "no limit") {
        carSpeed(actualSpeed)
    } else {
        carSpeed(actualSpeed, limitOfRoad!!.toInt())
    }
}

fun carSpeed(actualSpeed: Int, limitOfRoad: Int = 60) {
    if (actualSpeed > limitOfRoad) {
        println("Exceeds the limit by ${actualSpeed - limitOfRoad} kilometers per hour")
    } else {
        println("Within the limit")
    }
}
