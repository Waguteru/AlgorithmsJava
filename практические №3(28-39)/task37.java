import java.util.Random;
import java.util.Scanner;

public class task37 {
    // The secret code to be guessed
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 20;
    private static final Random random = new Random();
    private static int[] secretCode;

    public static void main(String[] args) {
        // Generate a random secret code
        secretCode = generateSecretCode();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Добро пожаловать в игру «Взломщик кодов»!");
        System.out.println("У тебя " + MAX_ATTEMPTS + " попыток угадать 4-значный код.");

        for (int attempt = 1; attempt <= MAX_ATTEMPTS; attempt++) {
            System.out.print("Попытка " + attempt + ": Введи 4 числа (0-9) разделенные Enter: ");
            int[] guess = new int[CODE_LENGTH];

            // Read user input
            for (int i = 0; i < CODE_LENGTH; i++) {
                guess[i] = scanner.nextInt();
            }

            // Check for matches
            int matches = checkMatches(guess);
            System.out.println("У тебя " + matches + " совпадений.");

            // Check if the guess is correct
            if (matches == CODE_LENGTH) {
                System.out.println("Поздравляем! Вы угадали код!");
                break;
            }
        }

        System.out.println("Секретный код был: " + arrayToString(secretCode));
        scanner.close();
    }

    // Generate a random 4-digit code
    private static int[] generateSecretCode() {
        int[] code = new int[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            code[i] = random.nextInt(10); // Numbers from 0 to 9
        }
        return code;
    }

    // Check how many numbers match between the guess and the secret code
    private static int checkMatches(int[] guess) {
        int matchCount = 0;
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (guess[i] == secretCode[i]) {
                matchCount++;
            }
        }
        return matchCount;
    }

    // Utility method to convert array to string for display
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        for (int num : array) {
            sb.append(num).append(" ");
        }
        return sb.toString().trim();
    }
}