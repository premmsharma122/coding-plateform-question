class Solution {
    static int dp[][];

    public int help(int num, int trg){
        if(trg == 0) return 0;
        if(num * num > trg) return Integer.MAX_VALUE;

        if(dp[num][trg] != -1) return dp[num][trg];

        int ans1 = help(num, trg - num*num);
        if(ans1 != Integer.MAX_VALUE) ans1 += 1;

        int ans2 = help(num + 1, trg);

        return dp[num][trg] = Math.min(ans1, ans2);
    }

    public int numSquares(int n) {
        dp = new int[101][n + 1];

        for(int i = 0; i <= 100; i++){
            Arrays.fill(dp[i], -1);
        }

        return help(1, n);
    }
}