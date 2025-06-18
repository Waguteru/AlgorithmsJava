import java.util.Scanner;

public class task45 {
    
   
    public static String toRoman(int year) {
      
        if (year < 1 || year >= 10000) {
            throw new IllegalArgumentException("Год должен быть от 1 до 9999.");
        }

        String[] romanNumerals = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
        };
        int[] values = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
        };

        StringBuilder romanYear = new StringBuilder();

        for (int i = 0; i < values.length; i++) {
            while (year >= values[i]) {
                romanYear.append(romanNumerals[i]);
                year -= values[i];
            }
        }
        return romanYear.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

    
        System.out.print("Введите количество лет (1 < n < 10000): ");
        int year = scanner.nextInt(); 

        try {
            String romanYear = toRoman(year);
            System.out.println("Римская цифра: " + romanYear);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); 
        } finally {
            scanner.close(); 
        }
    }
}
