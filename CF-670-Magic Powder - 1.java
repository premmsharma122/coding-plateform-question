import java.util.*;
public class Main {
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        long k = s.nextLong();  
        long a[] = new long[n];
        long b[] = new long[n];
        for (int i = 0; i < n; i++) a[i] = s.nextLong();
        for (int i = 0; i < n; i++) b[i] = s.nextLong();
        long l = 0, h = (long)1e12, ans = 0;
        while (l <= h) {
            long mid = (l + h) / 2;
            long usd = 0;
            for (int i = 0; i < n; i++) {
                long nd = mid * a[i];
                if (nd > b[i]) {
                    usd += (nd - b[i]);
                }
            }
            if (usd <= k) {
                ans = mid;
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
 
        System.out.println(ans);
    }
}
