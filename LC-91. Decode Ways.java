class Solution {
    
    public int help(String s, int idx, int memo[]){
        if(idx==s.length()){
            return 1;
        }
        if(memo[idx]!=-1) return memo[idx];
        if(s.charAt(idx)=='0') return 0;
        int w = help(s,idx+1,memo);
        if(idx+1 < s.length()){
            int n = (s.charAt(idx)-'0')*10 + s.charAt(idx+1)-'0';
            if(n>=10 && n<=26){
                 w += help(s,idx+2,memo);
            }
        }
        memo[idx] = w;
        return memo[idx];
    }
    public int numDecodings(String s) {
        int memo[] = new int[101];
        Arrays.fill(memo,-1);
 
        return help(s,0,memo);
        
    }
}
