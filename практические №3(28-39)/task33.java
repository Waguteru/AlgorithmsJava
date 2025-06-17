import java.util.Scanner;

public class task33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите количество палочек (1 <= n <= 10^18): ");
        long n = scanner.nextLong();
        
        if (n < 1 || n > 1_000_000_000_000_000_000L) {
            System.out.println("Неверное количество палочек. Пожалуйста, введите число от 1 до 10^18.");
            return;
        }

        while (n > 0) {
            System.out.println("Текущее количество палочек: " + n);
            if (n % 2 == 0) {
     
                System.out.println("Вы можете взять 1 палочку или " + (n / 2) + " палочек.");
   
                n -= n / 2; 
            } else {
                
                System.out.println("Можно взять 1 палочку.");
                n -= 1; 
            }
        }

        System.out.println("Палочек не осталось! Игра окончена.");
        scanner.close();
    }
}
