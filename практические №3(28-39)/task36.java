import java.util.Scanner;
public class task36 {
    public static String decodeCaesar(String text, int shift) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26;
        for (char ch : text.toCharArray()) {
            if (ch >= 'A' && ch <= 'Z') {
                // Для заглавных букв
                char decoded = (char) (ch - shift);
                if (decoded < 'A') {
                    decoded += 26;
                }
                result.append(decoded);
            } else if (ch >= 'a' && ch <= 'z') {
                // Для строчных букв
                char decoded = (char) (ch - shift);
                if (decoded < 'a') {
                    decoded += 26;
                }
                result.append(decoded);
            } else {
                // Для остальных символов (пробелы, знаки препинания и т.д.) оставляем без изменений
                result.append(ch);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите зашифрованный текст (до 10000 символов):");
            String text = scanner.nextLine();
            if (text.length() > 10000) {
                System.out.println("Введённый текст превышает 10000 символов. Программа завершена.");
                scanner.close();
                return;
            }
            System.out.println("Введите сдвиг (число от 1 до 25) для расшифровки:");
            int shift;
            try {
                shift = Integer.parseInt(scanner.nextLine());
                if (shift < 1 || shift > 25) {
                    System.out.println("Сдвиг должен быть в диапазоне от 1 до 25. Программа завершена.");
                    scanner.close();
                    return;
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод сдвига. Программа завершена.");
                scanner.close();
                return;
            }
            String decodedText = decodeCaesar(text, shift);
            System.out.println("Расшифрованный текст:");
            System.out.println(decodedText);
            }
        }
    }
