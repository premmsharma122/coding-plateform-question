class Solution {
    public int maxProduct(int[] nums) {

        int ans=nums[0];
        for(int a : nums) ans=Math.max(ans,a);
        for(int i=0; i<nums.length; i++){
            int p=nums[i];
            for(int j=i+1; j<nums.length; j++){
                p*=nums[j];
                ans=Math.max(ans,p);
            }
        }
        return ans;
    }
}