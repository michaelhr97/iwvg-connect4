package src.java.connect4;

class Coordinate {

    static final String ROW = "Row: ";

    static final String COLUMN = "Column: ";

    protected int row;

    protected int column;

    public static final int DIMENSIONX = 7;
    public static final int DIMENSIONY = 6;


    protected Coordinate(){

    }

    protected Coordinate(int row, int column){
        this.row = row;
        this.column = column;
    }

    protected void read(Message titleMessage){
        Console console = Console.getInstance();
        titleMessage.writeln();
        this.row = console.readInt(Coordinate.ROW) - 1;
        this.column = console.readInt(Coordinate.COLUMN) - 1;
    }

    public int getRow(){

        return this.row;
    }

    public int getColumn(){

        return this.column;
    }

    public boolean isValid(){
        return (this.getLimits(Coordinate.DIMENSIONX).isIncluded(this.row)
                && this.getLimits(Coordinate.DIMENSIONY).isIncluded(this.column));
    }

    protected ClosedInterval getLimits(int dimension){
        return new ClosedInterval(0,dimension - 1);
    }

}
