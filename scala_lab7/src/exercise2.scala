object exercise2
{
    def main(args: Array[String]): Unit =
    {
        class TwistedMonoPair[+T](val arg: T, val arg2: T)
        {
            def replace[T](i: Int): T = 
        }

        object TwistedMonoPair
        {
            def apply[T](input: T, input2: T): TwistedMonoPair[T] = new TwistedMonoPair[T](input, input2)

        }

        class A{
            override def toString: String = "A"
        }


        class B( val x: Int) extends A{
            override def toString: String = "B:"+ x.toString
        }


        class C( x: Int) extends B(x){
            override def toString: String = "C:"+x.toString
        }


        val a: TwistedMonoPair[A] = TwistedMonoPair[A](new B(7), new A)

        println(a(0))

        println(a(1))

        println(a)

        val b: TwistedMonoPair[A] = TwistedMonoPair[B](new B(9), new C(77)) // covariantnes

        println(b)

        // val c: TwistedMonoTuple[A] = new TwistedMonoTuple[B](new B(9), new A) // should not compile, covariantness


        val d1 = b.replace(0)(new A) // conversion to TwistedMonoPair[A] and replacement of the first el. in the pair

        println(d1)

        val tA : TwistedMonoPair[A] = d1

        //val tB : TwistedMonoPair[B] = d1// can not compile

        val d2 = b.replace(1)(new A) // as above, but replaced is the second el

        println(d2)
    }
}
