class Solution {
    public boolean help(int m, int[] arr) {
    long sum = 0;

    for (int i = 0; i < arr.length; i++) {
        sum += arr[i];

        if (sum > (long)(i + 1) * m) {
            return false;
        }
    }
    return true;
}
    public int minimizeArrayValue(int[] nums) {
        int m =Integer.MIN_VALUE;
        for(int a : nums){
            m = Math.max(m,a);
        }
        int l = 0, h=m;
        int ans=0;
        while(l<=h){
            int mid  = l+(h-l)/2;
            if(help(mid,nums)){
                ans = mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}