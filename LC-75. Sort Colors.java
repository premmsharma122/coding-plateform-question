//  Dutch National Flag (Sort Colors)
class Solution {
    public void sortColors(int[] nums) {
        int i = 0, j = 0, m = nums.length - 1;

        while (i <= m) {
            if (nums[i] == 2) {
                int tmp = nums[i];
                nums[i] = nums[m];
                nums[m] = tmp;
                m--;
            } 
            else if (nums[i] == 1) {
                i++;
            } 
            else { // nums[i] == 0
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
                j++;
            }
        }
    }
}
