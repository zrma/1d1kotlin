package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    println("Enter rectangle width:")
    val width = readLine()!!.toInt()

    println("Enter rectangle height:")
    val height = readLine()!!.toInt()

    println("Enter output image name:")
    val outputImageName = readLine()!!

    val image = BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR)

    val graphics = image.createGraphics()
    graphics.color = Color.RED
    graphics.drawLine(0, 0, width - 1, height - 1)
    graphics.drawLine(width - 1, 0, 0, height - 1)

    ImageIO.write(image, "png", File(outputImageName))
}
