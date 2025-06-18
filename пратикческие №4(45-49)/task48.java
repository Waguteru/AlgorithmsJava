import java.util.*;

public class task48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос у пользователя количества элементов
        System.out.print("Введите количество элементов ряда u: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Количество элементов должно быть положительным числом.");
            return;
        }

        // Используем LinkedHashSet для сохранения порядка и исключения дубликатов
        Set<Integer> uSet = new LinkedHashSet<>();
        uSet.add(1); // начальное значение u(0)

        int x = 0; // начальное значение x
        while (uSet.size() < n) {
            int y = 2 * x + 1;
            int z = 3 * x + 1;

            uSet.add(y);
            uSet.add(z);

            x++;
        }

        // Выводим полученный ряд
        System.out.println("Ряд u без дубликатов:");
        for (int num : uSet) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
