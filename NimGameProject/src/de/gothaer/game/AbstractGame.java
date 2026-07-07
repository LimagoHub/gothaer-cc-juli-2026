package de.gothaer.game;

import de.gothaer.game.player.Player;
import io.Writer;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractGame<BOARD,TURN> implements Game {

    private List<Player<BOARD,TURN>> players = new ArrayList<>();
    private final Writer writer;
    private BOARD board;
    private TURN turn;
    private Player<BOARD,TURN> currentPlayer;

    protected List<Player<BOARD, TURN>> getPlayers() {
        return players;
    }


    protected BOARD getBoard() {
        return board;
    }

    protected void setBoard(final BOARD board) {
        this.board = board;
    }

    protected TURN getTurn() {
        return turn;
    }


    protected Player<BOARD, TURN> getCurrentPlayer() {
        return currentPlayer;
    }


    public AbstractGame(final Writer writer) {
        this.writer = writer;
    }

    @Override
    public void play() { // Integration
        while(!isGameOver()) {
            playRound();
        }
    }
    public void addPlayer(final Player<BOARD,TURN> player) {
        players.add(player);
    }

    public void removePlayer(final Player<BOARD,TURN> player) {
        players.remove(player);
    }



    // Integration
    private void playRound() {
        for(var player: players) {
            currentPlayer = player;
            playersTurn();
        }


    }

    private void playersTurn() {
        if (isGameOver()) return;
        processPlayersTurn();
        endTurn( );

    }

    private void endTurn() {
        updateBoard();
        handleGameEnd();
    }
    private void processPlayersTurn() {
        do askForTurn(); while (! isTurnValid());
    }


    private void askForTurn() {
        turn = currentPlayer.doTurn(board);
        reportIfTurnIsInvalid();
    }

    private void reportIfTurnIsInvalid() {
        if(! isTurnValid()) write("Invalid turn");
    }




    private void handleGameEnd() {
        if(isGameOver()) {
            write(currentPlayer.getName() + " hat verloren");
        }
    }

    protected void write(String message) {
        writer.write(message);
    }
    // ------------------------------
    protected abstract boolean isGameOver();
    protected abstract void updateBoard() ;


    protected abstract boolean isTurnValid();
}
