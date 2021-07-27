fun main() {
    var backFromTheWall = readLine()!!.split(',').map { it }.toTypedArray()
    val returnedWatchman = readLine()!!.toString()
    // do not touch the lines above

    backFromTheWall += returnedWatchman
    println(backFromTheWall.joinToString(", "))
}
