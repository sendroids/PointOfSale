import io.Database;
import mvc.Controller;
import mvc.IController;
import mvc.Model;
import views.MainWindowView;

public class Main {

    public static void main(String[] args) {
        IController controller = new Controller(new Model(Database.getInstance()),new MainWindowView());
        controller.initialize();
    }
}
