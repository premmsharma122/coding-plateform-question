class Solution {
    int n, m, N;
    int[][][] memo;

    public boolean help(int i, int j, int k, String s1, String s2, String s3) {
        if (i == n && j == m && k == N) return true;
        if (k >= N) return false;

        if (memo[i][j][k] != -1)
            return memo[i][j][k] == 1;

        boolean res = false;

        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            res = help(i + 1, j, k + 1, s1, s2, s3);
        }

        if (!res && j < m && s2.charAt(j) == s3.charAt(k)) {
            res = help(i, j + 1, k + 1, s1, s2, s3);
        }

        memo[i][j][k] = res ? 1 : 0;
        return res;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        N = s3.length();

        if (n + m != N) return false;

        memo = new int[n + 1][m + 1][N + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }

        return help(0, 0, 0, s1, s2, s3);
    }
}
