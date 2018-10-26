import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Beeper1 extends JFrame {
   private JPanel panel;
   private JButton button;

// BeepListener è innestata per
// nascondere i tipi che non servono al di fuori della classe principale
// ed eventualmente per accedere a dati del contenitore (outerThis)
   private class BeepListener implements ActionListener {
   	public void actionPerformed(ActionEvent e) {
      Toolkit.getDefaultToolkit().beep();
      System.out.println("BEEEEPPPP!!!!!");
      System.out.println("Il command del bottone è: " + e.getActionCommand());
   	}
   }


   private Beeper1() {
	  super("Test listener");
      panel = new JPanel();
      add(panel);
      button = new JButton("Click Me");
      panel.add(button);
      pack();
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      button.addActionListener(new BeepListener());
      setVisible(true);
   }

   public static void main(String[] args) {
      Beeper1 beep = new Beeper1();
   }
}
