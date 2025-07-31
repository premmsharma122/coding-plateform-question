//Back-end complete function Template for Java

class Solution {
    static int minC(int arr[] ,int idx, int dp[]){
        if(idx >= arr.length) return 0;
        if(dp[idx]!= -1) return dp[idx];
        return dp[idx] =  arr[idx] + Math.min(minC(arr,idx+1,dp), minC(arr,idx+2,dp));
    }
    static int minCostClimbingStairs(int[] cost) {
        // Write your code here
        int dp[] = new int[cost.length];
        Arrays.fill(dp, -1);
        return Math.min(minC(cost, 0, dp), minC(cost, 1,dp));
    }
}
