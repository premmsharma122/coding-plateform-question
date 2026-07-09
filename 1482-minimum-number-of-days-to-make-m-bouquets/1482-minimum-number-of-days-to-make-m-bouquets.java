class Solution {
    public boolean help(int mid, int arr[],int m, int k){
        int f=0,b=0;
        for(int i=0; i<arr.length; i++){
            if(arr[i]<=mid){
                f++;
                if(f==k){
                    b++;
                    f=0;
                }
            }else{
                f=0;
            }
        }
        return b>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int min=10000,max=0;
        if(m*k>bloomDay.length) return  -1;
        for(int a : bloomDay ){
            min=Math.min(min,a);
            max=Math.max(max,a);
        }
        int l=min, r=max, ans=-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(help(mid,bloomDay,m,k)){
                ans =mid;
                r=mid-1;
            }else l=mid+1;
        }
        return ans;
    }
}