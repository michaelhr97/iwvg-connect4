package src.java.connect4;

import src.java.connect4.models.Game;
import src.java.connect4.views.GameView;

class Connect4 {

    private Game game;
    private GameView gameView;

    Connect4() {
        this.game = new Game();
        this.gameView = new GameView(this.game);
    }

    private void play() {
        do {
            this.gameView.start();
            this.gameView.play();
        } while (this.gameView.isNewGame());
    }

    public static void main(String[] args) {
        new Connect4().play();
    }

}
