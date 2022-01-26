fun compose(g: (Int) -> Int, h: (Int) -> Int): (Int) -> Int {
    return { x -> g(h(x)) }
}
