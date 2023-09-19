package src.java.connect4;

class Connect4 {

    private Board board;
    private Turn turn;

    Connect4(){
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    private void play(){
        this.playGame();
    }

    private void playGame(){
        Console.getInstance().write("Start game");
    }

    public static void main(String[] args) {
        new Connect4().play();
    }
}
