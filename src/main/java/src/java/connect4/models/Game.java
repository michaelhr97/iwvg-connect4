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

    public boolean isGame(Color color){
        assert !color.isNull();

        for(int j=0; j < Coordinate.DIMENSION_Y; j++){
            for(int i=0; i < Coordinate.DIMENSION_X; i++){
                Coordinate coordinate_ = new Coordinate(i,j);
                if(board.getColor(coordinate_) == color){
                    if(isConnect4(color,coordinate_)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isConnect4(Color color, Coordinate coordinate){
        return isConnect4Vertical(this.turn.getActiveColor(), coordinate)
                || isConnect4Horizontal(color, coordinate)
                || isConnect4Diagonal(color, coordinate)
                || isConnect4ReverseDiagonal(color, coordinate);
    }


    boolean isConnect4Vertical(Color color, Coordinate coordinate){
        if(coordinate.getRow()+3 > 5) return false;
        for(int i = coordinate.getRow(); i < coordinate.getRow() +4; i++){
            Coordinate coordinate_ = new Coordinate(i,coordinate.getColumn());
            if(board.getColor(coordinate_) != color){
                return false;
            }
        }
        return true;
    }

    boolean isConnect4Horizontal(Color color, Coordinate coordinate){

        if(coordinate.getColumn()-3 <0) return false;
        for(int i = coordinate.getColumn(); i > coordinate.getColumn() -4; i--){
            Coordinate coordinate_ = new Coordinate(coordinate.getRow(),i);
            if(board.getColor(coordinate_) != color){
                return false;
            }
        }
        return true;
    }


    boolean isConnect4Diagonal(Color color, Coordinate coordinate){
        if(coordinate.getRow()+3 > 5) return false;
        for(int i = coordinate.getRow(); i < coordinate.getRow() +4; i++){
            Coordinate coordinate_ = new Coordinate(i,coordinate.getColumn()+i-coordinate.getRow());
            if(board.getColor(coordinate_) != color){
                return false;
            }
        }
        return true;
    }

    boolean isConnect4ReverseDiagonal(Color color, Coordinate coordinate){
        if((coordinate.getColumn()-3 <0) || (coordinate.getRow()+3 > 5)) return false;
        for(int i = coordinate.getColumn(); i > coordinate.getColumn() -4; i--){
            Coordinate coordinate_ = new Coordinate(coordinate.getRow()-i+coordinate.getColumn(),i);
            if(board.getColor(coordinate_) != color){
                return false;
            }
        }
        return true;
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }
    public Color getColor(Coordinate coordinate) {
        return this.board.getColor(coordinate);
    }

}
