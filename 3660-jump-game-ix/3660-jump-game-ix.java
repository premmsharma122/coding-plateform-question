class Solution {
    public int[] maxValue(int[] nums) {
        int pmx[] = new int[nums.length];
        int smn[] = new int[nums.length];
        pmx[0]=nums[0];
        for(int i=1; i<nums.length; i++){
            pmx[i] = Math.max(nums[i],pmx[i-1]);
        }
        smn[nums.length-1] = nums[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            smn[i] = Math.min(smn[i+1],nums[i]);
        }
        int ans[] = new int[nums.length];
        ans[nums.length-1] = pmx[nums.length-1];
        for(int i=nums.length-2; i>=0; i--){
            if(pmx[i]>smn[i+1]){
                ans[i] = ans[i+1];
            }else{
                ans[i] = pmx[i];
            }
        }
        return ans;
    }
}