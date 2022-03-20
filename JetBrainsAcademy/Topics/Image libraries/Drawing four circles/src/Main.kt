import java.awt.Color
import java.awt.image.BufferedImage

fun drawCircles(): BufferedImage {
    val image = BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB)

    drawCircle(50, 50, 50, Color.RED, image)
    drawCircle(50, 75, 50, Color.YELLOW, image)
    drawCircle(75, 50, 50, Color.GREEN, image)
    drawCircle(75, 75, 50, Color.BLUE, image)

    return image
}

fun drawCircle(x: Int, y: Int, radius: Int, color: Color, image: BufferedImage): BufferedImage {
    val g = image.createGraphics()
    g.color = color
    g.drawOval(x, y, radius * 2, radius * 2)
    return image
}
