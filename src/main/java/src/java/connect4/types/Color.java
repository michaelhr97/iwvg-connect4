package src.java.connect4.types;

public enum Color {
    RED,
    GRN,
    NULL;

    static Color get(int ordinal){
        assert ordinal >= 0 && ordinal < Color.NULL.ordinal();

        return Color.values()[ordinal];
    }

    public boolean isNull(){

        return this == Color.NULL;
    }
}
