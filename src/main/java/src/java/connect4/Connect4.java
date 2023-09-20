package src.java.connect4;

class Connect4 {

    private Board board;
    private Turn turn;

    Connect4(){
        this.board = new Board();
        this.turn = new Turn(this.board);
    }

    private void play(){
        Message.TITLE.writeln();
        this.board.write();
        int i = 0;
        do{
            this.turn.play();
            this.board.write();
        }while(/*!this.isGame()*/ i==0);
        this.turn.writeWinner();
    }

    private boolean isGame(){
        return this.board.isGame(this.turn.getActiveColor());
    }


    public static void main(String[] args) {
        new Connect4().play();
    }

}
