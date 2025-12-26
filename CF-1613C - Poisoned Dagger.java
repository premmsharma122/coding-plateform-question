import java.util.*;

public class Main {

    // function to check if given k is enough to deal >= h damage
    static boolean canKill(long k, long[] a, long h) {
        long damage = 0;
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            long gap = a[i + 1] - a[i];
            damage += Math.min(k, gap);
            if (damage >= h) return true;
        }

        // last attack always gives full k damage
        damage += k;

        return damage >= h;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            long h = sc.nextLong();

            long[] a = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextLong();
            }

            long low = 1, high = h, ans = h;

            while (low <= high) {
                long mid = (low + high) / 2;

                if (canKill(mid, a, h)) {
                    ans = mid;
                    high = mid - 1; // try smaller k
                } else {
                    low = mid + 1;  // need bigger k
                }
            }

            System.out.println(ans);
        }
    }
}
