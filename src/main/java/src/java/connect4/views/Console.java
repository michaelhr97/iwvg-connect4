package src.java.connect4.views;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import src.java.connect4.types.Error;

public class Console {

    private static Console instance = new Console();

    public static Console getInstance() {
        return instance;
    }

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public String readString() {
        String input = null;
        try {
            input = this.bufferedReader.readLine();
        } catch (Exception e) {
            //esta mal va en otro lado
            //Error.WRONG_COORDINATES.writeln();
        }
        return input;
    }

    public int readInt() {
        int input = 0;
        boolean ok = false;
        do {
            try {
                input = Integer.parseInt(this.readString());
                ok = true;
            } catch (Exception ex) {
                this.writeError("integer");
            }
        } while (!ok);
        return input;
    }

    public void write(String string) {
        System.out.print(string);
    }

    public void writeln() {
        System.out.println();
    }

    public void writeln(String string) {
        write(string);
        writeln();
    }

    public void writeError(String format) {
        this.write("Format error, please enter a correct " + format + "formatted value");
        this.writeln();
    }
}
