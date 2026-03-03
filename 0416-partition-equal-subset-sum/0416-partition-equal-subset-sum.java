class Solution {
    Boolean dp[][];
    public boolean help(int a[], int trg,int idx, int cur ){
        if(idx>=a.length || cur>trg) return false;
        if(trg==cur) return true;
        if(dp[idx][cur]!=null) return dp[idx][cur];
        return dp[idx][cur] = help(a,trg,idx+1,cur+a[idx]) || help(a,trg,idx+1,cur);
    }
    public boolean canPartition(int[] nums) {
        int s=0;
        for(int a : nums){
            s+=a;
        }
        if(s%2!=0) return false;
        int t =s/2;
        dp = new Boolean[nums.length][t+1];
        return help(nums,s/2,0,0);
    }
}