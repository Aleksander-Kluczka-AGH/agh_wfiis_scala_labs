//Food, Carrot, Rabbit, Wolf, Meat, Plants, Animal
object exercise1
{
    trait Food
    {
        override def toString: String = "Food"
    }
    trait Plants extends Food
    {
        override def toString: String = "Plants"
    }
    class Carrot extends Plants
    {
        override def toString: String = "Carrot"
    }
    trait Meat extends Food
    {
        override def toString: String = "Meat"
    }

    abstract class Animal
    {
        type EatingType <: Food
        def eat(food: EatingType) : Unit
        override def toString: String = "Animal"
    }

    class Rabbit extends Animal with Meat
    {
        override type EatingType = Plants
        override def eat(food: EatingType) : Unit = println(s"Rabbit crunches the $food")
        override def toString: String = "Rabbit"
    }

    class Wolf extends Animal
    {
        override type EatingType = Meat
        override def eat(food: EatingType) : Unit = println(s"Wolf tears apart the $food")
        override def toString: String = "Wolf"
    }

    def main(args: Array[String]): Unit =
    {
        val c: Plants = new Carrot

        val r = new Rabbit

        val w = new Wolf

        // this two shold compile and run w/o problems

        r.eat(c)

        w.eat(r)
        // whereas these should not compile

//        r.eat(r)
//
//        w.eat(c)
    }
}
