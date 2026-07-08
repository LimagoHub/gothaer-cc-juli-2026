package main;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws Exception {
       new Main().run();
    }

    private void run() throws Exception{
        ExecutorService executor = Executors.newFixedThreadPool(8);
        for(int i = 0; i < 10; i++){
            executor.execute(this::bla);
        }
        executor.shutdown();
        System.out.println("Abba Jetzt");
        executor.awaitTermination(Long.MAX_VALUE, TimeUnit.DAYS);
        System.out.println("Done");
    }

    private void bla() {
        try {
            Thread.sleep((long)(Math.random()*1000));
            System.out.println("Thread "+ Thread.currentThread().getId()+" terminated");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class MyRunnable implements Runnable {
    @Override
    public void run() {
        try {
            Thread.sleep((long)(Math.random()*1000));
            System.out.println("Thread "+ Thread.currentThread().getId()+" terminated");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
