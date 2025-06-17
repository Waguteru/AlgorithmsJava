import java.util.Scanner;

public class task34 {
 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите количество палочек: ");
        long n = scanner.nextLong();

       
        long tanyaSticks = 0;
        long sashaSticks = 0;

       
        boolean tanyaTurn = true;

        while (n > 0) {
            if (tanyaTurn) {
               
                if (n % 2 == 0) {
                   
                    tanyaSticks += 1;
                    n -= 1; 
                } else {
                  
                    tanyaSticks += 1;
                    n -= 1;
                }
            } else {
              
                if (n % 2 == 0) {
                  
                    sashaSticks += n / 2;
                    n /= 2; 
                } else {
   
                    sashaSticks += 1;
                    n -= 1;
                }
            }

            tanyaTurn = !tanyaTurn;
        }

        System.out.println("Палочек у Тани: " + tanyaSticks);
    }
}
                   