class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        
        long[] dp = new long[n];
        
        // Initialize dp with the first row points
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }
        
        for (int i = 1; i < m; i++) {
            long[] newDp = new long[n];

            // Calculate the maximum from the left
            long[] leftMax = new long[n];
            leftMax[0] = dp[0];
            for (int j = 1; j < n; j++) {
                leftMax[j] = Math.max(leftMax[j - 1] - 1, dp[j]);
            }
            
            // Calculate the maximum from the right
            long[] rightMax = new long[n];
            rightMax[n - 1] = dp[n - 1];
            for (int j = n - 2; j >= 0; j--) {
                rightMax[j] = Math.max(rightMax[j + 1] - 1, dp[j]);
            }
            
            // Calculate the new dp based on leftMax, rightMax, and points
            for (int j = 0; j < n; j++) {
                newDp[j] = points[i][j] + Math.max(leftMax[j], rightMax[j]);
            }
            
            dp = newDp;
        }

        long maxPoints = 0;
        for (long val : dp) {
            maxPoints = Math.max(maxPoints, val);
        }
        
        return maxPoints;
    }
}
