import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            long[] x = new long[n];
            long[] y = new long[n];

            for (int i = 0; i < n; i++) {
                x[i] = sc.nextLong();
                y[i] = sc.nextLong();
            }

            long direct = Math.abs(x[a] - x[b]) + Math.abs(y[a] - y[b]);

            if (k == 0) {
                System.out.println(direct);
                continue;
            }

            long minA = Long.MAX_VALUE;
            long minB = Long.MAX_VALUE;

            for (int i = 0; i < k; i++) {
                long da = Math.abs(x[a] - x[i]) + Math.abs(y[a] - y[i]);
                long db = Math.abs(x[b] - x[i]) + Math.abs(y[b] - y[i]);

                minA = Math.min(minA, da);
                minB = Math.min(minB, db);
            }

            System.out.println(Math.min(direct, minA + minB));
        }
    }
}
