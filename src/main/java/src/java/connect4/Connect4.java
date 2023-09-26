package src.java.connect4;

import src.java.connect4.models.Game;
import src.java.connect4.views.View;

class Connect4 {

    private Game game;
    private View view;

    Connect4() {
        this.game = new Game();
        this.view = new View(this.game);
    }

    private void play() {
        do {
            this.view.start();
            this.view.play();
        } while (this.view.resume());
    }

    public static void main(String[] args) {
        new Connect4().play();
    }

}
