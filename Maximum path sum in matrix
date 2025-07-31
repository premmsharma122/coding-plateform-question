// User function Template for Java
class Solution {
    public int path(int arr[][] , int r, int c, int dp[][]){
        int n = arr.length, m = arr[0].length;
        if(r==n || c<0 || c==m) return Integer.MIN_VALUE;
        if(r==n-1) return arr[r][c];
        if(dp[r][c] != 0) return dp[r][c];
        
        int left = path(arr,r+1,c-1,dp);
        int right = path(arr,r+1,c+1,dp);
        int down = path(arr,r+1,c, dp);
        return dp[r][c] = arr[r][c] + Math.max(left, Math.max(right, down));
        
    }
    public int maximumPath(int[][] mat) {
        // code here
        int n = mat.length, m = mat[0].length;
        int dp[][] = new int[n][m];
        int ans = 0;
        for(int i=0; i<m; i++){
            ans = Math.max(ans, path(mat, 0,i,dp));
        }
        return ans;
        
    }
}
