package src.java.connect4.models;

import src.java.connect4.Board;
import src.java.connect4.models.Turn;
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

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }
    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

}
