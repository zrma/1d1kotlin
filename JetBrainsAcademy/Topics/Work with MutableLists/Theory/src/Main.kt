fun main() {
    val southernCross = mutableListOf("Acrux", "Gacrux", "Imai", "Mimosa")
    println(southernCross.joinToString()) //  Acrux, Gacrux, Imai, Mimosa
    println(southernCross.joinToString(" -> ")) //  Acrux -> Gacrux -> Imai -> Mimosa

    val stars = mutableListOf("Ginan", "Mu Crucis")

    val newList = southernCross + stars
    println(newList.joinToString()) //  Acrux, Gacrux, Imai, Mimosa, Ginan, Mu Crucis

    val firstList = mutableListOf("result", "is", "true")
    val secondList = mutableListOf("result", "is", "true")
    val thirdList = mutableListOf("result")

    println(firstList == secondList) //  true
    println(firstList == thirdList) //  false
    println(secondList != thirdList) //  true

    southernCross[1] = "star"
    stars[1] = "star"

    println(southernCross[1]) // star
    println(stars[1]) // star

    southernCross.removeAt(0)
    southernCross.remove("Mimosa")

    stars.add("New star")
    stars.add(0, "First star")

    val names = mutableListOf("Jack", "John", "Katie")
    val food = mutableListOf("Bread", "Cheese", "Meat")
    val fruits = mutableListOf("Apple", "Banana", "Grape", "Mango")

    names.clear()

    food.addAll(fruits)

    println(names) // []
    println(southernCross.joinToString()) // star, Imai
    println(stars.joinToString()) // First star, Ginan, star, New star
    println(food.joinToString()) // Bread, Cheese, Meat, Apple, Banana, Grape, Mango

    val vowels = mutableListOf('a', 'o', 'i', 'e', 'u')
    val intList1 = mutableListOf(1, 2, 3, 4, 5)
    val intList2 = mutableListOf(5, 4, 3, 2, 1)

    vowels += 'y'
    intList1 += intList2

    println(vowels) // [a, o, i, e, u, y]
    println(intList1) // [1, 2, 3, 4, 5, 5, 4, 3, 2, 1]

    val list = mutableListOf(1, 2, 3, 4, 5)
    val copyList = list.toMutableList()

    println(copyList) // [1, 2, 3, 4, 5]

    val list2 = mutableListOf(1, 2, 3, 4, 5)
    val copyList2 = mutableListOf<Int>()
    copyList2.addAll(list2)

    println(copyList2) // [1, 2, 3, 4, 5]

    val numbers = mutableListOf(1, 2, 3, 4, 5)
    var sublist = mutableListOf<Int>()
    @Suppress("KotlinConstantConditions")
    if (numbers.isNotEmpty() && numbers.size >= 4) {
        sublist = numbers.subList(1, 4)
    }

    print(sublist) // [2, 3, 4]

    if (5 in numbers) {
        println(numbers.indexOf(5)) // 4
    }
    print(numbers.indexOf(7)) // -1

    println(numbers.minOrNull()) // 1
    println(numbers.maxOrNull()) // 5
    println(numbers.sum()) // 15

    println(vowels.sorted()) // [a, e, i, o, u, y]
    println(vowels.sortedDescending()) // [y, u, o, i, e, a]
}
