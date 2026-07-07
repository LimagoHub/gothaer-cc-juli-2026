package de.gothaer.game.nimgame.player;

import de.gothaer.game.player.AbstractPlayer;
import de.gothaer.game.player.Player;

public abstract class AbstractNimGamePlayer extends AbstractPlayer<Integer, Integer> {

    private String name = getClass().getSimpleName();

    public AbstractNimGamePlayer() {

    }
    public AbstractNimGamePlayer(final String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }


}
