class Solution {
    int mod = 1000000007;
    Integer[][][] dp;

    int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    int help(int[] nums, int idx, int g1, int g2) {

        if (idx == nums.length) {
            return (g1 != 0 && g1 == g2) ? 1 : 0;
        }

        if (dp[idx][g1][g2] != null)
            return dp[idx][g1][g2];

        long ans = 0;

        ans += help(nums, idx + 1, g1, g2);

        ans += help(nums, idx + 1, gcd(g1, nums[idx]), g2);
        
        ans += help(nums, idx + 1, g1, gcd(g2, nums[idx]));

        return dp[idx][g1][g2] = (int) (ans % mod);
    }

    public int subsequencePairCount(int[] nums) {
        int mx = 0;
        for (int x : nums)
            mx = Math.max(mx, x);
        dp = new Integer[nums.length][mx + 1][mx + 1];
        return help(nums, 0, 0, 0);
    }
}