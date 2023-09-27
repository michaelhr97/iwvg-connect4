package src.java.connect4.models;

import src.java.connect4.types.*;

class Board {

    private Color[][] colors;

    Board() {
        this.colors = new Color[Coordinate.DIMENSION_X][Coordinate.DIMENSION_Y];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.DIMENSION_X; i++) {
            for (int j = 0; j < Coordinate.DIMENSION_Y; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void putToken(Coordinate coordinate, Color color) {
        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    public Color getColor(Coordinate coordinate) {
        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isEmpty(Coordinate coordinate) {
        return this.getColor(coordinate) == Color.NULL;
    }

    boolean isGame(Color color, Coordinate coordinate){
        assert !color.isNull();

        boolean a =  DirectionalSearch(color, coordinate, Direction.VERTICAL)
                || DirectionalSearch(color, coordinate, Direction.HORIZONTAL)
                || DirectionalSearch(color, coordinate, Direction.DIAGONAL)
                || DirectionalSearch(color, coordinate, Direction.REVERSEDIAGONAL);

        return a;
    }

    boolean isConnect4(Color color, Line line){
        int sameColorCounter = 0;
        for(Coordinate coordinateIterator: line.getCoordinates()){
            if(coordinateIterator.isValid()
                    && colors[coordinateIterator.getRow()][coordinateIterator.getColumn()] == color){
                sameColorCounter++;
            }
        }
        return sameColorCounter == 4;
    }

    boolean DirectionalSearch(Color color, Coordinate coordinate, Direction direction){
        Line line = new Line();
        line.createLine(coordinate, direction);
        for(int i = 0; i < 4; i++){
            if(isConnect4(color, line)){
                return true;
            }
            line.moveLine(direction);
        }
        return false;
    }

}
