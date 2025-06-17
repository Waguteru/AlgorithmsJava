import java.util.Arrays;
import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] cell = new int[3];
        boolean[] isEmpty = {true, true, true}; // отслеживание пустых ячеек

        while (true) {
            int num = scanner.nextInt();

            // Проверка наличия пустых ячеек
            int emptyIndex = -1;
            for (int i = 0; i < 3; i++) {
                if (isEmpty[i]) {
                    emptyIndex = i;
                    break;
                }
            }

            if (emptyIndex != -1) {
                // Заполняем первую пустую ячейку
                cell[emptyIndex] = num;
                isEmpty[emptyIndex] = false;
            } else {
                // Нет пустых ячеек, заменяем минимальное значение
                int minIndex = 0;
                for (int i = 1; i < 3; i++) {
                    if (cell[i] < cell[minIndex]) {
                        minIndex = i;
                    }
                }
                cell[minIndex] = num;
            }

            System.out.println("Ячейки: " + Arrays.toString(cell));
        }
    }
}