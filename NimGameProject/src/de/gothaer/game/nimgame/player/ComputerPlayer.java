package de.gothaer.game.nimgame.player;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private final  int [] turns = {3,1,1,2};
    public ComputerPlayer() {
    }

    public ComputerPlayer(final String name) {
        super(name);
    }

    @Override
    public Integer doTurn(final Integer stones) {

        final int turn = turns[stones%4];
        System.out.println((String.format("Computer nimmt %s Steine.", turn)));
        return turn;
    }
}
