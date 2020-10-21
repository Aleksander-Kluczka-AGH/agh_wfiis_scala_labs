import scala.util.Random
object main {
  def main(args: Array[String]): Unit = {
    exercise_1(args)
    exercise_2()
  }

  def exercise_1(args: Array[String]):Unit={
    if(args.isEmpty)
      println(Range(1, 50).toVector)
    else {
      val x = for {y: Int <- 1 to args(0).toInt if !math.sqrt(y).isWhole} yield y
      println(x)
    }

  }

  def exercise_2() : Unit = {
    val N = 100000000
    println(4.0* (countInside(generateSequence(N)) / N.toDouble) )
  }

  val generator = new Random()
  def generatePoint():(Double, Double) = (generator.nextDouble, generator.nextDouble)

  def generateSequence(N : Int) : IndexedSeq[(Double, Double)] = for {i: Int <- 1 to N} yield generatePoint()

  def isInCircle(x : (Double, Double)) : Boolean = math.sqrt(x._1*x._1 + x._2*x._2) < 1.0

  def countInside(x : IndexedSeq[(Double, Double)]) : Int ={
    var count : Int = 0
    for{point <- x if isInCircle(point)} {
      count = count + 1
    }
    count
  }
}
