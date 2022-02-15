fun main() {
    // Exception in thread "main" java.lang.NumberFormatException: For input string: "Hi :)"
    //	at java.lang.NumberFormatException.forInputString(NumberFormatException.java:65)
    //	at java.lang.Integer.parseInt(Integer.java:580)
    //	at java.lang.Integer.parseInt(Integer.java:615)
    //	at MainKt.readNextInt(Main.kt:6)
    //	at MainKt.runIncrementer(Main.kt:10)
    //	at MainKt.main(Main.kt:2)
    //	at MainKt.main(Main.kt)
    runIncrementer()
}

fun readNextInt(): Int {
    return readLine()!!.toInt()
}

fun runIncrementer() {
    val increment = 1 + readNextInt()
    println(increment)
}
