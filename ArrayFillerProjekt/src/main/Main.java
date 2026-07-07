package main;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Main {


    private int [] feld = new int[Integer.MAX_VALUE /2];

    public static void main(String[] args) {

       new Main().run();
    }
    public void run(){
        Random rand = new Random();

        Instant start = Instant.now();

        for (int i = 0; i < feld.length; i++) {
            feld[i] = rand.nextInt();

        }
        Instant end = Instant.now();
        Duration duration = Duration.between(start, end);
        System.out.println("Duration: " + duration.toMillis());
    }
}
