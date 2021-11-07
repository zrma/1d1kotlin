const val NO_ARMY = 0
const val FEW = 4
const val SEVERAL = 9
const val PACK = 19
const val LOTS = 49
const val HORDE = 99
const val THRONG = 249
const val SWARM = 499
const val ZOUNDS = 999

fun main() {
    println(
        when (readLine()!!.toInt()) {
            in Int.MIN_VALUE..NO_ARMY -> "no army"
            in NO_ARMY.inc()..FEW -> "few"
            in FEW.inc()..SEVERAL -> "several"
            in SEVERAL.inc()..PACK -> "pack"
            in PACK.inc()..LOTS -> "lots"
            in LOTS.inc()..HORDE -> "horde"
            in HORDE.inc()..THRONG -> "throng"
            in THRONG.inc()..SWARM -> "swarm"
            in SWARM.inc()..ZOUNDS -> "zounds"
            else -> "legion"
        }
    )
}
