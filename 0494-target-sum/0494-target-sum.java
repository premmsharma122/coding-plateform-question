class Solution {
    private int dp[][];
    private int total;
    public int help(int arr[], int trg, int idx, int ans) {
        if (idx == arr.length) {
            if (ans == trg)
                return 1;
            else
                return 0;
        }

        if (dp[idx][total+ans] != -1)
            return dp[idx][total+ans];
        int add = help(arr, trg, idx + 1, ans + arr[idx]);
        int sub = help(arr, trg, idx + 1, ans - arr[idx]);
        return dp[idx][total+ans] = add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {
        total = 0;
        for (int x : nums)
            total += x;

        dp = new int[nums.length][2 * total + 1];
        for (int r[] : dp) {
            Arrays.fill(r, -1);
        }
        return help(nums, target, 0, 0);
    }
}