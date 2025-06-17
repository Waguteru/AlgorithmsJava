import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

         System.out.print("Введите текст: ");
        // Чтение строки
        String input = scanner.nextLine();

        int upperCount = 0;
        int lowerCount = 0;

        // Подсчет заглавных и строчных символов
        for (char ch : input.toCharArray()) {
            if (Character.isUpperCase(ch)) {
                upperCount++;
            } else if (Character.isLowerCase(ch)) {
                lowerCount++;
            }
        }

        // Преобразование в зависимости от подсчета
        if (upperCount > lowerCount) {
            System.out.println(input.toUpperCase());
        } else if (lowerCount > upperCount) {
            System.out.println(input.toLowerCase());
        } else {
            System.out.println(input.toLowerCase());
        }
    }
}

