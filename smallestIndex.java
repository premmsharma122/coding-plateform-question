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
    public int smallestIndex(int[] nums) {
        int ans=100000000;
        for(int i=0; i<nums.length; i++){
             if(i==help(nums[i])){
                ans=Math.min(ans,i);
            }
        }
        return ans==100000000?-1:ans;
    }
}
