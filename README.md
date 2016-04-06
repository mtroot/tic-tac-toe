# tic-tac-toe

##Игра крестики-нолики##

Простая консольная реализация

Чтобы запустить скиньте все java файлы в один пакет,
main() находиться в классе Game

***Подробнее о реализации***

*класс Game* - объеденяет все классы в себе, и запускает процесс через основные методы start(), run(), end() именно в таком порядке.

*класс ConsoleHalper* - класс ввода, через его статические методы осуществляется ввод данных, все Exception обрабатываются в нем

*класс Convas* - класс реализующий игровое поле. Через метод print() он выводит поле в консоль, через метод setPosition(int position, int idGamer) меняет значения ячеек в поле

*класс GameDirect* - реализует правила игры, проверяет текущее состояние и определяет итог: если выиграл один из игроков, то возвращает его id, или определяется игра продолжается либо достигнута патовая ситуация (ходов больше нет и никто не выиграл)

*класс Gamer* - абстрактный класс задающий логику игроков. Основный действия это ход - метод step() и определение кто это метод - who().

*класс Human и Machine* - потомки класса Gamer. реализуют его логику.

На данный момент стратегии игрока Machine (компьютер) нет никакой. Там тупо рандомное заполнение ячеек, этим играком. Позже сделаю нормальную логику

###TODO###
реализовать стратегию игрока Machine

--------------------------------------------------------
## Game tic-tac-toe##

Simple console implementation

***More about game implementation***

*class Game* unites all classes, and runs game process by methods *start()*, *run()*, *end()* (in this order).

*class ConsoleHelper* - class for input, gamer inputs data by its static methods. All exceptions handle in this class.

*class Convas* implaments playing field. It draws convas to console over method *print()* and sets values in the convas over method *setPosition(int position, int idGamer)*.

*class GameDirect* implements game rules. It checks current condition and defines result: if one of the players won class returns player id, in other case, class defines game continues or reached pat situation.

*class Gamer* is abstract class defined logic of player. Basic moves are *step()* (one step in game) and *who()* (print player name (Computer or Human))

*classes Human and Machine* are children of class Gamer. Classes implements that logic.

In this moment, machine stategy is very stupid (random)

***TODO*** -> implements machine strategy
