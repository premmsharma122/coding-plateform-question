import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        while (t-- > 0) {
            int n = s.nextInt();
            
 
            System.out.println(2);
 
            int cur = n;
            for (int i = n - 1; i >= 1; i--) {
                System.out.println(cur + " " + i);
                cur = (int) Math.ceil((cur + i) / 2.0);
            }
        }
        s.close();
    }
}
