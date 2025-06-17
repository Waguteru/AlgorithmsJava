import java.util.Scanner;

public class task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первое число: ");
        int start = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int step = scanner.nextInt();
        System.out.print("Введите третье число: ");
        int count = scanner.nextInt();
        
        // Вывод всех чисел ряда
        for (int i = 0; i < count; i++) {
            int current = start + i * step;
            System.out.print(current);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
        System.out.println();
    }
}