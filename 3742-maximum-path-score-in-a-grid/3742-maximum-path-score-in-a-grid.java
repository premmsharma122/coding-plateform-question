class Solution {
    private Integer[][][] memo;

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new Integer[m][n][k + 1];
        int result = help(grid, 0, 0, 0, k);
        return result < 0 ? -1 : result;
    }

    public int help(int g[][], int r, int c, int currentCost, int k) {
        int val = g[r][c];
        int score = (val == 2) ? 2 : (val == 1 ? 1 : 0);
        int cost = (val == 2 || val == 1) ? 1 : 0;

        int totalCost = currentCost + cost;

        if (totalCost > k) return -1000000;

        if (r == g.length - 1 && c == g[0].length - 1) {
            return score;
        }

        if (memo[r][c][currentCost] != null) {
            return memo[r][c][currentCost];
        }

        int res = -1000000;

        if (r + 1 < g.length) {
            res = Math.max(res, help(g, r + 1, c, totalCost, k));
        }

        if (c + 1 < g[0].length) {
            res = Math.max(res, help(g, r, c + 1, totalCost, k));
        }

        return memo[r][c][currentCost] = (res < 0) ? res : score + res;
    }
}