package src.java.connect4.models;

import src.java.connect4.types.Color;
import src.java.connect4.types.Coordinate;
import src.java.connect4.types.Error;
import src.java.connect4.views.Console;
import src.java.connect4.views.Message;

class Player {

    private Color color;
    private Board board;
    private int putTokens;
    private Coordinate lastTokenCoordinate;

    public static final int TOKENSPERPLAYER = 21;


    Player(Color color, Board board){

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    public void play(){
        assert (this.putTokens < Player.TOKENSPERPLAYER);

        this.putToken();
    }

    private void putToken(){
        Coordinate coordinate;
        Error error;
        do{
            Message.ENTER_COORDINATE_TO_PUT.writeln();
            coordinate = this.getCoordinate();
            error = this.getPutTokenError(coordinate);
        }while (!error.isNull() || error.isWrong());
        this.board.putToken(coordinate, this.color);
        this.putTokens++;

        this.lastTokenCoordinate = coordinate;
    }

    Coordinate getCoordinate(){
        return this.read();
    }

    private Coordinate read(){
        Console console = Console.getInstance();
        Message.COLUMN.write();
        int column = console.readInt() - 1;
        int row = this.getRow(column);
        return new Coordinate(row,column);
    }

    private int getRow(int column){
        for(int i = Coordinate.DIMENSION_X -1; i >= 0; i--){
            Coordinate coordinate = new Coordinate(i,column);
            if(coordinate.isValid() && board.isEmpty(coordinate)){
                return i;
            }
        }
        return 8;
    }

    private Error getPutTokenError(Coordinate coordinate){
        Error error = Error.NULL;
        if(!coordinate.isValid()){
            error = Error.WRONG_COORDINATES;
        }
        else{
            if(!this.board.isEmpty(coordinate)){
                error = Error.NOT_EMPTY;
            }
        }
        error.writeln();
        return error;
    }

    public boolean haveTokensToPlay(){
        return this.putTokens == Player.TOKENSPERPLAYER;
    }

    Color getColor(){
        return this.color;
    }

    public Coordinate getLastTokenCoordinate() {
        return this.lastTokenCoordinate;
    }
}
