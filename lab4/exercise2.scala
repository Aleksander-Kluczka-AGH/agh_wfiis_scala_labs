object MapPoint
{
    def apply(name: String, longitude: Double, latitude: Double) : MapPoint =
        new MapPoint(name, longitude, latitude)

    def inTheMiddle(one: MapPoint, two: MapPoint, newName: String) : MapPoint =
        MapPoint(newName, (one.longitude+two.longitude)/2.0, (one.latitude+two.latitude)/2.0)

    class MapPoint(val name : String, val longitude : Double, val latitude : Double)
    {
        override def toString: String =
        {
            val symLong : String = if(this.longitude >= 0) "N" else "S"
            val symLat : String = if(this.latitude >= 0) "E" else "W"
            name+"("+longitude+symLong+", "+math.abs(latitude)+symLat+")"
        }
        def -(minus: MapPoint): Double =
            math.sqrt(math.pow(this.longitude-minus.longitude, 2.0)+math.pow(this.latitude-minus.latitude, 2.0))

        def distanceTo(target: MapPoint) : Double = target - this

        def +(other: MapPoint) : String = this.toString + other.toString

        def move(shiftLon: Double, shiftLat: Double) : MapPoint =
            MapPoint("Nearby "+this.name, this.longitude+shiftLon, this.latitude+shiftLat)

    }
}

object Route
{
    import MapPoint.MapPoint
    def apply(one : MapPoint, two : MapPoint, three : MapPoint) = new Route(one, two, three)

    class Route(one : MapPoint, two : MapPoint, three : MapPoint)
    {
        var stops : Array[MapPoint] = Array.empty
        override def toString: String =
        {
            if(stops.isEmpty) three + " -> " + two + " -> " + one
            else stops.mkString("", " -> ", " -> ") + three + " -> " + two + " -> " + one
        }
        def addStop(target: MapPoint) : Unit = stops = stops :+ target

    }
}

object zad extends App {

        val krk = MapPoint( "Krakow", 50.061389, 19.938333 );

        println( krk );

        val nyc = MapPoint( "NYC", 40.7127, -74.0059 );

        println( nyc );

        val porto = MapPoint( "Porto", 41.162142, -8.621953 );

        val irkutsk = MapPoint( "Irkutsk",  52.283333, 104.283333 );

        println( irkutsk );


        println( porto - irkutsk )

        println( krk - irkutsk )

        println( krk.distanceTo(porto) )


        /*val mp = inTheMiddle( krk,  irkutsk, "Somewhere in Russia" );

        println( mp+" "+( mp - krk ) +" "+ ( mp - irkutsk ) )*/


        val r = Route( krk, nyc, porto )

        println( r );

        r.addStop( porto.move( 1, 1 ) )

        r.addStop( irkutsk )

        println( r )

}