/**
  una versione di CiaoNome in cui l'input e l'output sono fatti
  non su consolle, bens� su finestre di dialogo, usando metodi
  statici della classe JOptionPane
*/

import javax.swing.JOptionPane;

public class JOptionPaneTest {

  public static void main(String[] args) {
    String nome = JOptionPane.showInputDialog("Come ti chiami?");
    int x=atoi(nome);
    JOptionPane.showMessageDialog(null, "Ciao, " + nome);
    System.exit(0);
  }
}
