import java.util.*;
 
public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        String str = s.next();
 
        // Check adjacent characters
        for (int i = 0; i < n - 1; i++) {
            if (str.charAt(i) != str.charAt(i + 1)) {
                System.out.println("YES");
                System.out.println(str.substring(i, i + 2));
                return;
            }
        }
 
        // If all characters are the same
        System.out.println("NO");
    }
}
