class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);

        int avg = nums[nums.length / 2];

        int ans = 0;
        for (int a : nums) {
            ans += Math.abs(a - avg);
        }

        return ans;
    }
}
