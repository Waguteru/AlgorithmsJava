import java.util.Scanner;

public class task29  {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int n = scanner.nextInt();

        if (n % 2 == 1) {
            int k = (n - 1) / 2;
            int firstSquare = k * k;
            int secondSquare = (k + 1) * (k + 1);
            System.out.println(firstSquare + " " + secondSquare);
        } else {
            // Для чётных n, решение не существует в целых числах
            System.out.println("Нет целых решений для данного n");
        }
    }
}