class Solution {
    int[][] memo;
    public int help(String s, String t, int i, int j) {
        if (j < 0) return 1;
        if (i < 0) return 0;
        if(memo[i][j] != -1) return memo[i][j];
        if (s.charAt(i) == t.charAt(j)) {
            return memo[i][j] =  help(s, t, i-1, j-1) 
                 + help(s, t, i-1, j);
        } else {
            return memo[i][j] = help(s, t, i-1, j);
        }
    }
    public int numDistinct(String s, String t) {
        memo = new int[s.length()+1][t.length()+1];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        return help(s, t, s.length()-1, t.length()-1);
    }
}
