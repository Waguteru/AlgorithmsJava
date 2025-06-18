import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class task46 {

    private static final Map<Character, Integer> romanMap = new HashMap<>();

    static {
      
        romanMap.put('I', 1);
        romanMap.put('V', 5);
        romanMap.put('X', 10);
        romanMap.put('L', 50);
        romanMap.put('C', 100);
        romanMap.put('D', 500);
        romanMap.put('M', 1000);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество лет в Римских числах: ");
        String romanNumeral = scanner.nextLine(); 

        int arabicYear = convertRomanToArabic(romanNumeral);

        if (arabicYear > 0 && arabicYear < 10000) {
            System.out.println("Арабское число: " + arabicYear);
        } else {
            System.out.println("Ошибка: количество лет должно быть в диапазоне 1 < n < 10000.");
        }

        scanner.close();
    }

    private static int convertRomanToArabic(String roman) {
        int total = 0; 
        int prevValue = 0; 

        for (int i = roman.length() - 1; i >= 0; i--) {
            char currentChar = roman.charAt(i);
            int currentValue = romanMap.get(currentChar); 

          
            if (currentValue < prevValue) {
                total -= currentValue;
            } else {
                total += currentValue; 
            }
            prevValue = currentValue; 
        }
        return total; 
    }
}