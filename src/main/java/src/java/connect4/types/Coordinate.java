package src.java.connect4.types;

public class Coordinate {

    private int row;

    private int column;

    public static final int DIMENSION_X = 6;
    public static final int DIMENSION_Y = 7;


    public Coordinate(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){

        return this.row;
    }

    public int getColumn(){

        return this.column;
    }

    public void moveCoordinate(Coordinate coordinate){
        this.row += coordinate.getRow();
        this.column += coordinate.getColumn();
    }

    public void moveCoordinateXTimes(Coordinate coordinate, int times){
        for(int i = 0; i< times; i++){
            moveCoordinate(coordinate);
        }
    }

    public boolean isValid(){
        return (this.getLimits(Coordinate.DIMENSION_X).isIncluded(this.getRow())
                && this.getLimits(Coordinate.DIMENSION_Y).isIncluded(this.getColumn()));
    }

    private ClosedInterval getLimits(int dimension){
        return new ClosedInterval(0,dimension - 1);
    }

}
