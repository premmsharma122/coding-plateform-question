class Solution {
    public double help(int r, int c, int n, int k, double memo[][][]) {
        if (r < 0 || c < 0 || r >= n || c >= n) return 0;
        if (k == 0) return 1;
        if(memo[r][c][k] !=-1) return memo[r][c][k];
        double res = 0;
        res += help(r - 2, c - 1, n, k - 1,memo);
        res += help(r - 2, c + 1, n, k - 1,memo);
        res += help(r + 2, c - 1, n, k - 1,memo);
        res += help(r + 2, c + 1, n, k - 1,memo);
        res += help(r - 1, c - 2, n, k - 1,memo);
        res += help(r - 1, c + 2, n, k - 1,memo);
        res += help(r + 1, c - 2, n, k - 1,memo);
        res += help(r + 1, c + 2, n, k - 1,memo);
        
        return memo[r][c][k] = (double) res / 8.0d;
    }

    public double knightProbability(int n, int k, int row, int column) {
        double memo[][][] = new double[row+1][column+1][k+1];
        for(int i=0; i<row; i++){
            for(int j=0; j<column; j++){
                Arrays.fill(memo[j],-1);
            }
        }
        return help(row, column, n, k, memo);
    }
}
