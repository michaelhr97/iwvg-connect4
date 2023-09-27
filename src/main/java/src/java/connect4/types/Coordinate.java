package src.java.connect4.types;

import src.java.connect4.ClosedInterval;

public class Coordinate {

    protected int row;

    protected int column;

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

    public boolean isValid(){
        return (this.getLimits(Coordinate.DIMENSION_X).isIncluded(this.row)
                && this.getLimits(Coordinate.DIMENSION_Y).isIncluded(this.column));
    }

    protected ClosedInterval getLimits(int dimension){
        return new ClosedInterval(0,dimension - 1);
    }

}
