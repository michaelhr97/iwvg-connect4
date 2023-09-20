package src.java.connect4;

class Player {

    private Color color;
    private Board board;
    private int putTokens;

    public static final int TOKENSPERPLAYER = 21;


    Player(Color color, Board board){

        this.color = color;
        this.board = board;
        this.putTokens = 0;
    }

    void play(){
        if(this.putTokens < Player.TOKENSPERPLAYER){
            this.putToken();
        }
    }

    private void putToken(){
        Coordinate coordinate;
        Error error;
        do{
            coordinate = this.getCoordinate(Message.ENTER_COORDINATE_TO_PUT);
            error = this.getPutTokenError(coordinate);
        }while (!error.isNull() || error.isWrong());
        this.board.putToken(coordinate, this.color);
        this.putTokens++;

    }

    Coordinate getCoordinate(Message message){
        assert message != null;

        return this.read(message);
    }

    private Coordinate read(Message message){
        Console console = Console.getInstance();
        message.writeln();
        int column = console.readInt(Coordinate.COLUMN) - 1;
        int row = this.getRow(column);
        return new Coordinate(row,column);
    }

    private int getRow(int column){
        for(int i=Coordinate.DIMENSIONX -1; i >= 0; i--){
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

    Color getColor(){
        return this.color;
    }

    void writeWinner(){
        Message.PLAYER_WIN.writeln(this.color.name());
    }
}
