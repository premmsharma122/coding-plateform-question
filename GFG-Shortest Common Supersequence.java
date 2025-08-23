// User function Template for Java

class Solution {
    public static int help(String s1, String s2, int n1, int n2, int dp[][]){
        if(n1<0 || n2 < 0) return 0;
        if(dp[n1][n2] != -1) return dp[n1][n2];
        if(s1.charAt(n1) == s2.charAt(n2)){
            dp[n1][n2] = 1+ help(s1,s2,n1-1,n2-1,dp);
        }else{
            dp[n1][n2] = Math.max(help(s1,s2,n1-1,n2,dp), help(s1,s2,n1,n2-1,dp));            
        }
        return dp[n1][n2];
    }
    // Function to find length of shortest common supersequence of two strings.
    public static int shortestCommonSupersequence(String s1, String s2) {
        // Your code here
        int n1 = s1.length()-1, n2 = s2.length()-1;
        int dp[][] = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<=s1.length(); i++){
            Arrays.fill(dp[i], -1);
        }
        
        int tot=help(s1,s2,n1,n2,dp);
        
        return (n1+1+n2+1)-tot;
        
    }
}
