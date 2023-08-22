object exercise1
{
    def main(args: Array[String]): Unit =
    {
        println(pi)
        println(pi(pi))
        println(pi(pi(pi)))
        println(repN(5,  (x: Int) => 2*x , 1 ))
        printarg(arg="hello") // hello
        printarg() // -
    }

    def repN(n: Int, func: Int=>Int, x: Int) : Int =
    {
        if(n == 0) x
        else repN(n-1, func, func(x))
    }

    def pi = 3.1415
    def pi(x: Double): Double = 3.1415*x
    def printarg() : Unit = println("-")
    def printarg(arg: String) : Unit = println(arg)
}
