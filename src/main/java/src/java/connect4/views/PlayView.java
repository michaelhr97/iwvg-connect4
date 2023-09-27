package src.java.connect4.views;

import src.java.connect4.models.Game;
class PlayView extends WithGameView {

    PlayView(Game game) {
        super(game);
    }

    void interact() {
        do {
            Message.PLAYER_TURN.writeln(this.game.getActiveColor().name());
            this.game.next();
            new BoardView().write(this.game);
        } while (!this.game.isGame(this.game.getActiveColor()));
        Message.PLAYER_WIN.writeln(this.game.getActiveColor().name());
    }


}