
object exercise2
{
    def main(args: Array[String]): Unit =
    {
        println(sumfrac(1e-3))
        println(sumfrac(1e-9))
    }

    def sumfrac(precision: Double) : Double =
    {
        @scala.annotation.tailrec
        def frac(now: Double, result: Double = 0): Double =
        {
            val newRes : Double = result+now
            if(now > precision) frac(now * 0.5, newRes)
            else newRes
        }
        frac(now = 1.0)
    }
}
