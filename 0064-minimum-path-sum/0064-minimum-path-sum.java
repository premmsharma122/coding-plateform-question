class Solution {
    int dp[][];
    public int help(int g[][], int n, int m, int r, int d){
        if(r>=n || d>=m) return Integer.MAX_VALUE;
        if(r==n-1 && d==m-1) {
            return g[r][d];
        }
        if(dp[r][d]!=-1) return dp[r][d];
        int rg = help(g,n,m,r+1,d);
        int dw = help(g,n,m,r,d+1);
        return dp[r][d] = g[r][d]+Math.min(rg,dw);
    }
    public int minPathSum(int[][] grid) {
        dp = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return help(grid,grid.length, grid[0].length, 0,0);        
    }
}