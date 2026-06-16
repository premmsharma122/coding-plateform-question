class Solution {
    public boolean help(int m, int arr[], int h){
        long s=0;
        for(int a : arr){
            s+=a/m;
            if(a%m!=0){
                s++;
            }
        }
        if(s<=h) return true;
        return false;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int min=Integer.MAX_VALUE, max= Integer.MIN_VALUE;

        for(int a : piles){
            max= Math.max(max,a);
        }
        int l=1, hg=max;
        int ans=0;
        while(l<=hg){
            int mid = l+(hg-l)/2;
            if(help(mid,piles,h)){
                ans = mid;
                hg=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;

    }
}