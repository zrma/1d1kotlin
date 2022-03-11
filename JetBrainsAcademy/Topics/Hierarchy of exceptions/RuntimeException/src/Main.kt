fun main() {
    try {
        // write your code here, do not touch the lines above
        throw RuntimeException("Hello World")

        // do not touch the lines below
    } catch (e: RuntimeException) {
        println("Well")
    } catch (e: Exception) {
        println("Wrong")
    }
}
