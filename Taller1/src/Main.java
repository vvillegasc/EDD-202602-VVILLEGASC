import controller.MainController;
import view.ConsoleView;

public class Main {

    public static void main(String[] args) {
        ConsoleView view = new ConsoleView();
        MainController controller = new MainController(view);
        controller.run();
    }
}
