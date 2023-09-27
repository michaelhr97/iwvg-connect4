package src.java.connect4.types;

public enum Direction {

    VERTICAL,
    HORIZONTAL,
    DIAGONAL,
    REVERSEDIAGONAL;

    public Coordinate getDirectionCoordinate(){
        switch (this){
            case VERTICAL:
                return new Coordinate(1,0);
            case HORIZONTAL:
                return new Coordinate(0,1);
            case DIAGONAL:
                return new Coordinate(1,1);
            default:
                return new Coordinate(1,-1);
        }
    }

    public Coordinate getInverseDirectionCoordinate(){
        switch (this){
            case VERTICAL:
                return new Coordinate(-1,0);
            case HORIZONTAL:
                return new Coordinate(0,-1);
            case DIAGONAL:
                return new Coordinate(-1,-1);
            default:
                return new Coordinate(-1,1);
        }

    }

}
