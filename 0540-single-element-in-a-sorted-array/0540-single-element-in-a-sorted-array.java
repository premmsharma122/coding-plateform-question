class Solution {
    public int singleNonDuplicate(int[] nums) {
        int l = 0, h = nums.length - 1;

        while (l < h) {
            int mid = l + (h - l) / 2;

            boolean isEven = ((h - mid) % 2 == 0);

            if (mid < h && nums[mid] == nums[mid + 1]) {

                if (isEven) {
                    l = mid + 2;
                } else {
                    h = mid - 1;
                }

            } else if (mid > l && nums[mid] == nums[mid - 1]) {

                if (isEven) {
                    h = mid - 2;
                } else {
                    l = mid + 1;
                }

            } else {
                return nums[mid];
            }
        }

        return nums[l];
    }
}