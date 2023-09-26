package src.java.connect4.views;

import src.java.connect4.models.Game;

public class View extends WithGameView {

    private StartView startView;
    private PlayView playView;

    public View(Game game) {
        super(game);
        this.startView = new StartView(this.game);
        this.playView = new PlayView(this.game);
    }

    public void start() {
        this.startView.interact();
    }

    public void play() {
        this.playView.interact();
    }
}