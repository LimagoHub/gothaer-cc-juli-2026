package bank;

public class Bank {

    private int [] konten = {30,50,100};

    public void kontostand () {
        for (int i = 0; i < konten.length; i++) {
            System.out.println("Konto " + i  + " hat den Saldo "+ konten[i]);
        }
        System.out.println("_".repeat(30));
    }

    public synchronized void ueberweisen(int von, int nach, int betrag){


            try {
                int zettel = konten[von];
                zettel -= betrag;
                Thread.sleep((long) (Math.random() * 2000));
                konten[von] = zettel;
                konten[nach] += betrag;
                kontostand();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

    }
}
