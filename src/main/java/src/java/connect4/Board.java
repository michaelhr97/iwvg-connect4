package src.java.connect4;

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

        for(int j=0; j < Coordinate.DIMENSION_Y; j++){
            for(int i=0; i < Coordinate.DIMENSION_X; i++){
                if(colors[i][j] == color){
                    Coordinate coordinate = new Coordinate(i,j);
                    if(isConnect4(color,coordinate)){
                        return true;
                    }
                }
            }
        }
        return false;

    }

    boolean isConnect4(Color color, Coordinate coordinate){
        return isConnect4Vertical(color, coordinate)
                || isConnect4Horizontal(color, coordinate)
                || isConnect4Diagonal(color, coordinate)
                || isConnect4ReverseDiagonal(color, coordinate);

    }

    boolean isConnect4Vertical(Color color, Coordinate coordinate){
        if(coordinate.getRow()+3 > 5) return false;
        for(int i = coordinate.getRow(); i < coordinate.getRow() +4; i++){
            if(colors[i][coordinate.getColumn()] != color){
                return false;
            }
        }
        return true;
    }

    boolean isConnect4Horizontal(Color color, Coordinate coordinate){

        if(coordinate.getColumn()-3 <0) return false;
        for(int i = coordinate.getColumn(); i > coordinate.getColumn() -4; i--){
            if(colors[coordinate.getRow()][i] != color){
                return false;
            }
        }
        return true;
    }


    boolean isConnect4Diagonal(Color color, Coordinate coordinate){
        if(coordinate.getRow()+3 > 5) return false;
        for(int i = coordinate.getRow(); i < coordinate.getRow() +4; i++){
            if(colors[i][coordinate.getColumn()+i-coordinate.getRow()] != color){
                return false;
            }
        }
        return true;
    }

    boolean isConnect4ReverseDiagonal(Color color, Coordinate coordinate){

        return false;
    }

    void write(){
        Message.HORIZONTAL_LINE.writeln();
        for(int i=0; i< Coordinate.DIMENSION_X; i++){
            for(int j=0; j< Coordinate.DIMENSION_Y; j++){
                this.getColor(new Coordinate(i, j)).write();
                Message.VERTICAL_LINE.write();
            }
            Console.getInstance().writeln();
        }
        Message.HORIZONTAL_LINE.writeln();
    }
}
