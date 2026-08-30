class Solution {
    public int minimumDeletions(int[] nums) {
        int minidx=-1,maxidx=-1, min=Integer.MAX_VALUE, max=Integer.MIN_VALUE;
        if(nums.length==1) return 1;
        if(nums.length==2) return 2;
        for(int i=0; i<nums.length; i++){
            if(min>nums[i]){
                min=nums[i];
                minidx=i;
            } if(max<nums[i]){
                max=nums[i];
                maxidx=i;
            }
        }
        int left = Math.min(minidx, maxidx);
        int right = Math.max(minidx, maxidx);

        int ans1 = right + 1;
        int ans2 = nums.length - left;
        int ans3 = (left + 1) + (nums.length - right);
        return Math.min(ans1, Math.min(ans2, ans3));
    }
} 
