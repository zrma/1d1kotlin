fun main() {
    val array2DRectangle = arrayOf(
        arrayOf(0, 0, 0, 0),
        arrayOf(0, 0, 0, 0),
        arrayOf(0, 0, 0, 0)
    )
    println(array2DRectangle)

    val array2DNotRectangle = arrayOf(
        arrayOf(0),
        arrayOf(1, 2),
        arrayOf(3, 4, 5)
    )
    println(array2DNotRectangle)

    val empty2DInt = arrayOf<Array<Int>>()
    println(empty2DInt)

    val array2D = arrayOf(
        arrayOf(0, 1, 2),   // [0]
        arrayOf(3, 4, 5)    // [1]
    )
    print(array2D[0][0])  // 0
    print(array2D[0][1])  // 1
    print(array2D[0][2])  // 2
    print(array2D[1][0])  // 3
    print(array2D[1][1])  // 4
    print(array2D[1][2])  // 5

    val arrayOfString2D = arrayOf(
        arrayOf("to", "be", "or"),
        arrayOf("not", "to", "be")
    )
    println(arrayOfString2D)

    val arrayOfMixed2D = arrayOf(
        arrayOf("Practice", "makes", "perfect"),
        arrayOf(1, 2)
    )
    println(arrayOfMixed2D)

    val arrayString = arrayOf(
        arrayOf("A", "R", "R", "A", "Y")
    )
    print(arrayString[0].joinToString())    // A, R, R, A, Y

    val arrayOfChar2D = arrayOf(
        charArrayOf('k'),
        charArrayOf('o', 't'),
        charArrayOf('l', 'i', 'n')
    )

    println(arrayOfChar2D.contentDeepToString())    // [[k], [o, t], [l, i, n]]

    val array3D = arrayOf(
        arrayOf(arrayOf(0, 1), arrayOf(2, 3)),
        arrayOf(arrayOf(4, 5), arrayOf(6, 7))
    )

    println(array3D.contentDeepToString())  // [[[0, 1], [2, 3]], [[4, 5], [6, 7]]]

    println(array3D[0][0][1])   // 1
    println(array3D[1][0][1])   // 5
    println(array3D[1][1][1])   // 7
}
