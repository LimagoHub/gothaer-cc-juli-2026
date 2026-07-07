package main;

import client.GameClient;
import de.gothaer.game.Game;
import de.gothaer.game.nimgame.NimGame;
import de.gothaer.game.nimgame.player.ComputerPlayer;
import de.gothaer.game.nimgame.player.HumanPlayer;
import io.ConsoleWriter;

public class Main {
    public static void main(String[] args) {
        NimGame nimGame = new NimGame(new ConsoleWriter());
        nimGame.addPlayer(new HumanPlayer());
        nimGame.addPlayer(new ComputerPlayer());
        GameClient client = new GameClient(nimGame);
        client.go();

    }
}
