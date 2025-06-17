import java.util.*;

public class task7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите текст через пробел: ");
        // Чтение строки
        String input = scanner.nextLine();

        // Разделение строки на слова
        String[] words = input.split("\\s+");

        Set<String> uniqueWords = new LinkedHashSet<>();

        for (String word : words) {
            uniqueWords.add(word);
        }

        System.out.println(String.join(" ", uniqueWords));
    }
}