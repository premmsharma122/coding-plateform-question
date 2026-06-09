class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int a1 = Integer.MIN_VALUE;
        int a2 = Integer.MAX_VALUE;
        
        for(int i=0; i<nums.length; i++){
            a1=Math.max(a1, nums[i]);
            a2= Math.min(a2,nums[i]);
        }
        long res = a1 - a2;
        return (long)k*res;
    }
}