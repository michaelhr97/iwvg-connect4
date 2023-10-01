package src.java.connect4.models;

import src.java.connect4.types.*;

class Board {

    private Color[][] colors;

    Board() {
        this.colors = new Color[Coordenate.DIMENSION_X][Coordenate.DIMENSION_Y];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordenate.DIMENSION_X; i++) {
            for (int j = 0; j < Coordenate.DIMENSION_Y; j++) {
                this.colors[i][j] = Color.NULL;
            }
        }
    }

    void putToken(Coordenate coordenate, Color color) {
        this.colors[coordenate.getRow()][coordenate.getColumn()] = color;
    }

    public Color getColor(Coordenate coordenate) {
        return this.colors[coordenate.getRow()][coordenate.getColumn()];
    }

    boolean isEmpty(Coordenate coordenate) {
        return this.getColor(coordenate) == Color.NULL;
    }

    boolean isGame(Color color, Coordenate coordenate){
        assert !color.isNull();

        return DirectionalSearch(color, coordenate, Direction.VERTICAL)
                || DirectionalSearch(color, coordenate, Direction.HORIZONTAL)
                || DirectionalSearch(color, coordenate, Direction.DIAGONAL)
                || DirectionalSearch(color, coordenate, Direction.REVERSEDIAGONAL);
    }

    boolean isConnect4(Color color, Line line){
        int sameColorCounter = 0;
        for(Coordenate coordenateIterator : line.getCoordinates()){
            if(coordenateIterator.isValid()
                    && colors[coordenateIterator.getRow()][coordenateIterator.getColumn()] == color){
                sameColorCounter++;
            }
        }
        return sameColorCounter == 4;
    }

    boolean DirectionalSearch(Color color, Coordenate coordenate, Direction direction){
        Line line = new Line();
        line.createLine(coordenate, direction);
        for(int i = 0; i < 4; i++){
            if(isConnect4(color, line)){
                return true;
            }
            line.moveLine(direction);
        }
        return false;
    }

}
