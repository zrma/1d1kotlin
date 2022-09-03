fun main() {
    val studentsMarks = mutableMapOf<String, Int>()
    while (true) {
        val key = readLine()!!
        if (key == "stop") {
            break
        }

        val value = readLine()!!.toInt()
        if (!studentsMarks.containsKey(key)) {
            studentsMarks[key] = value
        }
    }
    println(studentsMarks)
}
