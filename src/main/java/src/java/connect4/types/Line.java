package src.java.connect4.types;

import java.util.ArrayList;

public class Line {
    private ArrayList<Coordenate> coordenates;

    public Line() {

        coordenates = new ArrayList<>();
    }

    public void createLine(Coordenate coordenate, Direction direction){
        coordenates.clear();
        coordenates.add(coordenate);
        for(int i= 1; i < 4 ; i++){
            Coordenate lineCoordenate =
                    new Coordenate(coordenate.getRow(), coordenate.getColumn());
            lineCoordenate.moveCoordinateXTimes(direction.getDirectionCoordinate(),i);
            coordenates.add(lineCoordenate);
        }
    }

    public void moveLine(Direction direction){
        for (Coordenate coordenate : this.coordenates) {
            coordenate.moveCoordinate(direction.getInverseDirectionCoordinate());
        }
    }

    public ArrayList<Coordenate> getCoordinates(){

        return this.coordenates;
    }
}
