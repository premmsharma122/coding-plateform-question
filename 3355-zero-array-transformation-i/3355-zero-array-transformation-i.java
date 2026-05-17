class Solution {

    public boolean isZeroArray(int[] nums, int[][] queries) {

        int n = nums.length;

        int diff[] = new int[n + 1];

        for (int q[] : queries) {

            int l = q[0];
            int r = q[1];

            diff[l] += 1;
            diff[r + 1] -= 1;
        }

        int cur = 0;

        for (int i = 0; i < n; i++) {

            cur += diff[i];

            if (cur < nums[i]) return false;
        }

        return true;
    }
}