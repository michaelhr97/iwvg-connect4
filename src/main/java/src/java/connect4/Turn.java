package src.java.connect4;

class Turn {

    private Board board;
    private Player[] players;
    private static final int NUMBER_PLAYERS = 2;
    private int activePlayer;

    Turn(Board board){
        this.board = board;
        this.players = new Player[NUMBER_PLAYERS];
    }

}
