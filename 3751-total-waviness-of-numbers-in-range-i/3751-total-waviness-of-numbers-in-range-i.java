class Solution {
    public int totalWaviness(int num1, int num2) {
        int ans=0;
        for(int k=num1; k<=num2; k++){
            String st = String.valueOf(k);
            if(st.length()<3){
                continue;
            }
            int c =0;
            for(int i=1; i<st.length()-1; i++){
                int lst = st.charAt(i-1)-'0';
                int cr = st.charAt(i)-'0';
                int nxt = st.charAt(i+1)-'0';
                boolean check = cr > lst && cr > nxt;
                boolean ch2 = cr < lst && cr < nxt;
                
                if(check || ch2) c++;
            }
            ans += c;
        }
        return ans;
    }
}