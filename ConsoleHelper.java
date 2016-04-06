import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Клас работающий с консолью | work in console
 * @author Timur Muratov
 * 06/04/2016
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String in() throws IOException {
        return reader.readLine();
    }

    /**
     * метод закрывает открытые ресурсы | method close opened recourse
     */
    public static void close(){
        try {
            reader.close();
        }catch (IOException e){}
    }

    /**
     * выбор позиции через консоль в соответствии заданым правилам | change position over console by given rules
     * 7 8 9
     * 4 5 6
     * 1 2 3
     * @return 1 to 9
     */
    public static int selectPosition(){
        int result;
        while (true) {
            try {
                System.out.println("Введите позицию, в которую вы хотите установить Х | select position in witch you want set 'X'");
                System.out.println("число от 1 до 9: | number 1 to 9");
                System.out.println("либо \"exit\" для выхода. | or 'exit' to exit from game");
                String positionStr = in();
                if(positionStr.equals("exit")){
                    close();
                    return 0;
                }
                result = Integer.valueOf(positionStr);
                if (result < 1 || result > 9) {
                    System.out.println("Введены данные не входящие в заданый диапазон | data is incorrect");
                    throw new IOException("не верное число | data is incorrect");
                } else break;
            } catch (IOException e) {
                System.out.println("Ошибка! | Error!");
            }
        }
        return result;
    }

    /**
     * установка типов играков (Человек или Компьютер) | set player type (Human or Computer)
     * в переданную игру | in this game
     * @param game
     */
    public static void selectGamer(Game game){
        System.out.println("1 - компьютер | computer");
        System.out.println("2 - человек | human");
        while (true) {
            try {
                System.out.println("Выберите 1-го игрока(X): | select 1st player(X)");
                int gamer1 = Integer.valueOf(in());
                if (gamer1 == 1) game.gamer1 = new Machine(game);
                else if (gamer1 == 2) game.gamer1 = new Human(game);
                else continue;
                System.out.println("Выберите 2-го игрока(O): | select 2nd player(O)");
                int gamer2 = Integer.valueOf(in());
                if (gamer2 == 1) game.gamer2 = new Machine(game);
                else if (gamer2 == 2) game.gamer2 = new Human(game);
                else continue;
                return;
            } catch (IOException e) {
                System.out.println("Ошибка! | Error!");
            }
        }
    }
}
