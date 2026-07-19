class Solution {
    public boolean help(int ar[], int m, int k){
        int h =0;
        for(int i=0; i<ar.length; i++){
            if(ar[i]<=m){
                h++;
                i++;
            }
        }
        return h>=k;
    }
    public int minCapability(int[] nums, int k) {
        int min=1000,mx=0;
        for(int a : nums){
            min=Math.min(min,a);
            mx= Math.max(a,mx);
        }

        int l=min, r=mx,ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(help(nums,mid,k)){
                ans=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}