package seamcarving

import java.awt.Color
import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.math.pow
import kotlin.math.sqrt

fun main(args: Array<String>) {
    val (inputFileName, outputFileName, width, height) = parseArgs(args)

    var image = ImageIO.read(File(inputFileName))
    image = reduceImageVertical(image, width)
    image = reduceImageHorizontal(image, height)

    ImageIO.write(image, "png", File(outputFileName))
}

fun reduceImageVertical(image: BufferedImage, count: Int): BufferedImage {
    var result = image
    repeat(count) {
        val seam = findSeamVertical(result)
        result = removeSeamVertical(result, seam)
    }
    return result
}

fun reduceImageHorizontal(image: BufferedImage, count: Int): BufferedImage {
    var result = image.transpose()
    result = reduceImageVertical(result, count)
    return result.transpose()
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

fun removeSeamVertical(image: BufferedImage, seam: List<Pair<Int, Int>>): BufferedImage {
    val newImage = BufferedImage(image.width - 1, image.height, image.type)
    for (y in 0 until image.height) {
        val seamX = seam.find { it.first == y }!!.second
        for (x in 0 until image.width - 1) {
            val xOld = if (x < seamX) x else x + 1
            newImage.setRGB(x, y, image.getRGB(xOld, y))
        }
    }
    return newImage
}

fun findSeamVertical(image: BufferedImage): List<Pair<Int, Int>> {
    val energyTable = dualGradientEnergyTable(image)
    val width = image.width
    val height = image.height

    val sumMatrix = Array(height) { Array(width) { 0.0 } }

    // https://en.m.wikipedia.org/wiki/Seam_carving#Dynamic_programming
    for (y in 0 until height) {
        for (x in 0 until width) {
            if (y == 0) {
                // top row has no row above it, so will be initialized with energy data
                sumMatrix[y][x] = energyTable[y][x]
            } else {
                sumMatrix[y][x] = energyTable[y][x] + getNextMin(sumMatrix, x, y).first
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

fun dualGradientEnergyTable(image: BufferedImage): Array<Array<Double>> {
    val width = image.width
    val height = image.height
    val res = Array(height) { Array(width) { 0.0 } }

    for (y in 0 until height) {
        for (x in 0 until width) {
            val posX = when (x) {
                0 -> 1
                width - 1 -> width - 2
                else -> x
            }
            val posY = when (y) {
                0 -> 1
                height - 1 -> height - 2
                else -> y
            }
            val left = Color(image.getRGB(posX - 1, y))
            val right = Color(image.getRGB(posX + 1, y))
            val up = Color(image.getRGB(x, posY - 1))
            val down = Color(image.getRGB(x, posY + 1))

            val dX = colorDiffPow(left, right)
            val dY = colorDiffPow(up, down)

            val energy = sqrt(dX + dY)
            res[y][x] = energy
        }
    }
    return res
}

fun colorDiffPow(c1: Color, c2: Color): Double {
    return (c1.red - c2.red).toDouble().pow(2.0) + (c1.green - c2.green).toDouble()
        .pow(2.0) + (c1.blue - c2.blue).toDouble().pow(2.0)
}

fun parseArgs(args: Array<String>): Arguments {
    if (args.size !in listOf(2, 4, 6, 8)) {
        throw Exception("usage: -in <input image> -out <output image> -width <width> -height <height>")
    }

    var inputFilename = ""
    var outputFilename = ""
    var width = 0
    var height = 0

    args.asList().chunked(2).forEach { arg ->
        val (k, v) = arg
        when (k) {
            "-in" -> inputFilename = v
            "-out" -> outputFilename = v
            "-width" -> width = v.toInt()
            "-height" -> height = v.toInt()
        }
    }

    return Arguments(inputFilename, outputFilename, width, height)
}

data class Arguments(
    val inputFilename: String, val outputFilename: String, val width: Int, val height: Int
)