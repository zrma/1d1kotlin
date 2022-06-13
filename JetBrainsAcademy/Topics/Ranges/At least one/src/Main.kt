fun main() {
    val range0 = readLine()!!.toInt()..readLine()!!.toInt()
    val range1 = readLine()!!.toInt()..readLine()!!.toInt()

    val target = readLine()!!.toInt()

    println(range0.contains(target) || range1.contains(target))
}