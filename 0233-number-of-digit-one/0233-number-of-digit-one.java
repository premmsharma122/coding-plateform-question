class Solution {
    int dp[][][];

    public int solve(String s, int idx, int t, int c) {
        if (idx == s.length()) return c;

        if (dp[idx][t][c] != -1)
            return dp[idx][t][c];

        int ub = (t == 1) ? s.charAt(idx) - '0' : 9;
        int res = 0;

        for (int i = 0; i <= ub; i++) {
            int newTight = (t == 1 && i == ub) ? 1 : 0;

            res += solve(
                s,
                idx + 1,
                newTight,
                c + (i == 1 ? 1 : 0)
            );
        }

        return dp[idx][t][c] = res;
    }

    public int countDigitOne(int n) {
        String s = String.valueOf(n);

        dp = new int[s.length() + 1][2][s.length() + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return solve(s, 0, 1, 0);
    }
}