// class Solution {
//     public int help(int r, int c, List<List<Integer>> arr, int dp[][]){
//         if(r==arr.size()-1 ) return arr.get(r).get(c);
//         if(dp[r][c] != -1) return dp[r][c];
//         int ans1 = help(r+1,c,arr,dp);
//         int ans2 = help(r+1,c+1,arr,dp);
//         return dp[r][c] = arr.get(r).get(c) + Math.min(ans1, ans2);
//     }
//     public int minimumTotal(List<List<Integer>> triangle) {
//         int dp[][] = new int[triangle.size()][];
//         for(int i=0; i<triangle.size(); i++){
//             dp[i] = new int[triangle.get(i).size()];
//             Arrays.fill(dp[i], -1);
//         }
//         int ans = help(0,0,triangle,dp);
        
//         return ans;
//     }
// }

// optimized version 
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] dp = new int[n][];
        
        for (int i = 0; i < n; i++) {
            dp[i] = new int[triangle.get(i).size()];
        }

        for (int j = 0; j < triangle.get(n-1).size(); j++) {
            dp[n-1][j] = triangle.get(n-1).get(j);
        }

        for (int r = n - 2; r >= 0; r--) {
            for (int c = 0; c < triangle.get(r).size(); c++) {
                dp[r][c] = triangle.get(r).get(c) + 
                           Math.min(dp[r+1][c], dp[r+1][c+1]);
            }
        }

        return dp[0][0];
    }
}
