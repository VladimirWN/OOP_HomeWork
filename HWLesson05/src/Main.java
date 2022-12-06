import controller.Controller;
import view.ConsoleViewImpl;

public class Main {
    public static void main(String[] args) {
        Controller controller = new Controller(new ConsoleViewImpl());
        controller.start();
    }
}