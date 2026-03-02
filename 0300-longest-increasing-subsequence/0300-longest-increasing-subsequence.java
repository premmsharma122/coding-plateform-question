import java.util.*;

class Solution {

    int[][] dp;

    public int help(int[] a, int idx, int prevIdx) {

        if (idx == a.length) return 0;

        if (dp[idx][prevIdx + 1] != -1)
            return dp[idx][prevIdx + 1];

        // skip
        int skip = help(a, idx + 1, prevIdx);

        // take
        int take = 0;
        if (prevIdx == -1 || a[idx] > a[prevIdx]) {
            take = 1 + help(a, idx + 1, idx);
        }

        return dp[idx][prevIdx + 1] = Math.max(take, skip);
    }

    public int lengthOfLIS(int[] nums) {

        int n = nums.length;
        dp = new int[n][n + 1];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return help(nums, 0, -1);
    }
}