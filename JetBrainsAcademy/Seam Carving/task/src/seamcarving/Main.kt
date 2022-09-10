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
    var image = ImageIO.read(inputFile)

    image = image.transpose()

    val seam = findSeam(image)
    applySeam(image, seam)

    image = image.transpose()

    // save reversed image
    ImageIO.write(image, "png", outputFile)
}

fun BufferedImage.transpose(): BufferedImage {
    val transposedImage = BufferedImage(this.height, this.width, this.type)
    for (x in 0 until this.width) {
        for (y in 0 until this.height) {
            transposedImage.setRGB(y, x, this.getRGB(x, y))
        }
    }
    return transposedImage
}

fun applySeam(image: BufferedImage, seam: List<Pair<Int, Int>>) {
    for ((y, x) in seam) {
        image.setRGB(x, y, Color.RED.rgb)
    }
}

fun findSeam(image: BufferedImage): List<Pair<Int, Int>> {
    val energyInfo = dualGradientEnergy(image)
    val normalized = normalize(image, energyInfo)
    return findMinSumEnergyPath(normalized, energyInfo.first)
}

fun findMinSumEnergyPath(image: BufferedImage, energies: Array<Array<Double>>): List<Pair<Int, Int>> {
    val width = image.width
    val height = image.height

    val sumMatrix = Array(height) { Array(width) { 0.0 } }

    // https://en.m.wikipedia.org/wiki/Seam_carving#Dynamic_programming
    for (y in 0 until height) {
        for (x in 0 until width) {
            if (y == 0) {
                // top row has no row above it, so will be initialized with energy data
                sumMatrix[y][x] = energies[y][x]
            } else {
                sumMatrix[y][x] = energies[y][x] + getNextMin(sumMatrix, x, y).first
            }
        }
    }

    val seam = emptyList<Pair<Int, Int>>().toMutableList()

    // find minimum in last row and ...
    var minimumEnergy = Double.MAX_VALUE
    var xOfMinimum = 0
    for (x in 0 until width) {
        if (sumMatrix[height - 1][x] < minimumEnergy) {
            minimumEnergy = sumMatrix[height - 1][x]
            xOfMinimum = x
        }
    }
    seam.add(Pair(height - 1, xOfMinimum))

    // ... step back up each row, only up+left, up, up+right, always choose the minimum
    for (y in height - 1 downTo 0) {
        xOfMinimum += getNextMin(sumMatrix, xOfMinimum, y + 1).second

        seam.add(Pair(y, xOfMinimum))
    }

    return seam
}

private fun getNextMin(sumMatrix: Array<Array<Double>>, x: Int, y: Int): Pair<Double, Int> {
    val rightBorder = sumMatrix.first().size
    return arrayOf(
        Pair(if (x == 0) Double.MAX_VALUE else sumMatrix[y - 1][x - 1], -1),
        Pair(sumMatrix[y - 1][x], 0),
        Pair(if (x == rightBorder - 1) Double.MAX_VALUE else sumMatrix[y - 1][x + 1], 1)
    ).minOfWith(compareBy { it.first }) { it }
}

fun normalize(image: BufferedImage, energyInfo: Pair<Array<Array<Double>>, Double>): BufferedImage {
    val width = image.width
    val height = image.height
    val newImage = BufferedImage(width, height, BufferedImage.TYPE_INT_RGB)
    val (energyTable, maxEnergyValue) = energyInfo

    for (y in 0 until height) {
        for (x in 0 until width) {
            val energy = energyTable[y][x]
            val intensity = (255.0 * energy / maxEnergyValue).toInt()
            newImage.setRGB(x, y, Color(intensity, intensity, intensity).rgb)
        }
    }
    return newImage
}

fun dualGradientEnergy(image: BufferedImage): Pair<Array<Array<Double>>, Double> {
    val width = image.width
    val height = image.height
    val res = Array(height) { Array(width) { 0.0 } }

    var maxEnergyValue = 0.0

    for (y in 0 until height) {
        for (x in 0 until width) {
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
            res[y][x] = energy
        }
    }
    return res to maxEnergyValue
}
