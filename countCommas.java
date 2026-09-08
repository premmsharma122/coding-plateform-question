class Solution {
    public int countCommas(int n) {
        if(n<1000) return 0;
        if(n>=1000 && n<10000){
            return (n-1000+1);
        }
        if(n>=10000 && n<=100000){
            int three = 10000-1000;
            int four = n-10000+1;
            return three+four;
        }
        return 0;
        
    }
}
