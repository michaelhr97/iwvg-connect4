package src.java.connect4.views;

import src.java.connect4.models.Game;


abstract class WithGameView {

    protected Game game;

    WithGameView(Game game) {
        this.game = game;
    }

}