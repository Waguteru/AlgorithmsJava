import java.util.Scanner;

public class task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();
        
        int start = Math.min(num1, num2);
        
    
        for (int i = 0; i < 5; i++) { 
            int currentNumber = start + (i * start); 
            System.out.print(currentNumber * currentNumber + " ");
        }
        
        scanner.close(); // Close the scanner
    }
}
