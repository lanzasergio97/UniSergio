import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// conta i beep

public class Beepernested extends JFrame {
   private JButton button = new JButton("Click Me");
   private JPanel panel = new JPanel();
   private JLabel display = new JLabel("0");
   private int i = 0;


   private class BeepListener implements ActionListener {

// poiché BeepListener è innestata in Beepernested riesce a vedere e
// modificare direttamente le sue variabili (i, display) quindi
// non serve definire metodi per gestirle, cosa che era nella versione iniziale.
       public void actionPerformed(ActionEvent e) {
         Toolkit.getDefaultToolkit().beep();
         i++;
         display.setText(Integer.toString(i));
      }
   } // end BeepListener


   Beepernested() {
      panel.add(display);
      panel.add(button);
      add(panel);
      button.addActionListener(new BeepListener());
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   }


   public static void main(String[] args) {
      Beeper beep = new Beeper();
      beep.pack();
      beep.setVisible(true);
   }



}