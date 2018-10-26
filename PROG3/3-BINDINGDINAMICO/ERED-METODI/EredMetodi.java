
class C
{	void stampaTipo() {System.out.println("A");}
	void stampa() {stampaTipo();}
}

class D extends C
{	void stampaTipo() {System.out.println("B");}
}

public class EredMetodi {
	public static void main(String[] args)
	{	D d = new D();
		d.stampa(); // stampa "B"
	}
}
