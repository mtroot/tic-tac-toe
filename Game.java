package game1;

/**
 * Класс Game, который связывает все элементы  вместе
 * и имеет 3 основных этапа start(), run(), end();
 * @author Timur Muratov
 * 06/04/2016
 */
public class Game {
    boolean gameOver = false;
    int winner;
    int looser;
    boolean pat = false;
    Convas convas;
    GameDirect gameDirect;
    Gamer gamer1;
    Gamer gamer2;
    public Game(Convas convas, GameDirect gameDirect){
        this.convas = convas;
        this.gameDirect = gameDirect;
        ConsoleHelper.selectGamer(this);
    }

    /**
     * возвращает игрока по его индетификатору
     * @param id
     * @return gamer1 or gamer2
     */
    private Gamer getById(int id){
        if(gamer1.id == id) return gamer1;
        else if(gamer2.id == id) return gamer2;
        else return null;
    }

    /**
     * основной поток игрового процесса
     */
    public void run(){
        while (!gameOver){
            convas.print();
            int chek = gameDirect.check(convas);
            if(chek != 0){
                if (chek == 3){
                    pat = true;
                    return;
                }else {
                    winner = chek;
                    return;
                }
            }
            gamer1.step();
            if(gameOver) return;
            convas.print();
            chek = gameDirect.check(convas);
            if(chek != 0){
                if (chek == 3){
                    pat = true;
                    return;
                }else {
                    winner = chek;
                    return;
                }
            }
            gamer2.step();
        }
    }

    /**
     * начало игры
     */
    public void start(){
        System.out.println("Start Game!");
        System.out.println("Позиции расположены как на числовой панели справа на клавиатуре");
        System.out.println("7 8 9");
        System.out.println("4 5 6");
        System.out.println("1 2 3");
        System.out.println("При выборе позиции учитывайте это.");
    }

    /**
     * конец игры
     * подведение итогов
     */
    public void end(){
        if(pat) System.out.println("Ничья");
        if(looser != 0){
            System.out.println(getById(looser).who() + " с id:" + looser + " сдался!");
            System.out.println(getById(3-looser).who() + " с id:" + (3 - looser) + " выиграл!");
        } else {
            System.out.println(getById(winner).who() + " с id:" + winner + " выиграл!");
        }
        ConsoleHelper.close();
    }

    public static void main(String[] args) {
        Game game = new Game(new Convas(), new GameDirect());
        game.start();
        game.run();
        game.end();
    }
}
