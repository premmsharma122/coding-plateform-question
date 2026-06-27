class Solution {
    public boolean help(long m, int arr[] , int n){
       long trg = n*m;
       long sum=0;
       for(int i=0; i<arr.length; i++){
        sum+=Math.min(m,arr[i]);
        if(sum>=trg) return true;
       }
       return false;
    }
    public long maxRunTime(int n, int[] batteries) {
        long min =0, tot=0;
        for(int a : batteries){
            tot+=a;
            min = Math.min(min,a);
        }
        long ans =0;
        long l = min, h= tot/n;
        while(l<=h){
            long mid  = l+(h-l)/2;
            if(help(mid,batteries,n)){
                ans =mid;
                l=mid+1;
            }else h=mid-1;
        }
        return ans;
    }
}