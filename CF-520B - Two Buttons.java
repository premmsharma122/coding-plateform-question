import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int clicks = 0;

        // Greedy approach: Work backwards from m to n
        while (m > n) {
            if (m % 2 == 0) {
                m /= 2;
            } else {
                m += 1;
            }
            clicks++;
        }

        // If m is now smaller than n, the only way to reach n 
        // is by adding 1 repeatedly (which is subtracting 1 in the forward direction)
        clicks += (n - m);

        System.out.println(clicks);
        sc.close();
    }
}
-------
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int clicks = 0;

        // Greedy approach: Work backwards from m to n
        while (m > n) {
            if (m % 2 == 0) {
                m /= 2;
            } else {
                m += 1;
            }
            clicks++;
        }

        // If m is now smaller than n, the only way to reach n 
        // is by adding 1 repeatedly (which is subtracting 1 in the forward direction)
        clicks += (n - m);

        System.out.println(clicks);
        sc.close();
    }
}
