class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Map<Integer,Long> map = new HashMap<>();
        long prefixsum=0;
        long maxSum=Long.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            if(map.getOrDefault(nums[i],Long.MAX_VALUE)>prefixsum)
            {
                 map.put(nums[i],prefixsum);
            }
            prefixsum+=nums[i];
            if(map.containsKey(nums[i]-k))
            {
                 maxSum=Math.max(maxSum,prefixsum-map.get(nums[i]-k));
            }
            if(map.containsKey(nums[i]+k))
            {
                 maxSum=Math.max(maxSum,prefixsum-map.get(nums[i]+k));
            }
        }
        return maxSum==Long.MIN_VALUE ? 0 : maxSum;
    }
}
