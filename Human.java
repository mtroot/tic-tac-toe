package game1;

/**
 * Логика игрока - человек.
 * @author Timur Muratov
 * 06/04/2016
 */
public class Human extends Gamer {

    public Human(Game game) {
        super(game);
    }

    @Override
    public void step() {
        System.out.println("Ход человека (id: " + id + ")");
        boolean success = false;
        while (!success) {
            int position = ConsoleHelper.selectPosition();
            if (position == 0) {
                game.gameOver = true;
                game.looser = id;
                return;
            }
            success = game.convas.setPosition(position, id);
            if(!success) System.out.println("повторите попытку, место занято");
        }
    }

    @Override
    public String who() {
        return "Человек";
    }
}
