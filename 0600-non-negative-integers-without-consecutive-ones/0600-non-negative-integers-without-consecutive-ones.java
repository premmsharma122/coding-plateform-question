class Solution {
    int dp[][][];
    public int help(String s, int idx, int t,int prev){
        if(idx==s.length()) return 1;
        if(dp[idx][t][prev]!=-1) return dp[idx][t][prev];
        int res=0;
        int lb=0, ub=t==1?s.charAt(idx)-'0':1;
        for(int i=lb; i<=ub; i++){
            if(i==1 && prev==1){
                continue;
            }
            int nt = t==1 && i==ub?1:0;
            int nprev = i==1?1:0;
            res+=help(s,idx+1,nt,nprev);
        }
        return dp[idx][t][prev]=res;
    }
    public int findIntegers(int n) {
        dp = new int[30][2][2];
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[i].length; j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        String str = Integer.toBinaryString(n);
        int first = str.indexOf('1');
        String s = str.substring(first);
        return help(s,0,1,0);
    }
}