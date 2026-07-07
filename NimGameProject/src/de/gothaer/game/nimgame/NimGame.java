package de.gothaer.game.nimgame;

import de.gothaer.game.Game;

import java.util.Scanner;

public class NimGame implements Game {
    private final Scanner scanner = new Scanner(System.in);
    private int stones;
    private int turn;

    
    public NimGame() {
        stones = 23;

    }
    @Override
    public void play() { // Integration
        while(!isGameOver()) {
            playRound();
        }
    }

    // Integration
    private void playRound() {
        playersTurn();
        computerTurn();
    }

    private void playersTurn() {
        if (isGameOver()) return;

        while(true) {
            System.out.println(String.format("Es gibt %s Steine. Bitte nehmen Sie 1, 2 oder 3.", stones));
            turn = scanner.nextInt();
            if(isTurnValid()) break;
            System.out.println("Ungueltiger Zug");
        }
        endTurn( "Player");

    }




    private void computerTurn() {
        if (isGameOver()) return;
        final int [] turns = {3,1,1,2};


        turn = turns[stones%4];
        System.out.println(String.format("Computer nimmt %s Steine.", turn));
        endTurn( "Computer");
    }
    private void endTurn(String player) {
        updateBoard();
        handleGameEnd(player);
    }

    private void handleGameEnd(final String player) {
        if(isGameOver()) {
            System.out.println(player + " hat verloren");
        }
    }
//----------------------- Implemtierungssumpf------------------------------------------------------
    private void updateBoard() {
        stones -= turn;
    }

    // Operation
    private boolean isGameOver() {
        return stones < 1;
    }

    private boolean isTurnValid() {
        return turn >= 1 && turn <= 3;
    }
}
