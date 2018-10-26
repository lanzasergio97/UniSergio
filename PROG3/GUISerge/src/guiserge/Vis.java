/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guiserge;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
/**
 *
 * @author Calculos
 */
public class Vis extends JFrame{
     
   private JButton button;


} 


class MenuFrame extends JFrame implements ActionListener {
    
		private JTextArea testo;
	private JTextArea risultato;

	private Esercizio[] esercizi;
	private int scelta;


	public MenuFrame(String name) {
             esercizi = new Esercizio[3];
		esercizi[0] = new Esercizio("es1", "Calcola la radice quadrata di 9", 3);
		esercizi[1] = new Esercizio("es2", "Calcola la radice quadrata di 16", 4);
		esercizi[2] = new Esercizio("es3", "Calcola la radice quadrata di 25", 5);
		scelta = 0;

            JMenuBar bar = new JMenuBar();
		add(bar);
		JMenu operazione = new JMenu(name);
		bar.add(operazione);
              setLayout(new GridLayout(3, 2, 20, 50));
		for (int i=0; i<esercizi.length; i++) {
			operazione.add(new MyJMenuItem(esercizi[i].getTitolo()));
		}
                testo = new JTextArea("Testo dell'esercizio.");
		testo.setEditable(false);
		testo.setBackground(Color.BLUE);
		testo.setForeground(Color.WHITE);
                add(testo);
                risultato = new JTextArea("");
		
		risultato.setForeground(Color.WHITE);
                JMenu ex = new JMenu("Se vuoi inserire il risultato digita qui sopra: ");
                add(risultato);
                JButton bel=new JButton("Risultato");
                	bel.addActionListener(this);
                ex.add( bel);
		bar.add(ex);
                
		                

		setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
                 
            
       
		

	}
        public class MyJMenuItem extends JMenuItem{

        public MyJMenuItem(String Sassi) {
            super(Sassi);
            	addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        String es = e.getActionCommand();
                        for (int i=0; i<esercizi.length; i++) {
                            if (es.equals(esercizi[i].getTitolo()))
				scelta = i;
			}
				testo.setText(esercizi[scelta].getTesto());
                                risultato.setBackground(Color.BLUE);
                    
                    }
                
                });
            //
        
        }
            
        }
        public void actionPerformed(ActionEvent e) {
		int val = 0;
		try {
			val = Integer.parseInt(risultato.getText());
		} catch (Exception ecc) {System.out.println(ecc.getMessage());
								 val = -1;}
		if (val == esercizi[scelta].getRisultato()) {
			JOptionPane.showMessageDialog(this, "OK");
			System.out.println("OK!!");
		}
		else {
			JOptionPane.showMessageDialog(this, "ERRORE");
			System.out.println("ERRORE!!");
		}

    }
          
        class Esercizio {
            private String titolo;
            private String testo;
            private int risultato;

            public Esercizio(String tit, String t, int r) {
                    titolo = tit;
                    testo = t;
                    risultato = r;
            }

            public String getTesto() {
                    return testo;
            }

            public String getTitolo() {
                    return titolo;
            }

            public int getRisultato() {
                    return risultato;
            }

        }

}