class Solution {
    public int missingInteger(int[] nums) {
        int s=nums[0], m = Integer.MIN_VALUE;
        Set<Integer> seen = new HashSet<>();
        for (int num : nums)
            seen.add(num);
        for(int i=1; i<nums.length; i++){
            if(nums[i]==nums[i-1]+1){
                s+=nums[i];    
            }else break;
            
        }
        while(seen.contains(s)){
            s++;
        }
        return s;
    }
}
