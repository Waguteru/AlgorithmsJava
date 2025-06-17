import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class task32 {

    public static void main(String[] args) {

        
        int i = 10; // изменить на любой в диапазоне от 10 до 100000

        // Вычисление i-го числа Фибоначчи
        BigInteger fibNumber = computeFibonacci(i);

        // Подсчет вхождений цифр
        Map<Character, Integer> digitCount = countDigits(fibNumber);

        // Поиск цифры с максимальным количеством вхождений
        int maxCount = -1;
        int maxDigit = -1;
        for (Map.Entry<Character, Integer> entry : digitCount.entrySet()) {
            int digit = entry.getKey() - '0';
            int count = entry.getValue();
            if (count > maxCount || (count == maxCount && digit > maxDigit)) {
                maxCount = count;
                maxDigit = digit;
            }
        }

        // Вывод результата
        System.out.println("[" + maxDigit + ", " + maxCount + "]");
    }

    // Итеративный расчет i-го числа Фибоначчи
    private static BigInteger computeFibonacci(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int j = 2; j <= n; j++) {
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }
        return n == 0 ? BigInteger.ZERO : b;
    }

    // Подсчет вхождений цифр в число
    private static Map<Character, Integer> countDigits(BigInteger number) {
        Map<Character, Integer> countMap = new HashMap<>();
        String numStr = number.toString();
        for (char digit : numStr.toCharArray()) {
            countMap.put(digit, countMap.getOrDefault(digit, 0) + 1);
        }
        return countMap;
    }
}
