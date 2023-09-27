package src.java.connect4.types;

import java.util.ArrayList;
import java.util.Iterator;

public class Line {
    private ArrayList<Coordinate> coordinates;

    public Line() {

        coordinates = new ArrayList<>();
    }

    public void createLine(Coordinate coordinate, Direction direction){
        coordinates.clear();
        coordinates.add(coordinate);
        for(int i= 1; i < 4 ; i++){
            Coordinate lineCoordinate =
                    new Coordinate(coordinate.getRow(),coordinate.getColumn());
            lineCoordinate.moveCoordinateXTimes(direction.getDirectionCoordinate(),i);
            coordinates.add(lineCoordinate);
        }
    }

    public void moveLine(Direction direction){
        for (Coordinate coordinate : this.coordinates) {
            coordinate.moveCoordinate(direction.getInverseDirectionCoordinate());
        }
    }

    public ArrayList<Coordinate> getCoordinates(){

        return this.coordinates;
    }
}
