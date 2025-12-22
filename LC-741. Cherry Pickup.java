// class Solution {
//     public int cherryPickup(int[][] grid) {
//         int n = grid.length;
//         int ans = dfs(grid, 0, 0, 0, 0);
//         return Math.max(0, ans);
//     }

//     int dfs(int[][] grid, int r1, int c1, int r2, int c2) {

//         int n = grid.length;

//         if (r1 >= n || c1 >= n || r2 >= n || c2 >= n) return Integer.MIN_VALUE;
//         if (grid[r1][c1] == -1 || grid[r2][c2] == -1) return Integer.MIN_VALUE;

//         if (r1 == n - 1 && c1 == n - 1) {
//             return grid[r1][c1];
//         }
//         int cherries;
//         if (r1 == r2 && c1 == c2) {
//             cherries = grid[r1][c1];
//         } else {
//             cherries = grid[r1][c1] + grid[r2][c2];
//         }

//         int best = Integer.MIN_VALUE;
//         best = Math.max(best, dfs(grid, r1 + 1, c1, r2 + 1, c2));
//         best = Math.max(best, dfs(grid, r1 + 1, c1, r2, c2 + 1));
//         best = Math.max(best, dfs(grid, r1, c1 + 1, r2 + 1, c2));
//         best = Math.max(best, dfs(grid, r1, c1 + 1, r2, c2 + 1));

//         if (best == Integer.MIN_VALUE) return Integer.MIN_VALUE;

//         return cherries + best;
//     }
// }

// Memo ------>
class Solution {

    int n;
    int[][][] dp;
    static final int NEG_INF = -1000000000;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        dp = new int[n][n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                Arrays.fill(dp[i][j], NEG_INF);

        int ans = dfs(grid, 0, 0, 0);
        return Math.max(0, ans);
    }

    int dfs(int[][] grid, int r1, int c1, int r2) {

        int c2 = r1 + c1 - r2;

        // bounds / blocked
        if (r1 >= n || c1 >= n || r2 >= n || c2 >= n)
            return NEG_INF;
        if (grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return NEG_INF;

        // reached end
        if (r1 == n - 1 && c1 == n - 1)
            return grid[r1][c1];

        // memo
        if (dp[r1][c1][r2] != NEG_INF)
            return dp[r1][c1][r2];

        int cherries;
        if (r1 == r2 && c1 == c2)
            cherries = grid[r1][c1];
        else
            cherries = grid[r1][c1] + grid[r2][c2];

        int best = NEG_INF;

        best = Math.max(best, dfs(grid, r1 + 1, c1, r2 + 1)); // DD
        best = Math.max(best, dfs(grid, r1 + 1, c1, r2));     // DR
        best = Math.max(best, dfs(grid, r1, c1 + 1, r2 + 1)); // RD
        best = Math.max(best, dfs(grid, r1, c1 + 1, r2));     // RR

        dp[r1][c1][r2] = cherries + best;
        return dp[r1][c1][r2];
    }
}
