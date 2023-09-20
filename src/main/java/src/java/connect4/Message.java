package src.java.connect4;

enum Message {

    TITLE("---CONNECT 4---"),
    HORIZONTAL_LINE("---------------"),
    VERTICAL_LINE(" | "),
    PLAYER_WIN("The player :player wins!!"),
    PLAYER_TURN("Player :player Turn:"),
    ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:");

    private String message;

    Message(String message){
        this.message = message;
    }

    void write(){
        Console.getInstance().write(this.message);
    }

    void writeln(){
        Console.getInstance().writeln(this.message);
    }

    void writeln(String player){

        Console.getInstance().writeln(this.message.replaceAll(":player", "" + player));
    }


}
