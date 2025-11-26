// class Solution {
//     private int c = 0;

//     public void help(int arr[][], int r, int d, int sum, int k){
       
//         sum += arr[r][d];
//         if(r == arr.length - 1 && d == arr[0].length - 1){
//             if(sum % k == 0) c++;
//             return;
//         }
//         if(r + 1 < arr.length)
//             help(arr, r + 1, d, sum, k);

//         if(d + 1 < arr[0].length)
//             help(arr, r, d + 1, sum, k);
//         }

//     public int numberOfPaths(int[][] grid, int k) {
//         c = 0;
//         help(grid, 0, 0, 0, k);  
//         return c;
//     }
// }

// >>>> Memoize <<<
class Solution {
    private static final int MOD = 1_000_000_007;
    private int[][][] dp;

    private int dfs(int[][] grid, int r, int c, int rem, int k) {
        rem = (rem + grid[r][c]) % k;

        if (r == grid.length - 1 && c == grid[0].length - 1) {
            return (rem == 0) ? 1 : 0;
        }

        if (dp[r][c][rem] != -1) return dp[r][c][rem];

        long ways = 0;

        if (r + 1 < grid.length)
            ways += dfs(grid, r + 1, c, rem, k);

        if (c + 1 < grid[0].length)
            ways += dfs(grid, r, c + 1, rem, k);

        dp[r][c][rem] = (int)(ways % MOD);
        return dp[r][c][rem];
    }

    public int numberOfPaths(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;

        dp = new int[n][m][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        return dfs(grid, 0, 0, 0, k);
    }
}
