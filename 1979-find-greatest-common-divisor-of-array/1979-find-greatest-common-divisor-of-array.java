class Solution {
    public int gcd(int a , int b){
        while(b!=0){
            int tm = a%b;
            a=b;
            b=tm;
        }
        return a;
    }
    public int findGCD(int[] nums) {
        int min= Integer.MAX_VALUE;
        int mx=Integer.MIN_VALUE;
        for(int n : nums){
            min=Math.min(min,n);
            mx= Math.max(mx,n);
        }
        return gcd(min,mx);
    }
}