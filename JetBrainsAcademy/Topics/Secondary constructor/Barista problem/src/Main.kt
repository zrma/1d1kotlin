// write the EspressoMachine class here
class EspressoMachine {
    var costPerServing = 0f

    constructor(coffeeCapsulesCount: Int, totalCost: Float) {
        costPerServing = totalCost / coffeeCapsulesCount
    }

    constructor(coffeeBeansWeight: Float, totalCost: Float) {
        costPerServing = (totalCost / coffeeBeansWeight) * 10
    }
}
