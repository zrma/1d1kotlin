import java.awt.Color
import java.awt.image.BufferedImage

fun drawSquare(): BufferedImage {
    val image = BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB)
    val g = image.graphics
    g.color = Color.RED
    g.drawRect(100, 100, 300, 300)
    return image
}
