//
//- Print list of females and list of males.
//
//- Obtain names of all people of age above 23.
//
//- Check if among the people on the list there is someone of name Joe and John.
//
//- Check if everyone is older than 20.
//
//- Obtain a list of First names and age.
//
//- Group all people by age.
//
//- Split the list of people into younger and older than 23.
//
//- Find the oldest and youngest.
//
//- In a single set of transformations check if the number of males and females in the list is identical.
//
//- Obtain a sorted list of people of age above 23 with dropWhile and sort.object
object exercise2
{
    def main(args: Array[String]): Unit =
    {
        val people = List( ("John", "Doe", 23, "male"),
                           ("Joan", "Doe", 23, "female"),
                           ("Steve", "Jenkins", 24, "male"),
                           ("Eva", "Robinson", 25, "female"),
                           ("Ben", "Who", 22, "male"),
                           ("Janet", "Reed", 21, "female"),
                           ("Rob", "Jenkins", 26, "male"),
                           ("Ella", "Dawson", 27, "female") )

        println("Males: " + people.filter(_._4 == "male").mkString("\n", "\n", "\n"))
        println("Females: " + people.filter(_._4 == "female").mkString("\n", "\n", "\n"))
        println("Any of age > 23: " + people.filter(_._3 >= 23).mkString("\n", "\n", "\n"))
        println("Any John or Joe? : " + (people.exists(_._1 == "John") || people.exists(_._1 == "Joe")) + "\n")
        println("Everyone of age > 20? : " + people.forall(_._3 > 20) + "\n")
        println("(Name, Age): " + people.map(entry => (entry._1, entry._3)).mkString("\n", "\n", "\n"))
        println("Grouped by age: " + people.groupBy(entry => entry._3).mkString("\n", "\n", "\n"))
        val (younger, older) = people.partition(entry => entry._3 < 23)
        println("Younger than 23: " + younger.mkString("\n", "\n", "\n"))
        println("Older than 23: " + older.mkString("\n", "\n", "\n"))
        println("Youngest: " + people.minBy(_._3) + "\n")
        println("Oldest: " + people.maxBy(_._3) + "\n")
        println("Equal number of females and males? : " +
                  (people.count(entry => entry._4 == "male") == people.count(entry => entry._4 == "female")) + "\n")

        println("Sorted list of people above 23: " + people.dropWhile(entry => entry._3 <= 23).sortBy(_._3).mkString("\n", "\n", "\n"))
    }
}
