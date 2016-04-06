/**
 *  Класс реализующий игровое поле | Class implements playing field
 *  @author Timur Muratov
 *  06/04/2016
 */
public class Convas {
    int[][] matrix = new int[3][3];

    /**
     * Метод выводит игровое поле на экран | method draws playing field to display
     * пустая ячейка отмечена | empty cell - "."
     * ход 1го игрока | 1st player - "Х"
     * ход 2го игорка | 2nd player - "О"
     */
    public void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                switch (matrix[i][j]){
                    case 0: {
                        System.out.print(".");
                        break;
                    }
                    case 1: {
                        System.out.print("X");
                        break;
                    }
                    case 2: {
                        System.out.print("O");
                        break;
                    }
                }
            }
            System.out.println();
        }
    }

    /**
     * Устанавливает в матрицу игрового поля ход игрока, | set player change in game matrix
     * если ячейка свободна, ход устанавливается и возвращается true, | if cell is empty then cell will change and method return true
     * если же ячейка уже занята, возвращает false | if cell is not empty, method return false
     * @param x
     * @param y
     * @param idGamer
     * @return успех вставки | success (true or false)
     */
    private boolean setInMatrix(int x, int y, int idGamer){
        if(matrix[y][x] != 0) return false;
        matrix[y][x] = idGamer;
        return true;
    }

    /**
     * Переводит значение позиции (1-9: подобие правой числовой панели на клавиатуре), | method transforms position number(1 to 9)
     * в соответствии с заданными правилами, в матричную координату. | to matrix cell.
     * @param position
     * @param idGamer
     * @return успех вставки | success (true or false)
     */
    public boolean setPosition(int position, int idGamer){
        switch (position){
            case 1: return setInMatrix(0,2,idGamer);
            case 2: return setInMatrix(1,2,idGamer);
            case 3: return setInMatrix(2,2,idGamer);
            case 4: return setInMatrix(0,1,idGamer);
            case 5: return setInMatrix(1,1,idGamer);
            case 6: return setInMatrix(2,1,idGamer);
            case 7: return setInMatrix(0,0,idGamer);
            case 8: return setInMatrix(1,0,idGamer);
            case 9: return setInMatrix(2,0,idGamer);
        }
        return false;
    }
}
