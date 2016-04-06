# tic-tac-toe

##Игра крестики-нолики##

Простая реализация

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

