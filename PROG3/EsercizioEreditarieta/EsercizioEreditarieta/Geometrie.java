
/* NB: definendo l'elenco di poligoni come ArrayList, anziche' array,
   si puo' realizzare l'elenco e gestirne l'ordinamento utilizzando
   i metodi offerti da ArrayList. Qui ho implementato tutto in modalita'
   "base" per chiarezza.
*/

public class Geometrie {

    public static final int TRIANGOLO = 1;
    public static final int RETTANGOLO = 2;
    public static final int PARALLELOGRAMMA = 3;

    private Poligono[] elementi;
    private int numElementi;

    public Geometrie(int num) { //costruttore
        numElementi = 0;
        elementi = new Poligono[num];
    }

    public int getNumElementi() {
        return numElementi;
    }

    public boolean add(int tipo, int b, int h) {
        boolean ris = false;
        if (numElementi < elementi.length) {
            Poligono p = null;
            switch (tipo) {
                case TRIANGOLO:
                    p = new Triangolo(b, h);
                    break;
                case RETTANGOLO:
				    p = new Rettangolo(b, h);
                    break;
                case PARALLELOGRAMMA:
                    p = new Parallelogramma(b, h);
                    break;
                default:
                    break;
            }
            boolean presente = false;
            for (int i = 0; i < numElementi && !presente; i++) {
                if (elementi[i].equals(p)) {
                    presente = true;
                }
            }
            if (!presente) {
                elementi[numElementi] = p;
                numElementi++;
                ris = true;
            }
        }
        return ris;
    }

    public void printAree() {
        for (int i = 0; i < numElementi; i++) {
            System.out.println("Area di: " + elementi[i].getClass() + ": " + elementi[i].getArea());
        }
    }

}

abstract class Poligono {

    private final int numV;
    private final int base;
    private final int altezza;

    public Poligono(int v, int base, int h) { //costruttore
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
        return numV + " - " + base + " - " + altezza;
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
        super(4, b, h);
    }

    public double getArea() {
        return getBase() * getAltezza();
    }

    public double getPerimetro() {
		return 2*(getBase() + getAltezza());
	}
}


class Parallelogramma extends Poligono {

    public Parallelogramma(int b, int h) { //costruttore
        super(4, b, h);
    }

    public double getArea() {
        return getBase() * getAltezza();
    }
}


class Triangolo extends Poligono {

    public Triangolo(int b, int h) { //costruttore
        super(3, b, h);
    }

    public double getArea() {
        return (double) getBase() * getAltezza() / 2; // occhio al cast a double per far fare la divisione con virgola!!
    }

}
