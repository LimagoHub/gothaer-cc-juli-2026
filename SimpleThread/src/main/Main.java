package main;

import thread.SimpleThread;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        SimpleThread hund = new SimpleThread("Wau");
        SimpleThread katze = new SimpleThread("Miau");
        SimpleThread maus = new SimpleThread("Piep");

        Thread thread = new Thread(hund);
        Thread t2 = new Thread(katze);
        Thread t3 = new Thread(maus);
         thread.start();
         t2.start();
         t2.join();
         t3.start();
    }
}
