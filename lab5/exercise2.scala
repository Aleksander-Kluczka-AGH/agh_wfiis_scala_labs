abstract class Shape()
{
    var center : (Int, Int)
    var rotation : Int
    var size : Int
}

class Triangle() extends Shape
{
    override def toString: String = s"Triangle of side size $size rotation $rotation At $center"

    def this(center: (Int, Int), rotation: Int, size: Int) = this(center, rotation, size)
}

object Triangle
{
    def apply(center: (Int, Int), rotation: Int, size: Int): Triangle = new Triangle(center, rotation, size)

}

class Square() extends Shape
{
    override def toString: String = s"Square of size $size At $center"

    override var center: (Int, Int) = (0,0)
    override var rotation: Int = 0
    override var size: Int = 0
}

object Square
{
    def apply(center: (Int, Int), size: Int): Square = new Square(center, size)

}

trait color
{
    abstract var red : Int
    abstract var green : Int
    abstract var blue : Int
    var color : (Int, Int, Int) = (red, green, blue)
}

class ColorTriangle() extends Triangle with color
{
    override var color: (Int, Int, Int) = (0, 0, 0)
}

object ColorTriangle
{
    def apply(center: (Int, Int), rotation: Int, size: Int, color: (Int, Int, Int)): ColorTriangle =
        new ColorTriangle(center, rotation, size, color)
}

class ColorSquare() extends Square with color
{
    override var color: (Int, Int, Int) = (0, 0, 0)
}

object ColorSquare
{
    def apply(center: (Int, Int), size: Int, color: (Int, Int, Int)): ColorSquare =
        new ColorSquare(center, size, color)
}

object exercise2
{
    def main(args: Array[String]): Unit =
    {
        val a = ColorTriangle(center=(0,0), rotation=30, size=25, color=(20,20, 120))

        a.setColor(100,0,70)

        a.increaseRedBy(2.0) // czerwony = czerwony + czerwony*2

        val b = ColorSquare(center=(3,3), size=12, color=(20,20, 120) )

        b.setColor(10, 255, 0)

        b.decreaseGreenBy(0.3)

        // itd ...

        val shapes = List[Shape]( Triangle((0,0), 90, 50), a, Square((3,-3), 10), b )

        println(shapes.mkString("\n"))

        /* expected result

        Triangle of side size 50 rotation 90 At (0,0)

        Triangle of side size 25 rotation 30 At (0,0) with color r:255 g: 0 b: 70

        Square of size 10 At (3,-3)

        Square of size 12 At (3,3) with color r:10 g: 178 b: 0*/
    }
}
