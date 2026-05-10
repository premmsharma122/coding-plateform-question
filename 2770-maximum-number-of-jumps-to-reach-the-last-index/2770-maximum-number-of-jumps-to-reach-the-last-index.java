class Solution {
    public int help(int arr[], int trg, int idx, int n, int dp[]) {

        if (idx == n - 1) {
            return 0;
        }

        if (dp[idx] != -2) {
            return dp[idx];
        }

        int max = -1;

        for (int cur = idx + 1; cur < n; cur++) {

            int curval =  arr[cur] - arr[idx];

            if (curval >=-trg && curval <= trg) {

                int ans = help(arr, trg, cur, n, dp);

                if (ans != -1) {
                    max = Math.max(max, 1 + ans);
                }
            }
        }

        return  dp[idx] = max;
    }
    public int maximumJumps(int[] nums, int target) {

        int n = nums.length;

        int dp[] = new int[n];

        Arrays.fill(dp, -2);

        return help(nums, target, 0, n, dp);
    }
}