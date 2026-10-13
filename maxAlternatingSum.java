
class Solution {
    public long maxAlternatingSum(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        long sum = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            if (i < n / 2) {
                sum -= nums[i];
            } else {
                sum += nums[i];
            }
        }

        return sum;
    }
}
