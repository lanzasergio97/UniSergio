import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Beeper4ButtonListenerConAdapter extends JFrame {
   private BeeperButton button;
   private JPanel panel;


// Notare che il bottone � listener di se stesso, cio� contiene
// il listener per gestire gli eventi che genera.
	private class BeeperButton extends JButton implements ActionListener {
		private BeeperButton(String s) {
			super(s);
	  		addActionListener(this); // aggiunge action listener a se stesso
		}
		public void actionPerformed(ActionEvent e) {
      		Toolkit.getDefaultToolkit().beep();
      		System.out.println("BEEP!");
   		}
	}

	private class WL extends WindowAdapter {
   		public void windowClosing(WindowEvent e) {
			System.exit(0); //termina l'esecuzione
   		}
   	}


   public Beeper4ButtonListenerConAdapter() {
      panel = new JPanel();
      add(panel);
      button = new BeeperButton("Click Me");
      panel.add(button);
      pack();
      //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // sostituisco con listener
      addWindowListener(new WL());
   }

   public static void main(String[] args) {
      Beeper4ButtonListenerConAdapter beep = new Beeper4ButtonListenerConAdapter();
      beep.setVisible(true);
   }
}
