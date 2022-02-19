fun composition(value: Int, y: (Int) -> Int, g: (Int) -> Int): Int {
    return y(g(value))
}
