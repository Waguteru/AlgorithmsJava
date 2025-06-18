import java.util.Random;
import java.util.Scanner;

public class task47 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел для генерации (N):");
        int n = scanner.nextInt();
        int size = (int) Math.sqrt(n);

        // Если N не является идеальным квадратом, корректируем размер матрицы
        if (size * size < n) {
            size++;
        }

        int[][] array = generateRandomArray(size, n);
        System.out.println("Сгенерированный массив:");
        printArray(array);

        int[] snailArray = snail(array);
        System.out.println("Массив в формате змейки:");
        printSnailArray(snailArray);
    }

    private static int[][] generateRandomArray(int size, int n) {
        int[][] array = new int[size][size];
        Random random = new Random();
        int count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (count < n) {
                    array[i][j] = random.nextInt(100); // Случайные числа от 0 до 99
                    count++;
                } else {
                    array[i][j] = 0;
                }
            }
        }
        return array;
    }

   
    private static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int element : row) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }

   
    private static int[] snail(int[][] array) {
        int size = array.length;
        int[] result = new int[size * size];
        int index = 0;

        for (int layer = 0; layer < (size + 1) / 2; layer++) {
            // Слева направо
            for (int i = layer; i < size - layer; i++) {
                result[index++] = array[layer][i];
            }
            // Сверху вниз
            for (int i = layer + 1; i < size - layer; i++) {
                result[index++] = array[i][size - layer - 1];
            }
            // Справа налево
            if (layer < size - layer - 1) {
                for (int i = size - layer - 2; i >= layer; i--) {
                    result[index++] = array[size - layer - 1][i];
                }
            }
            // Снизу вверх
            if (layer < size - layer - 1) {
                for (int i = size - layer - 2; i > layer; i--) {
                    result[index++] = array[i][layer];
                }
            }
        }
        return result;
    }


    private static void printSnailArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}