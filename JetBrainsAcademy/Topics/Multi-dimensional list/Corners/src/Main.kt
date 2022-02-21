fun main() {
    // Do not touch code below
    val inputList: MutableList<MutableList<String>> = mutableListOf()
    val n = readLine()!!.toInt()
    for (i in 0 until n) {
        val strings = readLine()!!.split(' ').toMutableList()
        inputList.add(strings)
    }
    // write your code here
    val firstLine = inputList.first()
    val lastLine = inputList.last()
    println("${firstLine.first()} ${firstLine.last()}")
    println("${lastLine.first()} ${lastLine.last()}")
}
