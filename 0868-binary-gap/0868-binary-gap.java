class Solution {
    public String help(int num){
        StringBuilder sb = new StringBuilder();
        while(num>0){
            int r = num%2;
            sb.append(r);
            num/=2;
        }
        return sb.toString();
    }
    public int binaryGap(int n) {
        String s = help(n);
        int m= Integer.MIN_VALUE,idx=0;
        while(idx<s.length()){
            char  a = s.charAt(idx);
            if(idx+1< s.length() && a=='1'){
                char nxt =s.charAt(idx+1);
                int c=0;
                while(idx+1<s.length() && nxt=='0'){
                    c++;
                    m= Math.max(c,m);
                    idx++;
                }
            }
                idx++;
        }
        return m==Integer.MIN_VALUE? 0:m;
        
    }
}