package src.java.connect4.views;

public enum Message {

    TITLE("---CONNECT 4---"),
    HORIZONTAL_LINE("--------------------------------------------"),
    VERTICAL_LINE(" | "),
    EMPTY_COLOR("   "),
    PLAYER_WIN("The player :player wins!!"),
    PLAYER_TURN("Player :player Turn:"),
    ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:"),
    COLUMN("Column: ");

    private final String message;

    Message(String message){
        this.message = message;
    }

    public void write(){
        Console.getInstance().write(this.message);
    }

    public void writeln(){
        Console.getInstance().writeln(this.message);
    }

    public void writeln(String player){

        Console.getInstance().writeln(this.message.replaceAll(":player", player));
    }

    public String getMessage(){
        return this.message;
    }


}
