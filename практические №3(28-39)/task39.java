import java.util.Scanner;

public class task39 {
    public static void main(String[] args) {
       
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите текст:");
        String input = scanner.nextLine(); 
        
       
        String transformedText = transformText(input);
    
        System.out.println(transformedText);
    }


    private static String transformText(String text) {
      
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();

       
        for (String word : words) {
          
            if (word.length() > 0 && Character.isLetter(word.charAt(0))) {
               
                String transformedWord = word.substring(1) + word.charAt(0) + "ауч";
                result.append(transformedWord).append(" "); 
            } else {
               
                result.append(word).append(" ");
            }
        }

       
        return result.toString().trim();
    }
}