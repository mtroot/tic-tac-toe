import java.util.Random;

/**
 * Логика игрока - компьютер | player logic - computer
 * @author Timur Muratov
 * 06/04/2016
 */
public class Machine extends Gamer {
    Random random = new Random();
    public Machine(Game game) {
        super(game);
    }

    @Override
    public void step() {
        System.out.println("Ход компьютера | comp step (id: " + id + ")");
        boolean success = false;
        while (!success) {
            int position = random.nextInt(9) + 1;
            if (position == 0) {
                game.gameOver = true;
                game.looser = id;
                return;
            }
            success = game.convas.setPosition(position, id);
        }
    }

    @Override
    public String who() {
        return "Компьютер | Computer";
    }
}
