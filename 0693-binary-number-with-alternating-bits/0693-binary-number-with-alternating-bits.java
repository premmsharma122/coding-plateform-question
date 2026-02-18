class Solution {
    public boolean hasAlternatingBits(int n) {
        int prev =5;
        while(n>0){
            int r = n%2;
            n/=2;
            if(prev ==5){
                prev=r;
            }else{
                if(prev==r)return false;
                prev=r;
            }
        }
        return true;
    }
}