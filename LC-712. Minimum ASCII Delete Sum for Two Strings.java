class Solution {
    static int dp[][];
    public int help(String s , String trg, int i, int j){

        if(i==s.length()){
            int sm = 0;
            for(int k=j; k<trg.length(); k++){
                sm+=trg.charAt(k);
            }
            return sm;
        }
        if(j==trg.length()){
            int sm = 0;
            for(int l=i; l<s.length(); l++){
                sm+=s.charAt(l);
            }
            return sm;
        }
        if(dp[i][j] != -1) return  dp[i][j];

        if(s.charAt(i)==trg.charAt(j)){
            return dp[i][j] =  help(s,trg,i+1,j+1);
        }else{
            int a1 = s.charAt(i)+help(s,trg,i+1,j);
            int a2 = trg.charAt(j)+help(s,trg,i,j+1);
            return dp[i][j] =  Math.min(a1,a2);
        }
    }
    public int minimumDeleteSum(String s1, String s2) {
        dp = new int[s1.length()+1][s2.length()+1];
        for(int i=0; i<dp.length; i++){
            Arrays.fill(dp[i],-1);
        }
        return help(s1,s2,0,0);
    }
}
