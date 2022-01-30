fun main(args: Array<String>) {
    if (args.size != 3) {
        println("Invalid number of program arguments")
        return
    }
    args.withIndex().forEach {
        println("Argument ${it.index.inc()}: ${it.value}. It has ${it.value.length} characters")
    }
}
