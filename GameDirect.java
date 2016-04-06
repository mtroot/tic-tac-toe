
/**
 * Класс выражающий правила игры,
 * он определяет какой игрок выиграл,
 * либо же если произошла патовая ситуация.
 * @author Timur Muratov
 * 06/04/2016
 */
public class GameDirect {
    /**
     * Метод проверяет есть ли выиграшная ситуация
     * и возвращает id победителя.
     * Если же никто пока не выиграл, возвращает 0.
     * Если ходов больше нет и никто не выиграл - 3.
     * @param convas
     * @return 0 - 3
     */
    public int check(Convas convas){
        int[][] matrix = convas.matrix;
        //проверка, выиграл ли кто-то из играков
        for (int gamer = 1; gamer < 3; gamer++) {
            //проверяем горизонтальные линии
            for (int i = 0; i < matrix.length; i++) {
                if(matrix[i][0] == gamer && matrix[i][1] == gamer && matrix[i][2] == gamer) return gamer;
            }
            //проверяем вертикальные линии
            for (int i = 0; i < 3; i++) {
                if(matrix[0][i] == gamer && matrix[1][i] == gamer && matrix[2][i] == gamer) return gamer;
            }
            //проверяем диогонали
            if(matrix[0][0] == gamer && matrix[1][1] == gamer && matrix[2][2] == gamer) return gamer;
            if(matrix[2][0] == gamer && matrix[1][1] == gamer && matrix[0][2] == gamer) return gamer;
        }
        //проверка патовой ситуации
        boolean pat = true;
        a: for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == 0){
                    pat = false;
                    break a;
                }
            }
        }
        if(pat) return 3;
        return 0;
    }
}
