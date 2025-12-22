import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
 
        while (n-- > 0) {
            String s = sc.next();
 
            int sum = 0;
            int zeroCount = 0;
            boolean hasOtherEven = false;
 
            for (char ch : s.toCharArray()) {
                int d = ch - '0';
                sum += d;
                if (d == 0) zeroCount++;
                else if (d % 2 == 0) hasOtherEven = true;
            }
 
            if (sum % 3 == 0 && zeroCount >= 1 &&
               (zeroCount >= 2 || hasOtherEven)) {
                System.out.println("red");
            } else {
                System.out.println("cyan");
            }
        }
        
    }
}
