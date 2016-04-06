/**
 * Логика игрока | player logic
 * @author Timur Muratov
 * 06/04/2016
 */
public abstract class Gamer {
    private static int idCounter = 0;
    protected int id; //индетификатор игрока
    Game game;
    public Gamer(Game game){
        this.game = game;
        id = ++idCounter;
    }

    /**
     * логический ход игрока | player move
     */
    public abstract void step();

    /**
     * Возвращает кто это | return who am i
     * @return "Компьютер" или "Человек" | "Computer" or "Human"
     */
    public abstract String who();
}
