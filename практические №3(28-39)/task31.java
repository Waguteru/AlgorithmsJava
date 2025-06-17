import java.util.ArrayList;
import java.util.List;

public class task31 {

    public static List<List<Integer>> findCityCombinations(List<Integer> distances, int numCities, int maxDistance) {
        List<List<Integer>> combinations = new ArrayList<>();
        findCombinationsRecursive(distances, numCities, 0, new ArrayList<>(), combinations, maxDistance);
        return combinations;
    }

    private static void findCombinationsRecursive(List<Integer> distances, int numCities, int start, List<Integer> currentCombination, List<List<Integer>> combinations, int maxDistance) {
        if (currentCombination.size() == numCities) {
            int sum = currentCombination.stream().mapToInt(Integer::intValue).sum();
            if (sum <= maxDistance) {
                combinations.add(new ArrayList<>(currentCombination));
            }
            return;
        }

        for (int i = start; i < distances.size(); i++) {
            currentCombination.add(distances.get(i));
            findCombinationsRecursive(distances, numCities, i + 1, currentCombination, combinations, maxDistance);
            currentCombination.remove(currentCombination.size() - 1);
        }
    }

    public static void main(String[] args) {
        List<Integer> distances = List.of(50, 55, 57, 58, 60);
        int numCities = 3; 
        int maxDistance = 163; 


        List<List<Integer>> validCombinations = findCityCombinations(distances, numCities, maxDistance);

        // Находим комбинацию с максимальной суммой, не превышающей maxDistance
        List<Integer> bestCombination = null;
        int maxSum = -1;

        for (List<Integer> combination : validCombinations) {
            int sum = combination.stream().mapToInt(Integer::intValue).sum();
            if (sum > maxSum) {
                maxSum = sum;
                bestCombination = combination;
            }
        }
        System.out.println("Наилучшая комбинация городов: " + bestCombination);
        System.out.println("Суммарное расстояние: " + maxSum);
    }
}