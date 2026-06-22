class Solution {
    public long help(int num[], int cost[], int m){
        long ans =0;
        for(int i=0; i<num.length; i++){
            ans += Math.abs((long)num[i]-m)*cost[i];
        }
        return ans;
        
    }
    public long minCost(int[] nums, int[] cost) {
        int min=0, max=0;
        for(int a : nums){
            min= Math.min(a,min);
            max= Math.max(a,max);
        }
        int l=min, h=max;
        long ans = Long.MAX_VALUE;
        while(l<=h){
            int mid = l+(h-l)/2;
            long c1 = help(nums,cost,mid);
            long c2 = help(nums,cost,mid+1);
            ans = Math.min(c1,c2);
            if(c1<c2){
                h=mid-1;
            }else{
                l= mid+1;
            }
        }
        return ans==Long.MAX_VALUE ? 0:ans;
    }
}