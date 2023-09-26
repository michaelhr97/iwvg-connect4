package src.java.connect4.views;

import src.java.connect4.models.Game;

class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            new Pla(this.game).interact();
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isTicTacToe());
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
    }

}