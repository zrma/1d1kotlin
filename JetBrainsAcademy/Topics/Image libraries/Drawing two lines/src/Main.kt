import java.awt.Color
import java.awt.image.BufferedImage

fun drawLines(): BufferedImage {
    val image = BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB)

    drawRedLine(image)
    drawGreenLine(image)

    return image
}

fun drawRedLine(image: BufferedImage) {
    val g = image.graphics
    g.color = Color.RED
    g.drawLine(0, 0, image.width, image.height)
}

fun drawGreenLine(image: BufferedImage) {
    val g = image.graphics
    g.color = Color.GREEN
    g.drawLine(0, image.height, image.width, 0)
}
