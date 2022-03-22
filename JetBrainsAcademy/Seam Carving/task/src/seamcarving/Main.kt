package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main(args: Array<String>) {
    // use -in and -out to specify input and output files
    if (args.size < 4) {
        println("Usage: java Main -in input.png -out output.png")
        return
    }
    val inputFile = File(args[1])
    val outputFile = File(args[3])

    // read image
    val image = ImageIO.read(inputFile)

    // invert rgb of image
    val rgbReverseImage = invertRGB(image)

    // save reversed image
    ImageIO.write(rgbReverseImage, "png", outputFile)
}

fun invertRGB(image: BufferedImage): BufferedImage {
    val width = image.width
    val height = image.height
    val newImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)

    for (x in 0 until width) {
        for (y in 0 until height) {
            newImage.setRGB(x, y, invertColor(image.getRGB(x, y)))
        }
    }
    return newImage
}

fun invertColor(rgb: Int): Int {
    val color = Color(rgb)
    val newColor = Color(255 - color.red, 255 - color.green, 255 - color.blue)
    return newColor.rgb
}
