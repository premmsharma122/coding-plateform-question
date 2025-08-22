class Solution {
    static boolean help(int arr[], int trg , int idx){
        if(trg ==0) return true;
        if(trg < 0 || idx == arr.length) return false;
        return help(arr, trg-arr[idx], idx+1) || help(arr,trg, idx+1);
        
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        boolean ans = help(arr,sum , 0);
        return ans;
        
    }
}
// >>>>>>>>>>>>> DP <<<<<<<<<<
class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        boolean dp[][] = new boolean[arr.length+1][sum+1];
        int n = arr.length;
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;  
        }
        for (int j = 1; j <= sum; j++) {
            dp[0][j] = false; 
        }
        
        for(int i=1;i <=n; i++){
            for(int j=1; j<=sum; j++){
                if(arr[i-1] <=j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
