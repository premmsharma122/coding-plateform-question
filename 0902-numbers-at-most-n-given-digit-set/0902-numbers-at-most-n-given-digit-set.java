class Solution {

    int[][] dp;
    String[] digits;

    public int solve(String num, int idx, int tight) {

        if (idx == num.length()) {
            return 1;
        }

        if (dp[idx][tight] != -1) {
            return dp[idx][tight];
        }

        int ub = tight == 1 ? num.charAt(idx) - '0' : 9;

        int res = 0;

        for (String d : digits) {

            int digit = d.charAt(0) - '0';

            if (digit > ub) {
                break;
            }

            int ntight = (tight == 1 && digit == ub) ? 1 : 0;

            res += solve(num, idx + 1, ntight);
        }

        return dp[idx][tight] = res;
    }

    public int atMostNGivenDigitSet(String[] digits, int n) {

        this.digits = digits;

        String num = String.valueOf(n);

        int len = num.length();

        int m = digits.length;

        int ans = 0;
        for (int l = 1; l < len; l++) {
            ans += Math.pow(m, l);
        }

        dp = new int[len][2];

        for (int i = 0; i < len; i++) {
            Arrays.fill(dp[i], -1);
        }

        ans += solve(num, 0, 1);

        return ans;
    }
}