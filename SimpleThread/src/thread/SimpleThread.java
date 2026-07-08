package thread;


public class SimpleThread extends Object implements Runnable {

    private final String message;

    public SimpleThread(final String message) {
        this.message = message;
    }

    @Override
    public void run() {
        try {
            for(int i = 0; i < 10; i++) {
                System.out.println(message);
                Thread.sleep((long)(Math.random()*1000));
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

    }
}
