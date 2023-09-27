package src.java.connect4.views;

import src.java.connect4.models.Game;

public class GameView extends WithGameView {

    private StartView startView;
    private PlayView playView;

    public GameView(Game game) {
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

    public boolean resume(){
        return true;
    }
}