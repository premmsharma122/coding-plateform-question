class Solution {
    public boolean check(int[] nums) {
        int flag =-1;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]> nums[i+1]){
                flag = i;
                break;
            }
        }
        if (flag ==-1){
            return true;
        }
        for(int j=flag+1; j<nums.length; j++){
            int nxt = (j+1)%nums.length;
            if(nums[nxt]< nums[j]){
                return false;
            }
        }
        return true;
    }
}