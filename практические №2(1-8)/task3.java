import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст: ");
        String input = scanner.nextLine();

        // Удаление гласных
        String result = input.replaceAll("[AEIOUaeiouаеёиоуыэюяАЕЁИОУЫЭЮЯ]", "");

        System.out.println(result);
    }
}