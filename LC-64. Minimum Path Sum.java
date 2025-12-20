class Solution {
    public int help(int i, int j, int m, int n, int[][] arr, int[][] memo) {
        if (i >= m || j >= n) return Integer.MAX_VALUE;

        if (i == m - 1 && j == n - 1) return arr[i][j];

        if (memo[i][j] != -1) return memo[i][j];

        int down = help(i + 1, j, m, n, arr, memo);
        int right = help(i, j + 1, m, n, arr, memo);

        memo[i][j] = arr[i][j] + Math.min(down, right);
        return memo[i][j];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(memo[i], -1);
        }
        return help(0, 0, m, n, grid, memo);
    }
}
