import java.util.*;

public class Main {

    static boolean can(long x, long k, long need) {
        // sum of largest x gains
        long sum = x * (2 * k - x - 1) / 2;
        return sum >= need;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long k = sc.nextLong();

        if (n == 1) {
            System.out.println(0);
            return;
        }

        long need = n - 1;
        long maxGain = k * (k - 1) / 2;

        if (need > maxGain) {
            System.out.println(-1);
            return;
        }

        long low = 1, high = k - 1, ans = k - 1;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (can(mid, k, need)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(ans);
    }
}
