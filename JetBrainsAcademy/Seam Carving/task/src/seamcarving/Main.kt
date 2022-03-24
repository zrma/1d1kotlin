package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.pow
import kotlin.math.sqrt

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

    val energyInfo = dualGradientEnergy(image)
    val result = applyTable(image, energyInfo)

    // save reversed image
    ImageIO.write(result, "png", outputFile)
}

fun applyTable(
    image: BufferedImage,
    energyInfo: Pair<Array<Array<Double>>, Double>
): BufferedImage {
    val width = image.width
    val height = image.height
    val newImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val (energyTable, maxEnergyValue) = energyInfo

    for (x in 0 until width) {
        for (y in 0 until height) {
            val energy = energyTable[x][y]
            val intensity = (255.0 * energy / maxEnergyValue).toInt()
            newImage.setRGB(x, y, Color(intensity, intensity, intensity).rgb)
        }
    }
    return newImage
}

fun dualGradientEnergy(image: BufferedImage): Pair<Array<Array<Double>>, Double> {
    val width = image.width
    val height = image.height
    val res = Array(width) { Array(height) { 0.0 } }

    var maxEnergyValue = 0.0

    for (x in 0 until width) {
        for (y in 0 until height) {
            val posX =
                when (x) {
                    0 -> 1
                    width - 1 -> width - 2
                    else -> x
                }
            val posY =
                when (y) {
                    0 -> 1
                    height - 1 -> height - 2
                    else -> y
                }
            val left = Color(image.getRGB(posX - 1, y))
            val right = Color(image.getRGB(posX + 1, y))
            val up = Color(image.getRGB(x, posY - 1))
            val down = Color(image.getRGB(x, posY + 1))
            val dX =
                (left.red.toDouble() - right.red.toDouble()).pow(2.0) +
                    (left.green.toDouble() - right.green.toDouble()).pow(2.0) +
                    (left.blue.toDouble() - right.blue.toDouble()).pow(2.0)

            val dY =
                (up.red.toDouble() - down.red.toDouble()).pow(2.0) +
                    (up.green.toDouble() - down.green.toDouble()).pow(2.0) +
                    (up.blue.toDouble() - down.blue.toDouble()).pow(2.0)
            val energy = sqrt(dX + dY)
            maxEnergyValue = maxOf(maxEnergyValue, energy)
            res[x][y] = energy
        }
    }
    return res to maxEnergyValue
}
