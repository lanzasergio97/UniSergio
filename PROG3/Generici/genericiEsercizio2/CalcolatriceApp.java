/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author liliana
 */
public class CalcolatriceApp {

    public static void main(String[] args) {
        Random r = new Random();
        ArrayList<Integer> interi = new ArrayList<>();
        for (int i=0; i<10; i++) {
            interi.add(r.nextInt(100));
        }
        //interi.add(1.234); // NO! Si possono solo aggiungere Integer
        Calcolatrice.printNumbers(interi);
        System.out.println("Max: " + Calcolatrice.max(interi) +
                           "; Tot: " + Calcolatrice.sum2(interi));
        System.out.println();

        ArrayList<Double> numeri = new ArrayList<>();
        for (int i=0; i<10; i++) {
            numeri.add(r.nextDouble());
        }
        Calcolatrice.printNumbers(numeri);
        System.out.println("Max: " + Calcolatrice.max(numeri) +
                           "; Tot: " + Calcolatrice.sum(numeri));
		/*
        ArrayList<String> sbagliato = new ArrayList<>();
        sbagliato.add("uno");
        Calcolatrice.printNumbers(sbagliato); //error: incompatible types: ArrayList<String> cannot be converted to List<? extends Number>
        */
    }
}

class Calcolatrice {
    public static void printNumbers(List<? extends Number> lista) {
        for (Number el : lista) {
            System.out.println(el);
        }
    }

/* versione 'pigra': ho normalizzato tutto a double */
    public static double sum(List<? extends Number> lista) {
        double ris = 0;
        for (Number el : lista) {
            ris = ris+el.doubleValue();
        }
        return ris;
    }

/* versione dettagliata, in cui tratto separatamente tutti
i tipi semplici (int, double, etc.)
NB: il codice e' incompleto (mancano float etc.) fate voi.
*/
    public static Number sum2(List<? extends Number> lista) {
        double val = 0;
        int v = 0;
        String tipo = "";
        Number ris = 0;
        for (Number el : lista) {
			if (el instanceof Double) {
            	val = val+el.doubleValue();
            	tipo = "Double";
			}
            else if (el instanceof Integer) {
            	v = v+ el.intValue();
            	tipo = "Integer";
			}
        }
        if (tipo.equals("Double")) {
			System.out.println("double!");
        	ris = val;
        	return ris;
			} else if (tipo.equals("Integer")) {
				System.out.println("interi!");
				ris = v;
				return v;
			} else return ris;
    }

/* PIGRA */
    public static double max(List<? extends Number> lista) {
        double max = Integer.MIN_VALUE;
        for (Number el : lista) {
            if (el.doubleValue()>max) {
                max = el.doubleValue();
            }
        }
        return max;
    }
}