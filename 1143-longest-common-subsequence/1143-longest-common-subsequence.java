class Solution {
    int dp[][];
    public int help(String s1, String s2,  int i, int j){
        if(i>=s1.length() || j>=s2.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans=0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans=  1+help(s1,s2,i+1,j+1);
        }
            return dp[i][j]=Math.max(ans, Math.max(help(s1,s2,i+1,j),help(s1,s2,i,j+1)));
    
    }
    public int longestCommonSubsequence(String text1, String text2) {
        dp = new int[text1.length()][text2.length()];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return help(text1,text2,0,0);
    }
}