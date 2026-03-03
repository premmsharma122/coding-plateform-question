class Solution {
    int dp[][];
    public int help(int k, int f){
        if(f==0 || f==1) return f;
        if(k==1) return f;
        if(dp[k][f]!=-1) return dp[k][f];

        int low = 1, high=f, min=Integer.MAX_VALUE;
        while(low<=high){
            int mid = (low+high)/2;
            int d= help(k-1,mid-1);
            int up = help(k,f-mid);
            int w = 1+Math.max(d,up);
            if(d>up){
                high = mid-1;
                min=Math.min(w,min);
            }else{
                low=mid+1;
                min=Math.min(min,w);
            }
        }
        return dp[k][f] = min;
    }

    
    public int superEggDrop(int k, int n) {
        dp = new int[k+1][n+1];
        for(int i=0; i<=k; i++){
            Arrays.fill(dp[i], -1);
        }
        return help(k, n);
    }
}