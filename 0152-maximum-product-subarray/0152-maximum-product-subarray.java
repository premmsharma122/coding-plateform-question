class Solution {
    int ans;
    public void help(int[] nums, int idx, int max, int min) {
        if (idx == nums.length) return;
        int curr = nums[idx];
        if (curr < 0) {
            int temp = max;
            max = min;
            min = temp;
        }

        max = Math.max(curr, max * curr);
        min = Math.min(curr, min * curr);

        ans = Math.max(ans, max);

        help(nums, idx + 1, max, min);
    }

    public int maxProduct(int[] nums) {

        ans = nums[0];

        help(nums, 1, nums[0], nums[0]);

        return ans;
    }
}