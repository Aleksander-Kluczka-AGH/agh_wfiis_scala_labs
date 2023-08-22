abstract class Ingriedient
{
    def content : List[String]
    //abstract override def content : List[String] = super.content++List(s"${classOf[this.type]}")
    def price() : Double
}

class Sandwitch extends Ingriedient
{
    override def content = List("Sandwitch")
    override def price() : Double = 1.0
}

trait Butter extends Ingriedient
{
    abstract override def price() : Double = super.price + 3.0
    abstract override def content: List[String] = super.content++List("Butter")
}

trait Salad extends Ingriedient
{
    abstract override def price() : Double = super.price + 9.0
    abstract override def content: List[String] = super.content++List("Salad")
}

trait Egg extends Ingriedient
{
    abstract override def price() : Double = super.price + 1.2
    abstract override def content: List[String] = super.content++List("Egg")
}

trait Mayonaise extends Ingriedient
{
    abstract override def price() : Double = super.price + 6.8
    abstract override def content: List[String] = super.content++List("Mayonaise")
}

trait Ham extends Ingriedient
{
    abstract override def price() : Double = super.price + 14.0
    abstract override def content: List[String] = super.content++List("Ham")
}

class ChefsBest extends Sandwitch with Butter with Salad with Ham

object exercise1
{
    def main(args: Array[String]): Unit =
    {
        val myLunch =  new Sandwitch with Butter with Salad with Egg with Mayonaise

        val yourLunch = new Sandwitch with Ham

        val chefLunch = new ChefsBest

        println(myLunch.price) // 5.5 exact number are not relevant of course
        println(myLunch.content) // results in List[Sandwitch, Butter, Salad Egg, Mayonaise]

        println(yourLunch.price)
        println(yourLunch.content)

        println(chefLunch.price)
        println(chefLunch.content)
    }
}
