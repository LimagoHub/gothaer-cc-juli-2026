package de.gothaer.game.nimgame.player;

public class ComputerPlayer extends AbstractNimGamePlayer{

    private final  int [] turns = {3,1,1,2};
    public ComputerPlayer() {
    }

    public ComputerPlayer(final String name) {
        super(name);
    }

    /**
     *
     * @param stones
     * @return
     */
    @Override
    public Integer doTurn(final Integer stones)
    {

        /*

         */
        // dfdfg
        final int turn = turns[stones%4];

        // TODO Durch Writer ersetzen
        System.out.println((String.format("Computer nimmt %s Steine.", turn)));
        return turn;
    }
}
