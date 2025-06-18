import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task49 {
    // Мемоизация для функции fusc
    private static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите n для вычисления fusc(n): ");
        long n = scanner.nextLong();

        long result = fusc(n);
        System.out.println("fusc(" + n + ") = " + result);
    }

    // Реализация функции fusc с мемоизацией
    public static long fusc(long n) {
        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        long result;
        if (n == 0) {
            result = 0;
        } else if (n == 1) {
            result = 1;
        } else if (n % 2 == 0) {
            // n чётное
            result = fusc(n / 2);
        } else {
            // n нечётное
            long nDiv2 = n / 2;
            result = fusc(nDiv2) + fusc(nDiv2 + 1);
        }

        memo.put(n, result);
        return result;
    }
}
