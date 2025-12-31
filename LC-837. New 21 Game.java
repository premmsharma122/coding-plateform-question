// class Solution {
//     public double new21Game(int n, int k, int maxPts) {
//         double arr[] = new double[n+1];
//         arr[0]=1.0;
//         for(int i=1; i<=n; i++){
//             for(int c=1; c<=maxPts; c++){
//                 if(i-c >= 0 && i-c <k){
//                     arr[i] += arr[i-c]/maxPts;
//                 }
//             }
//         }
//         double res=0;
//         for(int i=k; i<=n; i++){
//             res+=arr[i];
//         }
//         return res;
//     }
// }

// Optimized code version
class Solution {
    public double new21Game(int n, int k, int maxPts) {

        // edge case
        if (k == 0 || n >= k + maxPts) return 1.0;

        double[] dp = new double[n + 1];
        dp[0] = 1.0;

        double windowSum = 1.0; // dp[0]
        double ans = 0.0;

        for (int i = 1; i <= n; i++) {
            dp[i] = windowSum / maxPts;

            // agar i < k hai → future transitions me add hoga
            if (i < k) {
                windowSum += dp[i];
            } else {
                // final valid scores
                ans += dp[i];
            }

            // sliding window shrink
            if (i - maxPts >= 0) {
                windowSum -= dp[i - maxPts];
            }
        }

        return ans;
    }
}
