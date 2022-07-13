fun main(args: Array<String>) {
    if (args.size < 3) {
        main(arrayOf("first", "second", "third"))
    } else {
       args.forEach { println(it) }
    }
}