class Solution {
    public int path(int m , int n, int dp[][]){
        if(m==1 && n==1) return 1;
        if(m==0 || n==0) return 0;
        if(dp[m][n] != -1) return dp[m][n];
        int right = path(m, n-1,dp);
        int down = path(m-1, n, dp);
        return dp[m][n] = right + down;
    }
    public int numberOfPaths(int m, int n) {
        // Code Here
        int dp[][] = new int[m+1][n+1];
        for(int i=0;i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                dp[i][j] = -1;
            }
        }
        return path(m,n, dp);
        
    }
}
