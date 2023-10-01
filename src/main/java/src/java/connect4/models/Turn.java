package src.java.connect4.models;

import src.java.connect4.types.Color;
import src.java.connect4.views.Message;

class Turn {
    private Board board;
    private static final int NUMBER_PLAYERS = 2;
    private Player[] players;
    private int activePlayer;

    Turn(Board board){
        this.board = board;
        this.players = new Player[Turn.NUMBER_PLAYERS];
        this.reset();
    }

    void reset(){
        for(int i=0; i < NUMBER_PLAYERS; i++){
            this.players[i] = new Player(Color.get(i), this.board);
        }
        this.activePlayer = 0;
    }

    void play(){
        this.players[this.activePlayer].play();
    }

    boolean isGame(){
        boolean game = this.board.isGame(this.getActiveColor(), this.players[this.activePlayer].getLastTokenCoordinate());
        if(game) Message.PLAYER_WIN.writeln(this.getActiveColor().name());
        else this.switchPlayer();
        return game;
    }

    void switchPlayer(){
        this.activePlayer = (this.activePlayer+1) % Turn.NUMBER_PLAYERS;
    }

    Color getActiveColor(){
        return this.players[this.activePlayer].getColor();
    }

}
