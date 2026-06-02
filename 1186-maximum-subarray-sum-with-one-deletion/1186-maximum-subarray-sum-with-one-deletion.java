class Solution {
    int arr[];
    Integer dp[][];

    public int help(int idx, int del){
       if(idx==0){
        return arr[0];
       }
       if(dp[idx][del]!=null){
        return dp[idx][del];
       }
       int ans;

        if(del==0){
            ans= arr[idx]+ Math.max(0,help(idx-1,0));
        }else{
            int kp = arr[idx]+Math.max(0,help(idx-1,1));
            int dl = help(idx-1,0);
            ans= Math.max(kp,dl);
        }
        return dp[idx][del]= ans;
        

    }
    public int maximumSum(int[] arr) {
        this.arr=arr;
        int ans =arr[0];
        int n =arr.length;
        dp=new Integer[n][2];
        for(int i=0; i<arr.length; i++){
            ans = Math.max(ans,help(i,0));
            ans = Math.max(ans,help(i,1));
        }
        return ans;
    }
}