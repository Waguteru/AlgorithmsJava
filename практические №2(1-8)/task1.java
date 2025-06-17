import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Введите первое значение: ");
        String firstString = scanner.nextLine();
        
       
        System.out.print("Введите второе значение: ");
        String secondString = scanner.nextLine();
        
     
        boolean result = isEnding(firstString, secondString);
        
       
        System.out.println(result);
        
      
        scanner.close();
    }

 
    public static boolean isEnding(String first, String second) {
       
        if (second.length() > first.length()) {
            return false;
        }
       
        return first.substring(first.length() - second.length()).equals(second);
    }
}