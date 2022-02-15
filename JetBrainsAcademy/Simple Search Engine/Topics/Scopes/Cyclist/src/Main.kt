fun main() {
    var distance = readLine()!!.toInt() // the distance back
    var totalDistance = readLine()!!.toInt()

    // fix the code below
    if (distance < 0) {
        distance = -distance
    }
    totalDistance += distance
    println(totalDistance)
}
