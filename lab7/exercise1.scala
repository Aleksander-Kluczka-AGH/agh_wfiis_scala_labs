object exercise1
{
    def main(args: Array[String]): Unit =
    {
        val input1 = "91051123891"

        val PESELExtr(year, month, day, sex) = input1
        println("year: " + year + ", month: " + month + ", day: " + day + ", gender: " + sex)

        val anotherinput = "91051123893"

        val PESELExtr(year2, month2, day2, sex2) = anotherinput
        println("year: " + year2 + ", month: " + month2 + ", day: " + day2 + ", gender: " + sex2)
    }

    case class PESELExtr(year: String, month: String, day: String, sex: String)

    object PESELExtr {
        def apply(year: String, month: String, day: String, sex: String): PESELExtr =
            new PESELExtr(year, month, day, sex)

        def unapply(pesel: String): Option[(String, String, String, String)] =
        {
            val weight: Array[Int] = Array(1, 3, 7, 9, 1, 3, 7, 9, 1, 3)
            val elements = pesel.dropRight(1).toCharArray.map(_.toInt).zipWithIndex.map
            {
                case (elem, i) => elem * weight(i)
            }.sum

            val checksum = (10 - (elements%10))%10
            if (checksum == pesel.charAt(10).asDigit)
                Some(pesel.substring(0, 2), pesel.substring(2, 4), pesel.substring(4, 6), if(pesel.substring(9, 10).toInt %2 == 0) "Female" else "Male")
            else None
        }
    }
}