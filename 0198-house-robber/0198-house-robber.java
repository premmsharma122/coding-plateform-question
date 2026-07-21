class Solution {
    int dp[];
    public int help(int idx, int arr[]){
        if(idx>=arr.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return dp[idx]=Math.max(arr[idx]+ help(idx+2,arr), help(idx+1,arr));
    }
    public int rob(int[] nums) {
        dp= new int[nums.length+1];
        Arrays.fill(dp,-1);
        return Math.max(help(0,nums), help(1,nums));
    }
}