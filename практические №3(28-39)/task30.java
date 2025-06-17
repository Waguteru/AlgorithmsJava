import java.util.Scanner;

public class task30 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    System.out.print("Введите первое число: ");
        int a = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int s = scanner.nextInt();
        int target = a * s;

        // Проверяем, что сумма степеней цифр равна target
        int sumPowers = 0;
        String numberStr = String.valueOf(target);
        for (int i = 0; i < numberStr.length(); i++) {
            int digit = numberStr.charAt(i) - '0';
            sumPowers += Math.pow(digit, i + 1);
        }

        if (sumPowers == target) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }
}