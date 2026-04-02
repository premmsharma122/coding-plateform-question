class Solution {

    Integer[][][] dp;

    private int help(int[][] c, int r, int d, int k) {

        if (r >= c.length || d >= c[0].length) return Integer.MIN_VALUE;

        if (r == c.length - 1 && d == c[0].length - 1) {
            if (c[r][d] >= 0) return c[r][d];
            else {
                if (k > 0) return 0;
                else return c[r][d];
            }
        }

        if (dp[r][d][k] != null) return dp[r][d][k];

        int val = c[r][d];
        int ans = Integer.MIN_VALUE;

        if (val >= 0) {
            int next = Math.max(
                help(c, r + 1, d, k),
                help(c, r, d + 1, k)
            );

            if (next != Integer.MIN_VALUE)
                ans = val + next;

        } else {
            int next1 = Math.max(
                help(c, r + 1, d, k),
                help(c, r, d + 1, k)
            );

            if (next1 != Integer.MIN_VALUE)
                ans = val + next1;

            if (k > 0) {
                int next2 = Math.max(
                    help(c, r + 1, d, k - 1),
                    help(c, r, d + 1, k - 1)
                );

                if (next2 != Integer.MIN_VALUE)
                    ans = Math.max(ans, next2);
            }
        }

        return dp[r][d][k] = ans;
    }

    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        dp = new Integer[m][n][3];
        return help(coins, 0, 0, 2);
    }
}