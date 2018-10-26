import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Posso far implementare ActionListener direttamente al Beeper2
// per non creare classe separata (interna)
public class Beeper2JFrameListener extends JFrame implements ActionListener{
   private BeeperButton button;
   private JPanel panel;

	private class BeeperButton extends JButton {
		private BeeperButton(String s) {
			super(s);
		}

	}


   public Beeper2JFrameListener() {
      panel = new JPanel();
      add(panel);
      button = new BeeperButton("Click Me");
      panel.add(button);
      pack();
      button.addActionListener(this); // aggiunge action listener al bottone
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }

   public void actionPerformed(ActionEvent e) {
         		Toolkit.getDefaultToolkit().beep();
         		System.out.println("BEEP!");
   		}

   public static void main(String[] args) {
      Beeper2JFrameListener beep = new Beeper2JFrameListener();
      beep.setVisible(true);
   }
}
