package domainModel.connect4;

import domainModel.utils.Logger;

public class Connect4 {

    Connect4() {

    }

    public void play() {
        this.playGame();
    }

    public void playGame() {
        Logger.getInstance().write("Start game!");
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
