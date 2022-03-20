import java.awt.Color
import java.awt.image.BufferedImage

fun drawStrings(): BufferedImage {
    val image = BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB)

    val s = "Hello, images!"
    drawText(50, 50, s, Color.RED, image)
    drawText(51, 51, s, Color.GREEN, image)
    drawText(52, 52, s, Color.BLUE, image)

    return image
}

fun drawText(x: Int, y: Int, text: String, color: Color, image: BufferedImage) {
    val g = image.graphics
    g.color = color
    g.drawString(text, x, y)
}
