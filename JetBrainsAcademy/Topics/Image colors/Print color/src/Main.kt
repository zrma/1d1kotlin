fun printColor(myImage: BufferedImage) {
    val (x, y) = readLine()!!.split(" ").map { it.toInt() }

    val color = myImage.getRGB(x, y)
    Color(color, true).let { println("${it.red} ${it.green} ${it.blue} ${it.alpha}") }
}
