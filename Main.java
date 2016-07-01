import Controllers.Game;
import Views.Window;

/**
 * Created by User on 1.7.2016 �..
 */
public class Main {
    public static void main(String[] args) {
        Game game = new Game();
        Window window = new Window(game);
        game.start();
    }
}
