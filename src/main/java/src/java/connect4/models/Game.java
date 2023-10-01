package src.java.connect4.models;

import src.java.connect4.types.Color;
import src.java.connect4.types.Coordenate;

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

        for(int j = 0; j < Coordenate.DIMENSION_Y; j++){
            for(int i = 0; i < Coordenate.DIMENSION_X; i++){
                Coordenate coordenate_ = new Coordenate(i,j);
                if(board.getColor(coordenate_) == color){
                    if(isConnect4(color, coordenate_)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean isConnect4(Color color, Coordenate coordenate){
        return isConnect4Vertical(this.turn.getActiveColor(), coordenate)
                || isConnect4Horizontal(color, coordenate)
                || isConnect4Diagonal(color, coordenate)
                || isConnect4ReverseDiagonal(color, coordenate);
    }


    boolean isConnect4Vertical(Color color, Coordenate coordenate){
        if(coordenate.getRow()+3 > 5) return false;
        for(int i = coordenate.getRow(); i < coordenate.getRow() +4; i++){
            Coordenate coordenate_ = new Coordenate(i, coordenate.getColumn());
            if(board.getColor(coordenate_) != color){
                return false;
            }
        }
        return true;
    }

    boolean isConnect4Horizontal(Color color, Coordenate coordenate){

        if(coordenate.getColumn()-3 <0) return false;
        for(int i = coordenate.getColumn(); i > coordenate.getColumn() -4; i--){
            Coordenate coordenate_ = new Coordenate(coordenate.getRow(),i);
            if(board.getColor(coordenate_) != color){
                return false;
            }
        }
        return true;
    }


    boolean isConnect4Diagonal(Color color, Coordenate coordenate){
        if(coordenate.getRow()+3 > 5) return false;
        for(int i = coordenate.getRow(); i < coordenate.getRow() +4; i++){
            Coordenate coordenate_ = new Coordenate(i, coordenate.getColumn()+i- coordenate.getRow());
            if(board.getColor(coordenate_) != color){
                return false;
            }
        }
        return true;
    }

    boolean isConnect4ReverseDiagonal(Color color, Coordenate coordenate){
        if((coordenate.getColumn()-3 <0) || (coordenate.getRow()+3 > 5)) return false;
        for(int i = coordenate.getColumn(); i > coordenate.getColumn() -4; i--){
            Coordenate coordenate_ = new Coordenate(coordenate.getRow()-i+ coordenate.getColumn(),i);
            if(board.getColor(coordenate_) != color){
                return false;
            }
        }
        return true;
    }

    public Color getActiveColor() {
        return this.turn.getActiveColor();
    }
    public Color getColor(Coordenate coordenate) {
        return this.board.getColor(coordenate);
    }

}
