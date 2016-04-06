package game1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Клас работающий с консолью
 * @author Timur Muratov
 * 06/04/2016
 */
public class ConsoleHelper {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static String in() throws IOException {
        return reader.readLine();
    }

    /**
     * метод закрывает открытые ресурсы
     */
    public static void close(){
        try {
            reader.close();
        }catch (IOException e){}
    }

    /**
     * выбор позиции через консоль в соответствии заданым правилам
     * 7 8 9
     * 4 5 6
     * 1 2 3
     * @return 1- 9
     */
    public static int selectPosition(){
        int result;
        while (true) {
            try {
                System.out.println("Введите позицию, в которую вы хотите установить Х");
                System.out.println("число от 1 до 9:");
                System.out.println("либо \"exit\" для выхода.");
                String positionStr = in();
                if(positionStr.equals("exit")){
                    close();
                    return 0;
                }
                result = Integer.valueOf(positionStr);
                if (result < 1 || result > 9) {
                    System.out.println("Введены данные не входящие в заданый диапазон");
                    throw new IOException("не верное число");
                } else break;
            } catch (IOException e) {
                System.out.println("Ошибка!");
            }
        }
        return result;
    }

    /**
     * установка типов играков (Человек или Компьютер)
     * в переданную игру
     * @param game
     */
    public static void selectGamer(Game game){
        System.out.println("1 - компьютер");
        System.out.println("2 - человек");
        while (true) {
            try {
                System.out.println("Выберите 1-го игрока(X):");
                int gamer1 = Integer.valueOf(in());
                if (gamer1 == 1) game.gamer1 = new Machine(game);
                else if (gamer1 == 2) game.gamer1 = new Human(game);
                else continue;
                System.out.println("Выберите 2-го игрока(O):");
                int gamer2 = Integer.valueOf(in());
                if (gamer2 == 1) game.gamer2 = new Machine(game);
                else if (gamer2 == 2) game.gamer2 = new Human(game);
                else continue;
                return;
            } catch (IOException e) {
                System.out.println("Ошибка!");
            }
        }
    }
}
