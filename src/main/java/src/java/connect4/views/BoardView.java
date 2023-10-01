package src.java.connect4.views;

import src.java.connect4.models.Game;
import src.java.connect4.types.Coordenate;

public class BoardView {
    void write(Game game){
        Message.HORIZONTAL_LINE.writeln();
        for(int i = 0; i< Coordenate.DIMENSION_X; i++){
            for(int j = 0; j< Coordenate.DIMENSION_Y; j++){
                new ColorView().write(game.getColor(new Coordenate(i, j)));
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
