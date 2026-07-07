package main;

import client.GameClient;
import de.gothaer.game.Game;
import de.gothaer.game.nimgame.NimGame;

public class Main {
    public static void main(String[] args) {
        NimGame nimGame = new NimGame();
        GameClient client = new GameClient(nimGame);
        client.go();

    }
}
