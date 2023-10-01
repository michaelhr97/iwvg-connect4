package src.java.connect4.types;

public enum Direction {

    VERTICAL,
    HORIZONTAL,
    DIAGONAL,
    REVERSEDIAGONAL;

    public Coordenate getDirectionCoordinate(){
        switch (this){
            case VERTICAL:
                return new Coordenate(1,0);
            case HORIZONTAL:
                return new Coordenate(0,1);
            case DIAGONAL:
                return new Coordenate(1,1);
            default:
                return new Coordenate(1,-1);
        }
    }

    public Coordenate getInverseDirectionCoordinate(){
        switch (this){
            case VERTICAL:
                return new Coordenate(-1,0);
            case HORIZONTAL:
                return new Coordenate(0,-1);
            case DIAGONAL:
                return new Coordenate(-1,-1);
            default:
                return new Coordenate(-1,1);
        }
    }
}
