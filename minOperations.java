class Solution {
    public int minOperations(int[] nums, int x) {
        int tot = 0;
        for(int n : nums){
            tot += n;
        }
        int curr=0, max = -1;
        if(tot < 0) return -1;
        if(tot == 0) return nums.length;
        int trg = tot - x, r=0;
        for(int l =0; l<nums.length; l++){
            curr+=nums[l];
            while(curr > trg && r <= l){
                curr-=nums[r];
                r++;
            }
            if(curr == trg ){
                max= Math.max(max , l-r+1);
            }
        }
        return max == -1 ? -1 : nums.length - max;
    }
}
