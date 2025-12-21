class Solution {
    int dp[][];
    int memo[];
    public int help(int idx){
        if(idx==dp.length) return 0;

        if(memo[idx] != -1) return memo[idx];

        int sk = help(idx+1);
        int nx = idx+1;
        while(nx < dp.length && dp[nx][0] < dp[idx][1]){
            nx++;
        }
        
        int tk = dp[idx][2] +  help(nx);
        return memo[idx]=  Math.max(tk,sk);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int l = startTime.length;
        dp = new int[l][3];
        for(int i=0; i<l; i++){
            dp[i][0] = startTime[i];
            dp[i][1] = endTime[i];
            dp[i][2] = profit[i];
        }
        memo = new int[l];
        Arrays.fill(memo,-1);
        Arrays.sort(dp,(a,b)-> a[0]-b[0]);
        return help(0);
    }
}
