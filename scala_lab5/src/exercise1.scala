class Complex(val Re: Double, val Im: Double)
{
    override def toString: String = "Re:{"+Re+"} Im:{"+Im+"}"
    def +(target: Complex) : Complex = Complex(Re+target.Re, Im+target.Im)
    def -(target: Complex) : Complex = Complex(Re-target.Re, Im-target.Im)
    val r : Double = math.sqrt((Re*Re) + (Im*Im))
    val angle : Double = (Re.abs/Re)*math.asin(Im/r)
}

object Complex
{
    def apply(Re: Double, Im: Double): Complex = new Complex(Re, Im)
    def polar(r: Double, angle: Double): Complex = Complex(r*math.cos(angle), r*math.sin(angle))
}

object exercise1
{
    def main(args: Array[String]): Unit =
    {
        val x = Complex(1,2)

        val y = Complex(3,2)

        println("x " + x + " y " + y + " x+y " +(x+y) + " x-y " +(x-y))

        val f = Complex.polar(r=3, angle=math.Pi)

        println(f)

        println( "|x| "+ x.r + " angle " +x.angle)
    }
}
