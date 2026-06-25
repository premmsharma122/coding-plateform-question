class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int c=0;
        for(int i=0; i<nums.length; i++){
            HashMap<Integer, Integer> hm = new HashMap<>();
            int mj=-1, fre=0;
            for(int j=i; j<nums.length; j++){
                int cur = hm.getOrDefault(nums[j],0)+1;
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
                if(cur>fre){
                    fre = cur;
                    mj= nums[j];
                }
                int len = j-i+1;
                if(fre>len/2 && mj==target) c++;
            
            }

        }
        return c;
    }
}