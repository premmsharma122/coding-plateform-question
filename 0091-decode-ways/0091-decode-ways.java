class Solution {
    private int c=0;
    private int dp[];
    public int help(String s, int idx){
        if(idx==s.length()){
            return 1;
        }
        if(s.charAt(idx)=='0') return 0;
        if(dp[idx]!=-1) return dp[idx];
        int a1 =help(s,idx+1);
        int a2=0;
        if(idx+1<s.length()){
            int n = (s.charAt(idx)-'0')*10+s.charAt(idx+1)-'0';
            if(n>=10 && n<=26){
                a2=help(s,idx+2);
            }
        }
        return dp[idx]=a1+a2;
    }
    public int numDecodings(String s) {
        c=0;
        dp = new int[s.length()+1];
        Arrays.fill(dp,-1);
        return help(s,0);
        
    }
}