class Solution {
    int mod = 1000000007;
    Long[][][] dp;
    int min, max;
    public long help(String s , int idx, int t, int sum){
        if(sum>max) return 0;
        if(idx==s.length()){
            return (sum>=min && sum<=max) ?1:0;
        }
        if(dp[idx][t][sum]!=null) return dp[idx][t][sum];
        long ans=0;
        int ub = (t==1) ?s.charAt(idx)-'0':9;
        for(int i=0; i<=ub; i++){
            int nt = (t==1 && i==ub)?1:0;
            ans =(ans+help(s,idx+1,nt,sum+i))%mod;
        }
        return dp[idx][t][sum]=ans;
    }
    public long count(String s){
        dp = new Long[s.length()][2][401];
        return help(s,0,1,0);
    }
    
    public String sub(String s){

    StringBuilder sb = new StringBuilder(s);

    int i = sb.length()-1;

    while(i>=0 && sb.charAt(i)=='0'){
        sb.setCharAt(i,'9');
        i--;
    }

    if(i>=0){
        sb.setCharAt(i,(char)(sb.charAt(i)-1));
    }

    int start = 0;

    while(start < sb.length()-1 &&
          sb.charAt(start)=='0'){
        start++;
    }

    return sb.substring(start);

    }
    public int count(String num1, String num2, int min_sum, int max_sum) {
        min=min_sum;
        max=max_sum;
        long right = count(num2);
        String oneminus = sub(num1);
        long left = oneminus.equals("0")?0:count(oneminus);
        return (int)((right-left + mod)%mod);

    }
}