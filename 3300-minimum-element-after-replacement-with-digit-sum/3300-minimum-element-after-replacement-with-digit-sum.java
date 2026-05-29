class Solution {
    public int help(int n){
        int s=0;
        while(n>0){
            int r = n%10;
            s+=r;
            n=n/10;
        }
        return s;
    }
    public int minElement(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            nums[i] = help(nums[i]);
            min = Math.min(min, nums[i]);
        }
        return min;
    }
}