fun main() {
    //Do not touch code below
    var inputArray: Array<Array<String>> = arrayOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toTypedArray()
        inputArray += strings
    }
    //write your code here
    val firstLine = inputArray.first()
    val lastLine = inputArray.last()
    println("${firstLine.first()} ${firstLine.last()}")
    println("${lastLine.first()} ${lastLine.last()}")
}