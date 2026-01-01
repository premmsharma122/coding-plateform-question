import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        int low = 0, high = m, ans = m;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, a, m)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(ans);
    }

    static boolean check(int x, int[] a, int m) {
        int prev = 0;
        for (int val : a) {
            if (val < prev) {
                if (prev - val > x) {
                    return false;
                }
            } else {
                if (!(val + x >= m && (val + x) % m >= prev)) {
                    prev = val;
                }
            }
        }
        return true;
    }
}
