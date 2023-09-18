package domainModel.utils;

public class Logger {

    private static final Logger instance = new Logger();

    public static Logger getInstance() {
        return instance;
    }

    public void write(String message) {
        System.out.print(message);
    }

    public void writeln() {
        System.out.println();
    }

    public void writeln(String message) {
        System.out.println(message);
    }
}
