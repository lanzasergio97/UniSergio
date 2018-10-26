import java.util.*;

public class GenTestCorretto {

    public static void main(String[] args) {
        Geometrie<Rettangolo> g = new Geometrie<Rettangolo>(new ArrayList<Rettangolo>());
        g.add(new Rettangolo(5, 5));
        g.add(new Rettangolo(3, 3));
        g.printAree();
        System.out.println();
        //g.add(new Triangolo(2, 3));//ora giustamente -> error: incompatible types: Triangolo cannot be converted to Rettangolo
        System.out.println("Numero di poligoni: " + g.getNumElementi());
        g.printAree();
        //Geometrie gWrong = new Geometrie(new ArrayList<String>());
        //g.add("ciao"); // error: incompatible types: String cannot be converted to Poligono
    }
}
