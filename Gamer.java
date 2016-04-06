/**
 * Логика игрока
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
     * логический ход игрока
     */
    public abstract void step();

    /**
     * Возвращает кто это
     * @return "Компьютер" или "Человек"
     */
    public abstract String who();
}
