class Solution {
    public long findKthSmallest(int[] coins, int k) {

        long low = 1;
        long high = (long) coins[0] * k;

        for (int coin : coins) {
            high = Math.min(high, (long) coin * k);
        }

        while (low < high) {
            long mid = low + (high - low) / 2;

            if (count(coins, mid, 0, 1, 1) >= k) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private long count(int[] coins, long x, int index, long currentLcm, int sign) {

        long ans = 0;

        for (int i = index; i < coins.length; i++) {

            long newLcm = lcm(currentLcm, coins[i]);

            if (newLcm > x) {
                continue;
            }

            ans += sign * (x / newLcm);

            ans += count(coins, x, i + 1, newLcm, -sign);
        }

        return ans;
    }

    private long gcd(long a, long b) {

        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }

        return a;
    }

    private long lcm(long a, long b) {

        return a / gcd(a, b) * b;
    }
}
