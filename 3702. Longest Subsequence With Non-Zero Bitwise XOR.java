class Solution {
    public int longestSubsequence(int[] nums) {
        int ans=0;
        boolean c =true;
        for(int a : nums){
            ans ^= a;
            if(a != 0) c = false;
        }
        if(c) return 0;
        if(ans == 0) return nums.length-1;
        
        return nums.length;
    }
}
