import java.util.Arrays;
import java.util.Comparator;

public class task35 {

    // Функция для вычисления суммы цифр числа
    public static int sumOfDigits(int number) {
        int sum = 0;
        String numStr = String.valueOf(number); // Преобразуем число в строку
        for (int i = 0; i < numStr.length(); i++) {
            sum += Character.getNumericValue(numStr.charAt(i)); // Получаем цифру из строки и добавляем к сумме
        }
        return sum;
    }

    public static void main(String[] args) {
        String weights = "56 65 74 100 99 68 86 180 90";
        String[] weightsArray = weights.split(" "); // Разбиваем строку на массив строк

        Integer[] numbers = new Integer[weightsArray.length];
        for (int i = 0; i < weightsArray.length; i++) {
            numbers[i] = Integer.parseInt(weightsArray[i]);
        }

        Arrays.sort(numbers, Comparator.comparingInt(task35::sumOfDigits));

        System.out.println(Arrays.toString(numbers));
    }
}