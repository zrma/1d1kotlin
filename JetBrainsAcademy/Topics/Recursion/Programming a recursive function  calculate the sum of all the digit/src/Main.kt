fun digitSum(n: Int): Int {
  return if (n < 10) n else n % 10 + digitSum(n / 10)
}
