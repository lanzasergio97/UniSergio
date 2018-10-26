import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

// visualizza a video lo stato del conto corrente su finestra separata rispetto a quella che permette di versare soldi sul conto;
public class ObserverContoApp1 {

	public static void main(String[] args) {
		ContoBancario cb = new ContoBancario();
      	FinestraConto f = new FinestraConto(cb);
      	GestisciOperazioni v = new GestisciOperazioni(cb);
      	cb.addObserver(f); // aggiunge l'osservatore all'oggetto Observable ContoBancario
   	}
}


class ContoBancario extends Observable {
	private int saldo = 0;

   	public void prelievo(int val) {
		saldo -= val;
      	setChanged();
      	notifyObservers();
   	}

   	public void versamento(int val) {
		saldo += val;
      	setChanged();
      	notifyObservers();
   	}

   	public int getSaldo() {
		return saldo;
   	}
}



class FinestraConto extends JFrame implements Observer {
	private JLabel display;
   	private ContoBancario cb;

   public FinestraConto(ContoBancario conto) {
	   	cb = conto;
      	display = new JLabel();
		display.setText("Saldo = " + cb.getSaldo());
      	add(display);
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	setSize(200,100);
      	setVisible(true);
   }

   public void update(Observable ob, Object extra_arg) { // siccome FinestraConto conosce cb non usa i parametri di input...
	   	display.setText("Saldo = " + cb.getSaldo());
   }
}



class GestisciOperazioni extends JFrame {
	private JButton button;
   	private JTextField inputVal;
   	private JPanel panel;
   	private ContoBancario cb;

   	public GestisciOperazioni(ContoBancario conto) {
		cb = conto;
      	panel = new JPanel();
      	add(panel);

      	button = new JButton("Versa");
      	panel.add(button);
      	button.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
				   						int val = Integer.parseInt(inputVal.getText());
			      						cb.versamento(val);
   									}
									});
      	inputVal = new JTextField("0", 8);
      	panel.add(inputVal);

      	setLocation(100,100);
      	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      	setSize(200,100);
      	setVisible(true);

   	}
}