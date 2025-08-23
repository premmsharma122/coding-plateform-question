class Solution {
    public static int help(String s1, String s2, int n1, int n2, int dp[][]) {
        if (n1 < 0 || n2 < 0) return 0;
        if (dp[n1][n2] != -1) return dp[n1][n2];
        if (s1.charAt(n1) == s2.charAt(n2)) {
            dp[n1][n2] = 1 + help(s1, s2, n1 - 1, n2 - 1, dp);
        } else {
            dp[n1][n2] = Math.max(
                help(s1, s2, n1 - 1, n2, dp),
                help(s1, s2, n1, n2 - 1, dp)
            );
        }
        return dp[n1][n2];
    }

    public String shortestCommonSupersequence(String str1, String str2) {
        String s1=str1;
        String s2 = str2;
        int n1 = s1.length();
        int n2 = s2.length();
        int dp[][] = new int[n1][n2];
        for (int i = 0; i < n1; i++) {
            Arrays.fill(dp[i], -1);
        }

        
        help(s1, s2, n1 - 1, n2 - 1, dp);

        
        StringBuilder sb = new StringBuilder();
        int i = n1 - 1, j = n2 - 1;

        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                sb.append(s1.charAt(i));
                i--;
                j--;
            } else {
                
                if (i > 0 && dp[i - 1][j] >= (j > 0 ? dp[i][j - 1] : -1)) {
                    sb.append(s1.charAt(i));
                    i--;
                } else {
                    sb.append(s2.charAt(j));
                    j--;
                }
            }
        }

        while (i >= 0) sb.append(s1.charAt(i--));
        while (j >= 0) sb.append(s2.charAt(j--));

        return sb.reverse().toString();
    }
}
