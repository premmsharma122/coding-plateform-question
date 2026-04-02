import java.util.*;

public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long[] a = new long[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            // Step 1: check if already sorted
            boolean sorted = true;
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) {
                System.out.println(0);
                continue;
            }

            // Case 1: impossible
            if (a[n - 2] > a[n - 1]) {
                System.out.println(-1);
                continue;
            }

            // Case 2: impossible
            if (a[n - 1] < 0) {
                System.out.println(-1);
                continue;
            }

            // ✅ Otherwise possible
            System.out.println(n - 2);

            for (int i = n - 3; i >= 0; i--) {
                System.out.println((i + 1) + " " + (i + 2) + " " + n);
            }
        }
    }
}
