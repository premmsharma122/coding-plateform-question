class Solution {
    public boolean help(int arr[], int mid, long k){
        long c=0;
        for(int i=0; i<arr.length; i++){
            c+=arr[i]/mid;
        }
        return c>=k;
    }
    public int maximumCandies(int[] candies, long k) {
        int mx=0;
        for(int a : candies){
            mx=Math.max(mx,a);
        }
        int l=1, r=mx,res=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(help(candies,mid,k)){
                res=mid;
                l=mid+1;
            }else{
                r=mid-1;
            }
        }
        return res;
    }
}