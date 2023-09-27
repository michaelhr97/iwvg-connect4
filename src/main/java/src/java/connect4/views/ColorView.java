package src.java.connect4.views;

import src.java.connect4.types.Color;

public class ColorView {
    void write(Color color) {
        String string = color.name();
        if (color.isNull()) {
            string = Message.EMPTY_COLOR.getMessage();
        }
        Console.getInstance().write(string);
    }
}