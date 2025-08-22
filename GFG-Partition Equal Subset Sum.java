class Solution {
    static boolean help(int arr[], int trg, int idx){
        if(trg == 0) return true;
        if(idx == arr.length || trg < 0) return false;
        return help(arr,trg-arr[idx],idx+1) || help(arr,trg,idx+1);
    }
    static boolean equalPartition(int arr[]) {
        // code here
        int sum = 0;
        for(int n : arr){
            sum += n;
        }
        int trg = sum/2;
        if(sum % 2 !=0) return false;
        return help(arr,trg, 0);
    }
}
// >>>>>>>>>> DP <<<<<<<<<<
class Solution {
    static boolean equalPartition(int arr[]) {
        // code here
        int sum =0;
        int n = arr.length;

        for(int nm : arr){
            sum += nm;
        }
    
        if(sum % 2 != 0) return false;
        int trg = sum/2;
        boolean dp[][] = new boolean[arr.length+1][trg+1];
        for(int i=0; i<=n; i++){
            dp[i][0] = true;
        }
        for(int j=1; j<=trg; j++){
            dp[0][j] = false;
        }
        for(int i=1; i<=n; i++){
            for(int j=1; j<=trg; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][trg];
    }
}
