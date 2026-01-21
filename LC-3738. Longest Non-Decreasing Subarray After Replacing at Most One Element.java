class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        if (n <= 2) return n;
        int l[] = new int[n], r[] = new int[n];
        Arrays.fill(r, 1); 
        Arrays.fill(l, 1);

        for (int i = 1; i < n; i++) 
            if (nums[i - 1] <= nums[i]) 
                l[i] = l[i - 1] + 1;

        for (int i = n - 2; i >= 0; i--) 
            if (nums[i + 1] >= nums[i]) 
                r[i] = r[i + 1] + 1;

        int ans = Math.max(l[0], r[n - 1]);
        for (int i = 1; i < n - 1; i++) 
            if (nums[i - 1] <= nums[i + 1]) 
                ans = Math.max(ans, l[i - 1] + r[i + 1] + 1);
            else 
                ans = Math.max(ans, Math.max(l[i] + 1, r[i] + 1));

        return ans;
    }
}
