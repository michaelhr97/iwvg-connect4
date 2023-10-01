package src.java.connect4.models;

import src.java.connect4.types.Color;
import src.java.connect4.types.Coordinate;

public class Game {
    private Board board;
    private Turn turn;

    public Game() {
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    public void reset() {
        this.board.reset();
        this.turn.reset();
    }

    public void next(){
        this.turn.play();
    }

    public boolean isGame(){
        return this.turn.isGame();
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }
    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

}
