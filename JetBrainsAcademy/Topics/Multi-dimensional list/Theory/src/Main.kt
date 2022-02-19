fun main() {
    val mutList2D0 =
        mutableListOf(
            mutableListOf(0, 0, 0, 0),
            mutableListOf(0, 0, 0, 0),
            mutableListOf(0, 0, 0, 0)
        )
    println(mutList2D0)

    val mutList2D1 = mutableListOf(mutableListOf(0), mutableListOf(1, 2), mutableListOf(3, 4, 5))
    println(mutList2D1)

    val mutList2D2 =
        mutableListOf(
            mutableListOf(0, 1, 2), // [0]
            mutableListOf(3, 4, 5) // [1]
        )
    println(mutList2D2)
    print(mutList2D2[0][0]) // 0
    print(mutList2D2[0][1]) // 1
    print(mutList2D2[0][2]) // 2
    print(mutList2D2[1][0]) // 3
    print(mutList2D2[1][1]) // 4
    print(mutList2D2[1][2]) // 5

    val mutListOfString2D0 =
        mutableListOf(mutableListOf("to", "be", "or"), mutableListOf("not", "to", "be"))
    val mutListOfChar2D0 = mutableListOf(mutableListOf('A', 'R', 'R'), mutableListOf('A', 'Y', 'S'))
    println(mutListOfString2D0)
    println(mutListOfChar2D0)

    val mutListOfStringAndInt2D =
        mutableListOf(mutableListOf("Practice", "makes", "perfect"), mutableListOf(1, 2))
    println(mutListOfStringAndInt2D)

    val mutListString = mutableListOf(mutableListOf("A", "R", "R", "A", "Y"))
    print(mutListString[0].joinToString()) // A, R, R, A, Y

    val mutListOfChar2D =
        mutableListOf(mutableListOf('k'), mutableListOf('o', 't'), mutableListOf('l', 'i', 'n'))
    println(mutListOfChar2D) // [[k], [o, t], [l, i, n]]

    val mutList3D =
        mutableListOf(
            mutableListOf(mutableListOf(0, 1), mutableListOf(2, 3)),
            mutableListOf(mutableListOf(4, 5), mutableListOf(6, 7))
        )
    println(mutList3D) // [[[0, 1], [2, 3]], [[4, 5], [6, 7]]]
    println(mutList3D[0][0][1]) // 1
    println(mutList3D[1][0][1]) // 5
    println(mutList3D[1][1][1]) // 7
}
