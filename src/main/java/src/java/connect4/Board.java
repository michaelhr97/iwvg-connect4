package src.java.connect4;

class Board {

    private Color[][] colors;

    Board() {
        this.colors = new Color[Coordinate.DIMENSIONX][Coordinate.DIMENSIONY];
        this.reset();
    }

    void reset() {
        for (int i = 0; i < Coordinate.DIMENSIONX; i++) {
            for (int j = 0; j < Coordinate.DIMENSIONY; j++) {
                this.colors[i][j] = Color.NULL;
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
}
