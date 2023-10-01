package src.java.connect4.models;

import src.java.connect4.types.Color;
import src.java.connect4.types.Coordenate;
import src.java.connect4.types.Error;
import src.java.connect4.views.Console;
import src.java.connect4.views.Message;

class Player {

    private Color color;
    private Board board;
    private int putTokens;
    private Coordenate lastTokenCoordenate;

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
        Coordenate coordenate;
        Error error;
        do{
            Message.ENTER_COORDINATE_TO_PUT.writeln();
            coordenate = this.getCoordinate();
            error = this.getPutTokenError(coordenate);
        }while (!error.isNull() || error.isWrong());
        this.board.putToken(coordenate, this.color);
        this.putTokens++;

        this.lastTokenCoordenate = coordenate;
    }

    Coordenate getCoordinate(){
        return this.read();
    }

    private Coordenate read(){
        Console console = Console.getInstance();
        Message.COLUMN.write();
        int column = console.readInt() - 1;
        int row = this.getRow(column);
        return new Coordenate(row,column);
    }

    private int getRow(int column){
        for(int i = Coordenate.DIMENSION_X -1; i >= 0; i--){
            Coordenate coordenate = new Coordenate(i,column);
            if(coordenate.isValid() && board.isEmpty(coordenate)){
                return i;
            }
        }
        return 8;
    }

    private Error getPutTokenError(Coordenate coordenate){
        Error error = Error.NULL;
        if(!coordenate.isValid()){
            error = Error.WRONG_COORDINATES;
        }
        else{
            if(!this.board.isEmpty(coordenate)){
                error = Error.NOT_EMPTY;
            }
        }
        error.writeln();
        return error;
    }

    Color getColor(){
        return this.color;
    }

    void writeWinner(){
        Message.PLAYER_WIN.writeln(this.color.name());
    }

    public Coordenate getLastTokenCoordinate() {
        return this.lastTokenCoordenate;
    }
}
