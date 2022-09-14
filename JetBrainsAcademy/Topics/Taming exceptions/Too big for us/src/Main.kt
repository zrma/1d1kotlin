fun returnValue(): Int {
    val value = readln().toInt()

    if (value > 0) {
        throw Exception("It's too big")
    }
    return value
}