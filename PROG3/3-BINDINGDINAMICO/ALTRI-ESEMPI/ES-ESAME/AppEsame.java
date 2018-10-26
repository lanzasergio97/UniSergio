class A {
	public void m(A a) {
		System.out.println("m_A");
	}
}

class B extends A {
	public void m(A a) {
		super.m(a); System.out.println("m_BA");
	}

	public void m(B b) {
			//m(b); //loop !!
			//super.m(b);
			m((A)b); System.out.println("m_BB");
	}

	public void m(A a, B b) {
			super.m(a);
			//m(b);
			System.out.println("m_XX");
	}
}

public class AppEsame {
    public static void main(String[] args) {
		A a = new A();
		a.m(a); System.out.println(); // stampa m_A
		B b = new B();
		b.m(b); System.out.println(); // stampa m_A m_BA m_BB
		a.m(b); System.out.println(); // m_A
		b.m(a); System.out.println(); // m_A m_BA
		b.m(a, b); // m_A m_XX
	}
}