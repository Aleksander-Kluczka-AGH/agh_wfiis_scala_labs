class Company(val name : String, val origin: String)
{
    override def toString: String = s"Company($name, $origin)"
}

object exercise2
{
    def getCompanies(value: List[Iterable[Serializable] with PartialFunction[String with Int, String] with Equals]) : List[Any] =
    {
        value.map{
            case company : Map[String, String] =>
            {
                if(company contains "company")
                    new Company(company("company"), company("origin"))
            }
            case _ =>
        }.filter(_.isInstanceOf[Company])
    }

    def main(args: Array[String]): Unit =
    {
        val data = List( Map("name" -> "Jan", "fname" -> "Kowalski", "age" -> "45"),

                         Map("company" -> "ABB", "origin" -> "Sweden"),

                         Map("name" -> "Katarzyna", "fname" -> "Nowak", "age" -> "45"),

                         Map("company" -> "F4", "origin" -> "Poland"),

                         List("Cos", "innego"),

                         Map("company" -> "Salina Bochnia", "origin" -> "Poland"),

                         Map("company" -> "AGH", "origin" -> "Poland"),

                         Map("name" -> "Krzysztof", "fname" -> "Krol", "age" -> "14")
                         )

        print(getCompanies(data))
    }
}
