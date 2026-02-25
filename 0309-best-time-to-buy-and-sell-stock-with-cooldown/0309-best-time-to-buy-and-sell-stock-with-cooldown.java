class Solution {
    int memo[][];
    public int help(int arr[], int idx, int n, int buy){
        if(idx>=n) return 0;
        if(memo[idx][buy]!=-1) return memo[idx][buy];
        int res=0;
        if(buy==1){
            int tk = help(arr,idx+1,n,0)-arr[idx];
            int sk = help(arr,idx+1,n,1);
            res= Math.max(tk,sk);
        }else{
            int sel = help(arr,idx+2,n,1)+arr[idx];
            int nsel = help(arr,idx+1,n,0);
            res=Math.max(sel,nsel);
        }
        return memo[idx][buy]= res;
    }
    public int maxProfit(int[] prices) {
        memo= new int[prices.length][2];
        for(int i=0; i<memo.length; i++){
            Arrays.fill(memo[i],-1);
        }
        return help(prices,0,prices.length,1);
    }
}