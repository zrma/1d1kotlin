fun main() {
    val daysOfWeek = arrayOf("Sun", "Mon", "Tues", "Wed", "Thur", "Fri", "Sat")

    for (day in daysOfWeek) {
        println(day)
    }

    for (index in daysOfWeek.indices) {
        println("$index: ${daysOfWeek[index]}")
    }

    for (index in 1..5) {
        println("$index: ${daysOfWeek[index]}")
    }

    for (index in 1 until daysOfWeek.lastIndex) {
        println("$index: ${daysOfWeek[index]}")
    }

    for (index in daysOfWeek.lastIndex downTo 0 step 2) {
        println("$index: ${daysOfWeek[index]}")
    }

    val size = readLine()!!.toInt()
    val array = IntArray(size)

    for (i in 0..array.lastIndex) {
        array[i] = readLine()!!.toInt()
    }

    for (i in array.lastIndex downTo 0) {
        print("${array[i]} ")
    }
}
