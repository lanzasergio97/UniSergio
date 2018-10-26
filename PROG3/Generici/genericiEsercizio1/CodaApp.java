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
public class CodaApp {
    public static void main(String args[]) {
        Random r = new Random();
        ArrayList<Integer> numeri = new ArrayList<>();
        Coda<Integer> queue = new Coda<>(numeri);
        for (int i=0; i<10; i++) {
            queue.put(r.nextInt(100));
        }
        queue.print();
        Integer num = queue.get();
        System.out.println("Rimosso " + num);
        queue.print();
    }
}

class Coda <T> {
    private List<T> c;
    private T first;

    public Coda(List<T> c) {
        this.c = c;
    }

    public T get() {
        T ris = null;
        if (c.size()>0) {
            ris = c.remove(0);
        }
        return ris;
    }

    public void put(T el) {
        c.add(el);
    }

    public void print() {
        for (int i=0; i<c.size(); i++) {
            System.out.print(c.get(i) + ", ");
        }
        System.out.println();
    }
}
