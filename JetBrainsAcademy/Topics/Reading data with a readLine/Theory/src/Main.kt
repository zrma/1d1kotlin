fun main() {
    val line = readLine()!!
    println(line)

    print("Print any number: ")
    val number0 = readLine()!!.toInt()
    print("You printed the number: ")
    println(number0)

    print("How much is your yacht worth? ")
    val cost = readLine()!!.toLong()
    print("You printed: ")
    println(cost)

    print("Print any double type number: ")
    val number1 = readLine()!!.toDouble()
    print("You printed the number: ")
    println(number1)

    print("The earth is flat. Print true or false: ")
    val answer = readLine()!!.toBoolean()
    print("The earth is flat: ")
    println(answer)

    val a0 = readLine()!!
    val b0 = readLine()!!.toInt()
    val c0 = readLine()!!
    print(a0)
    print(" ")
    print(b0)
    print(" ")
    println(c0)

    val (a1, b1) = readLine()!!.split(" ")
    println(a1)
    println(b1)

    val (a2, b2, c2, d2) = readLine()!!.split(" ")
    println(a2)
    println(b2)
    println(c2)
    println(d2)
}
