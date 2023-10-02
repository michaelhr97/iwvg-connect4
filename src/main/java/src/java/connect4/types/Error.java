package src.java.connect4.types;

import src.java.connect4.views.ErrorView;

public enum Error {
    NOT_EMPTY,
    WRONG_COORDINATES,
    NULL;

    public boolean isNull(){
        return this == Error.NULL;
    }

    public void writeln(){
        if(!this.isNull()){
            new ErrorView().writeln(this);
        }
    }

    public boolean isWrong(){
        return this == Error.WRONG_COORDINATES;
    }
}
