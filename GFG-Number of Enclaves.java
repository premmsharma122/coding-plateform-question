// User function Template for Java

class Solution {
    
    public void dfs(int[][] grid, int[][] sen, int[] delr, int[] delc, int r, int c) {
        sen[r][c] = 1;
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0; i < 4; i++) {
            int nr = r + delr[i];
            int nc = c + delc[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && sen[nr][nc] == 0 && grid[nr][nc] == 1) {
                dfs(grid, sen, delr, delc, nr, nc);
            }
        }
    }


    int numberOfEnclaves(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] sen = new int[n][m];
        int[] delr = {-1, 0, 1, 0};
        int[] delc = {0, 1, 0, -1};

        for (int i = 0; i < m; i++) {
            if (sen[0][i] == 0 && grid[0][i] == 1) {
                dfs(grid, sen, delr, delc, 0, i);
            }
            if (sen[n - 1][i] == 0 && grid[n - 1][i] == 1) {
                dfs(grid, sen, delr, delc, n - 1, i);
            }
        }

        for (int i = 0; i < n; i++) {
            if (sen[i][0] == 0 && grid[i][0] == 1) {
                dfs(grid, sen, delr, delc, i, 0);
            }
            if (sen[i][m - 1] == 0 && grid[i][m - 1] == 1) {
                dfs(grid, sen, delr, delc, i, m - 1);
            }
        }
        int c=0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (sen[i][j] == 0 && grid[i][j]==1) {
                    c++;
                }
            }
        }
        return c;
    }
}
