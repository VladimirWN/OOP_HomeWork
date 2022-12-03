package view;

import java.util.Scanner;
import java.util.logging.Logger;

public class ConsoleViewImpl implements View {

    private Scanner sc = new Scanner(System.in);
    private Logger logger = Logger.getAnonymousLogger();

    @Override
    public String get() {
        return sc.next();
    }

    public String getLine() {
        sc.nextLine();
        return sc.nextLine();
    }

    @Override
    public void set(String string) {
        logger.info(string);
    }
}
