class Solution {
    int[][] dp;

    public int help(int e, int f){
        if(f==0 || f==1) return f;
        if(e == 1) return f;
        if(dp[e][f] != -1) return dp[e][f];

        int min = Integer.MAX_VALUE;
        for(int k=1; k<=f; k++){
            int tmp = 1 + Math.max(help(e-1,k-1), help(e,f-k));
            min = Math.min(min, tmp);
        }
        return dp[e][f] = min;
    }

    public int twoEggDrop(int n) {
        dp = new int[3][n+1];   // only 2 eggs needed
        for(int i=0; i<3; i++){
            Arrays.fill(dp[i], -1);
        }
        return help(2,n);
    }
}
