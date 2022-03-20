import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO

fun main() {
    val height: Int = 800
    val width: Int = 600
    val image = BufferedImage(height, width, BufferedImage.TYPE_INT_RGB)

    val graphics = image.createGraphics()
    graphics.drawString("Playing with images", 80, 80)
    graphics.color = Color.ORANGE
    graphics.drawArc(200, 200, 100, 250, 45, 90)
}

fun treatImage() {
    val height: Int = 800
    val width: Int = 600

    val image = BufferedImage(height, width, BufferedImage.TYPE_INT_RGB)
    val imageFile = File("myFirstImage.png")

    saveImage(image, imageFile)

    val imageFileRead = File("myFirstImage.png")

    val imageRead: BufferedImage = ImageIO.read(imageFileRead)
    val graphics = image.createGraphics()
    graphics.color = Color.RED

    graphics.drawPolygon(intArrayOf(10, 20, 30), intArrayOf(100, 20, 100), 3)
    saveImage(image, imageFile)
}

fun saveImage(image: BufferedImage, imageFile: File) {
    ImageIO.write(image, "png", imageFile)
}
