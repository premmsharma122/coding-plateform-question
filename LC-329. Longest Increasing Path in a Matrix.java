class Solution {
    int max = 0;
    int dp[][];

    public int help(int arr[][], int r, int c, int cur, int ct) {

        // boundary
        if (r < 0 || r >= arr.length || c < 0 || c >= arr[0].length)
            return 0;

        // memo
        if (dp[r][c] != 0)
            return dp[r][c];

        int best = 1; // at least this cell

        // down
        if (r + 1 < arr.length && arr[r + 1][c] > arr[r][c])
            best = Math.max(best, 1 + help(arr, r + 1, c, cur, ct));

        // right
        if (c + 1 < arr[0].length && arr[r][c + 1] > arr[r][c])
            best = Math.max(best, 1 + help(arr, r, c + 1, cur, ct));

        // up
        if (r - 1 >= 0 && arr[r - 1][c] > arr[r][c])
            best = Math.max(best, 1 + help(arr, r - 1, c, cur, ct));

        // left
        if (c - 1 >= 0 && arr[r][c - 1] > arr[r][c])
            best = Math.max(best, 1 + help(arr, r, c - 1, cur, ct));

        dp[r][c] = best;
        return best;
    }

    public int longestIncreasingPath(int[][] matrix) {
        max = 0;
        dp = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                max = Math.max(max, help(matrix, i, j, 0, 0));
            }
        }
        return max;
    }
}
