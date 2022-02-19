fun main() {
    val stringArray0 = arrayOf("array", "of", "strings")
    println(stringArray0)

    val newEmptyArray0 = emptyArray<String>()
    println(newEmptyArray0)

    val stringArray = arrayOf("sagacity", "and", "bravery")
    print(stringArray[2]) // bravery

    stringArray[0] = "smart"
    print(stringArray[0]) // smart

    val southernCross = arrayOf("Acrux", "Gacrux", "Im-ai", "Mimosa")
    println(southernCross.joinToString()) // Acrux, Gacrux, Im-ai, Mimosa

    val stars = arrayOf("Gi-nan", "Mu Cru-cis")
    val newArray = southernCross + stars
    println(newArray.joinToString()) //  Acrux, Gacrux, Im-ai, Mimosa, Gi-nan, Mu Cru-cis

    val firstArray = arrayOf("result", "is", "true")
    val secondArray = arrayOf("result", "is", "true")
    val thirdArray = arrayOf("result")

    println(firstArray.contentEquals(secondArray)) //  true
    println(firstArray.contentEquals(thirdArray)) //  false

    val southernCross1 = arrayOf("Acrux", "Gacrux", "Im-ai", "Mimosa")
    southernCross1[1] = "star"

    @Suppress("CanBeVal") var stars1 = arrayOf("Gi-nan", "Mu Cru-cis")
    stars1[1] = "star"

    println(southernCross[1]) // star
    println(stars[1]) // star

    var southernCross2 = emptyArray<String>()
    southernCross2 += "Acrux"
    southernCross2 += "Gacrux"
    southernCross2 += "Im-ai"
    println(southernCross.joinToString()) // Acrux, Gacrux, Im-ai

    var southernCross3 = arrayOf("Acrux", "Gacrux", "Im-ai")
    southernCross3 += "Mimosa"
    println(southernCross3.joinToString()) //  Acrux, Gacrux, Im-ai, Mimosa

    // val southernCross = arrayOf("Acrux", "Gacrux", "Im-ai", "Mimosa")
    // southernCross += "Gi-nan" // will not compile
}
