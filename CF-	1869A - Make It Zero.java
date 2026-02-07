import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            if (n % 2 == 0) {
                // For even n, operating on the whole range [1, n] 
                // twice results in 0 because (x ^ x ^ ... ^ x) is 0 
                // when there are an even number of x's.
                System.out.println(2);
                System.out.println("1 " + n);
                System.out.println("1 " + n);
            } else {
                // For odd n, we break it into two even segments.
                // 1. Clear the first two elements [1, 2]
                // 2. Clear the remaining even segment [2, n]
                System.out.println(4);
                
                // Operations on indices 1 and 2
                System.out.println("1 2");
                System.out.println("1 2");
                
                // Operations on indices 2 through n
                // Length is (n - 2 + 1) = n - 1, which is even.
                System.out.println("2 " + n);
                System.out.println("2 " + n);
            }
        }
        sc.close();
    }
}
