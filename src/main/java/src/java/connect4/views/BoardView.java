package src.java.connect4.views;

import src.java.connect4.models.Game;
import src.java.connect4.types.Coordinate;

public class BoardView {
    void write(Game game){
        Message.HORIZONTAL_LINE.writeln();
        for(int i = 0; i< Coordinate.DIMENSION_X; i++){
            for(int j=0; j< Coordinate.DIMENSION_Y; j++){
                new ColorView().write(game.getColor(new Coordinate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
