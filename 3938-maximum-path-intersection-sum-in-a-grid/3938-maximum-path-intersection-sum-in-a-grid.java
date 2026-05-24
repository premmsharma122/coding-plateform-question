class Solution {
    public int maxScore(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        int ans = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            int cur = grid[i][0];
            for(int j=1; j<m; j++){
                ans =Math.max(ans,cur+grid[i][j]);
                cur = Math.max(grid[i][j], cur+grid[i][j]);
            }
        }
        for(int j=0; j<m; j++){
            int cur=grid[0][j];
            for(int i=1; i<n; i++){
                ans = Math.max(ans, cur+grid[i][j]);
                cur = Math.max(grid[i][j], grid[i][j]+cur);
            }
        }
        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                ans = Math.max(ans,grid[i][j]);
            }
        }
        return ans;
    }
}