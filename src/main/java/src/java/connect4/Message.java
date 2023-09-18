package src.java.connect4;

enum Message {

    TITTLE("---CONNECT 4---"),
    HORIZONTAL_LINE("---------------"),
    VERTICAL_LINE(" | "),
    ENTER_COORDINATE_TO_PUT("Enter a coordinate to put a token:");

    private String message;

    Message(String message){
        this.message = message;
    }

    void write(){
        Console.getInstance().write(this.message);
    }
}
