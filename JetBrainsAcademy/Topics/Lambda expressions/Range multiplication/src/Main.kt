val lambda: (Long, Long) -> Long = { left, right -> (left..right).reduce { acc, l -> acc * l } }
