package src.java.connect4;

class Board {

    private Color[][] colors;

    Board() {
        this.colors = new Color[Coordinate.DIMENSIONX][Coordinate.DIMENSIONY];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.DIMENSIONY; i++) {
            for (int j = 0; j < Coordinate.DIMENSIONX; j++) {
                this.colors[j][i] = Color.NULL;
            }
        }
    }

    void putToken(Coordinate coordinate, Color color) {

        this.colors[coordinate.getRow()][coordinate.getColumn()] = color;
    }

    private Color getColor(Coordinate coordinate) {

        return this.colors[coordinate.getRow()][coordinate.getColumn()];
    }

    boolean isOccupied(Coordinate coordinate, Color color) {

        return this.getColor(coordinate) == color;
    }

    boolean isEmpty(Coordinate coordinate) {

        return this.isOccupied(coordinate, Color.NULL);
    }

    boolean isGame(Color color){
        assert !color.isNull();

        return false;
    }

    void write(){
        Message.HORIZONTAL_LINE.writeln();
        for(int i=0; i< Coordinate.DIMENSIONY; i++){
            for(int j=0; j< Coordinate.DIMENSIONX; j++){
                this.getColor(new Coordinate(j, i)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
