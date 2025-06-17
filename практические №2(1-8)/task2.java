import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя: ");
        // Чтение имени
        String name = scanner.nextLine();

        // Приведение имени к нужному формату
        String formattedName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();

        System.out.println("Привет, " + formattedName + "!");
    }
}