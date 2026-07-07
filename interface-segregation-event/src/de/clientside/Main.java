package de.clientside;


import de.tiere.PigTooFatListener;
import de.tiere.Schwein;

public class Main {

    private Metzger metzger = new Metzger();
    private Spediteur spediteur = new Spediteur();
	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {

		final Schwein schwein = new Schwein("Miss Piggy");
        schwein.addPigTooFatListener(new SchweineMetzgerAdapter());
        schwein.addPigTooFatListener(e-> spediteur.fahren(e));
        schwein.addPigTooFatListener(spediteur::fahren);
		for (int i = 0; i < 11; i++) {
			schwein.fuettern();
		}
	}

    private class SchweineMetzgerAdapter implements PigTooFatListener {

        @Override
        public void pigTooFat(final Schwein dickesSchwein) {
            metzger.schlachten(dickesSchwein);
        }
    }

}


class Metzger  {


    public void schlachten(final Schwein dickesSchwein) {
        System.out.println("Messer wetz!");
    }
}

class Spediteur  {


    public void fahren(final Object ware) {
        System.out.println("Wir fahren auf der Autobahn");
    }
}








