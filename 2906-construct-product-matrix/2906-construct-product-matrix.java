class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int MOD = 12345;

        int[][] p = new int[n][m];
        int zeroCount = 0;
        int[][] modGrid = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                modGrid[i][j] = grid[i][j] % MOD;
                if (modGrid[i][j] == 0) zeroCount++;
            }
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                long product = 1;

                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {

                        if (x == i && y == j) continue;

                        product = (product * modGrid[x][y]) % MOD;

                        if (product == 0) break;
                    }
                    if (product == 0) break;
                }

                p[i][j] = (int) product;
            }
        }

        return p;
    }
}