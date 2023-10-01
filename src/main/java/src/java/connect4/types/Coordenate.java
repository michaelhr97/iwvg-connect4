package src.java.connect4.types;

public class Coordenate {

    private int row;

    private int column;

    public static final int DIMENSION_X = 6;
    public static final int DIMENSION_Y = 7;


    public Coordenate(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow(){

        return this.row;
    }

    public int getColumn(){

        return this.column;
    }

    public void moveCoordinate(Coordenate coordenate){
        this.row += coordenate.getRow();
        this.column += coordenate.getColumn();
    }

    public void moveCoordinateXTimes(Coordenate coordenate, int times){
        for(int i = 0; i< times; i++){
            moveCoordinate(coordenate);
        }
    }

    public boolean isValid(){
        return (this.getLimits(Coordenate.DIMENSION_X).isIncluded(this.getRow())
                && this.getLimits(Coordenate.DIMENSION_Y).isIncluded(this.getColumn()));
    }

    private ClosedInterval getLimits(int dimension){
        return new ClosedInterval(0,dimension - 1);
    }

}
