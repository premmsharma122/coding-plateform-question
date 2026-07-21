class Solution {
    private int dp[][];
   public int help(int idx, int arr[], int trg) {
    if (trg == 0) return 0;
    if (idx >= arr.length || trg < 0) return Integer.MAX_VALUE;

    if (dp[idx][trg] != -1) return dp[idx][trg];

    int take = help(idx, arr, trg - arr[idx]);
    if (take != Integer.MAX_VALUE)
        take++;

    int not = help(idx + 1, arr, trg);

    return dp[idx][trg] = Math.min(take, not);
}
    public int coinChange(int[] coins, int amount) {
        dp = new int[coins.length+1][amount+1];
        for(int i=0; i<=coins.length; i++){
            Arrays.fill(dp[i],-1);
        }
         int ans = help(0, coins, amount);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}