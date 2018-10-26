
import java.util.*;

public class Geometrie <T extends Poligono> {

    private List<T> elementi;

    // NB: siccome non si possono aggiungere oggetti Rettangolo etc. a un ArrayList<T>, dobbiamo dare la versione
    // con Information Leak, in cui il costruttore prende direttamente l'array di T come parametro.
    public Geometrie(ArrayList<T> elementi) { //costruttore
        this.elementi = elementi;
    }

    public int getNumElementi() {
        return elementi.size();
    }

    public boolean add(T el) {
        if (elementi.contains(el)) {
			return false;
		}
		else {
			elementi.add(el);
			return true;
		}
	}

    public void printAree() {
        for (T el : elementi) {
            System.out.println("Area: " + el.getArea());
        }
    }

}

abstract class Poligono {

    private final int numV;
    private final int base;
    private final int altezza;

    private final String tipo;

    public Poligono(String tipo, int v, int base, int h) { //costruttore
    	this.tipo = tipo;
        numV = v;
        this.base = base;
        altezza = h;
    }

    public int getNumVertici() {
        return numV;
    }

    // non definsco setNumVertici() per impedire di cambiare il numero di vertici di un oggetto dopo la sua creazione
    public int getBase() {
        return base;
    }

    public int getAltezza() {
        return altezza;
    }

    public abstract double getArea(); // ogni sottoclasse implementa il suo algoritmo di calcolo area


    /* commentando il metodo toString(), nelle System.out.println()
(e in tutti i metodi che usano toString()) va in esecuzione
il metodo toString() della classe Object.
     */
    public String toString() {
        return tipo + ": " + numV + " - " + base + " - " + altezza;
    }

    public boolean equals(Object o) {
        boolean ris = false;
        if (o != null && this.getClass() == o.getClass()) {
            Poligono a = (Poligono) o;
            ris = (this.base == a.base && this.altezza == a.altezza);
        }
        return ris;
    }

}

class Rettangolo extends Poligono {

    public Rettangolo(int b, int h) { //costruttore
        super("rettangolo", 4, b, h);
    }

    public double getArea() {
        return getBase() * getAltezza();
    }

    public double getPerimetro() {
		return 2*(getBase() * getAltezza());
	}
}

class Triangolo extends Poligono {

    public Triangolo(int b, int h) { //costruttore
        super("triangolo", 3, b, h);
    }

    public double getArea() {
        return (double) getBase() * getAltezza() / 2; // occhio al cast a double per far fare la divisione con virgola!!
    }

}
