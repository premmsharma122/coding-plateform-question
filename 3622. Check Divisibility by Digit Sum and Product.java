class Solution {
    public static int sum(int n1){
        int s =0;
        while(n1>0){
            int r = n1%10;
            s+=r;
            n1=n1/10;
        }
        return s;
    }
     public static int mul(int n2){
        int s2 =1;
        while(n2>0){
            int r = n2%10;
            s2*=r;
            n2=n2/10;
        }
        return s2;
    }
    public boolean checkDivisibility(int n) {
        int s1 = sum(n);
        int s2 = mul(n);
        int ans = s1+s2;
        if(n%ans == 0) return true;
        return false;
    }
}
