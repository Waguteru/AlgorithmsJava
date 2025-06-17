import java.util.Scanner;

public class task28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        // Ввод строки
        String input = scanner.nextLine();

        System.out.print("Введите число сдвига: ");
        // Ввод числа сдвига
        int shift = scanner.nextInt();
        scanner.nextLine(); // чтобы считать оставшуюся строку после числа

        System.out.print("Введите либо 'вправо', либо 'влево': ");
        // Ввод направления
        String direction = scanner.nextLine().toLowerCase();

        // Корректировка сдвига в зависимости от направления
        if (direction.equals("влево")) {
            shift = -shift;
        } else if (!direction.equals("вправо")) {
            System.out.println("Некорректное направление. Используйте 'влево' или 'вправо'.");
            return;
        }

        // Шифрование
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                char base = Character.isUpperCase(ch) ? 'A' : 'a';
                int offset = ch - base;
                int newOffset = (offset + shift) % 26;
                if (newOffset < 0) {
                    newOffset += 26;
                }
                result.append((char) (base + newOffset));
            } else {
                // Не изменяем не буквенные символы
                result.append(ch);
            }
        }

        // Вывод зашифрованной строки
        System.out.println(result.toString());
    }
}