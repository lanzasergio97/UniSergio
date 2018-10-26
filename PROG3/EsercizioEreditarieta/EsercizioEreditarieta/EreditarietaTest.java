
public class EreditarietaTest {

    public static void main(String[] args) {
        Geometrie g = new Geometrie(4);
        g.add(Geometrie.RETTANGOLO, 5, 5);
        g.add(Geometrie.TRIANGOLO, 5, 5);
        g.add(Geometrie.TRIANGOLO, 5, 5);
        g.printAree();
        System.out.println();
        g.add(Geometrie.PARALLELOGRAMMA, 2, 3);
        g.add(Geometrie.TRIANGOLO, 4, 4);
        System.out.println("Numero di poligoni: " + g.getNumElementi());
        g.printAree();
    }
}
