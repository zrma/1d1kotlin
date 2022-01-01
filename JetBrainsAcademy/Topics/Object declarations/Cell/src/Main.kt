class Cell {
    object BaseProperties {
        var width = 10
        var height = 10
    }
    var width: Int
    init {
        width = BaseProperties.width
    }
    var height: Int
    init {
        height = BaseProperties.height
    }
}
