class Solution {
    int memo[][];
    public int help(int arr[], int day, int n, int buy){
        if(day>=n) return 0;
        if(memo[day][buy] != -1) return memo[day][buy];
        
        int res=0;
        if(buy==1){
            int tk = help(arr,day+1,n,0) - arr[day];
            int sk = help(arr,day+1,n,1);
            res = Math.max(tk,sk);
        }else{
            int sell = help(arr,day+2,n,1) + arr[day];
            int notsell = help(arr,day+1,n,0);
            res = Math.max(sell,notsell);
        }
        return memo[day][buy]=res;
    }
    public int maxProfit(int[] prices) {
        memo = new int[prices.length+1][2];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        return help(prices,0,prices.length,1);
    }
}
