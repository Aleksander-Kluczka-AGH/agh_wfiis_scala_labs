import scala.annotation.tailrec

object exercise1
{
    def main(args: Array[String]): Unit =
    {
        val filtered = filterList(List("Hello", "there", "people"), _.contains('p'))
        println(filtered)
        val reversed = reverseList(List("Hello", "there", "people"))
        println(reversed)
    }


    def filterList(list: List[String], cond: String => Boolean) : List[String] =
    {
        var result : List[String] = Nil

        @tailrec
        def fLhelp(target: List[String]) : Any =
        {
            if(target.isEmpty) return Nil
            if(cond(target.head)) result = result :+ target.head
            fLhelp(target.tail)
        }

        fLhelp(list)
        result
    }


    def reverseList(list: List[String]) : List[String] =
    {
        var result : List[String] = Nil

        @tailrec
        def temp(target : List[String]) : Any =
        {
            if(target.isEmpty) return Nil
            result = target.head :: result
            temp(target.tail)
        }

        temp(list)
        result
    }
}
