fun bill(priceList: Map<String, Int>, shoppingList: MutableList<String>): Int {
    return shoppingList.sumOf { priceList[it] ?: 0 }
}
