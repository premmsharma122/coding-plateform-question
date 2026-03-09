import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextLong();

            long cur = a[0];
            long ans = a[0];

            for (int i = 1; i < n; i++) {

                if ((a[i] % 2 + 2) % 2 != (a[i - 1] % 2 + 2) % 2) {
                    cur = Math.max(a[i], cur + a[i]);
                } else {
                    cur = a[i];
                }

                ans = Math.max(ans, cur);
            }

            System.out.println(ans);
        }
    }
}
