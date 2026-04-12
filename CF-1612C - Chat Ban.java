import java.util.*;

class Solution {
    
    static long getSum(long k, long m) {
        if (m <= k) {
            return m * (m + 1) / 2;
        } else {
            long first = k * (k + 1) / 2;
            long extra = m - k;
            
            long second = extra * (2 * k - extra - 1) / 2;
            return first + second;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            long k = sc.nextLong();
            long x = sc.nextLong();

            long total = k * k;

            if (x >= total) {
                System.out.println(2 * k - 1);
                continue;
            }

            long low = 1, high = 2 * k - 1;
            long ans = 2 * k - 1;

            while (low <= high) {
                long mid = (low + high) / 2;

                if (getSum(k, mid) >= x) {
                    ans = mid;
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

            System.out.println(ans);
        }
    }
}
