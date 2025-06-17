import java.util.*;

public class task38 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ввод количества игроков
        System.out.print("Введите количество игроков: ");
        int n = scanner.nextInt();

        // Ввод номера игрока, с которого начинается игра (1-based)
        System.out.print("Введите номер игрока, с которого начинается игра: ");
        int start = scanner.nextInt();

        // Инициализация списка игроков от 1 до n
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            players.add(i);
        }

        // Индекс начала игры (0-based)
        int index = start - 1;

        // Список выбывших игроков в порядке выбывания
        List<Integer> eliminated = new ArrayList<>();

        // Играем пока не останется 1 игрок
        while (players.size() > 1) {
            // Каждый третий выбывает: считаем 3 шага включая текущий
            // Т.к. текущий индекс - старт, то считаем 2 шага вперед:
            index = (index + 2) % players.size();

            int removed = players.remove(index);
            eliminated.add(removed);

            // Вывод текущего состояния
            System.out.println("Выбыли: " + eliminated);
            System.out.println("Остались: " + players);
            System.out.println("-----");
            // index указывает на следующий игрок после удаленного, так что не меняем
        }

        // Добавляем победителя в список выбывших (в конце)
        eliminated.add(players.get(0));

        System.out.println("Победитель: " + players.get(0));
        System.out.println("Полный список выбывших (включая победителя): " + eliminated);
    }
}

