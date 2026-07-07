package de.gothaer.game.nimgame;

import de.gothaer.game.AbstractGame;
import de.gothaer.game.Game;
import de.gothaer.game.player.Player;
import io.Writer;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.List;

public class NimGame extends AbstractGame<Integer,Integer> {

    
    public NimGame(final Writer writer) {
        super(writer);
        setBoard(23);

    }

//----------------------- Implemtierungssumpf------------------------------------------------------
    protected void updateBoard() {
        setBoard(getBoard() - getTurn());
    }

    // Operation
    protected boolean isGameOver() {
        return getBoard() < 1 || getPlayers().isEmpty();
    }

    protected boolean isTurnValid() {
        return getTurn() >= 1 && getTurn() <= 3;
    }
}
