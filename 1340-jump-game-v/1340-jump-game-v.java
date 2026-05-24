class Solution {
    int dp[];
    public int dfs(int arr[], int cur, int d){
        if(dp[cur]!=0) return dp[cur];
        int c=1;
        for(int nxt=cur+1; nxt<=Math.min(arr.length-1,cur+d); nxt++){
            if(arr[nxt]>=arr[cur]) break;
            c=Math.max(c, 1+dfs(arr,nxt,d));
        }
        for(int nxt =cur-1; nxt>=Math.max(0,cur-d); nxt--){
            if(arr[nxt]>=arr[cur]) break;
            c= Math.max(c,1+dfs(arr,nxt,d));
        }
        return dp[cur]=c;

    }
    public int maxJumps(int[] arr, int d) {
        dp = new int[arr.length];
        int ans =1;
        for(int i=0; i<arr.length; i++){
            ans = Math.max(ans,dfs(arr,i,d));
        }
        return ans;
    }
}