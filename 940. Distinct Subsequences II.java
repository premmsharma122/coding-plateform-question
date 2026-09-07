// class Solution {

//     private static final int MOD = 1_000_000_007;
//     private long[] dp;
//     private int[] last;

//     public long help(String s, int i) {

//         if (i == s.length()) {
//             return 1; // empty subsequence
//         }

//         if (dp[i] != -1) {
//             return dp[i];
//         }

//         char ch = s.charAt(i);

//         // Take or don't take current character
//         long ans = 2 * help(s, i + 1);

//         // Remove duplicates caused by previous occurrence
//         if (last[ch - 'a'] != -1) {
//             ans -= help(s, last[ch - 'a'] + 1);
//         }

//         return dp[i] = (ans + MOD) % MOD;
//     }

//     public int distinctSubseqII(String s) {

//         int n = s.length();

//         dp = new long[n];
//         Arrays.fill(dp, -1);

//         last = new int[26];
//         Arrays.fill(last, -1);

//         // Store last occurrence of every character
//         for (int i = 0; i < n; i++) {
//             last[s.charAt(i) - 'a'] = i;
//         }

//         // Includes empty subsequence
//         long ans = help(s, 0);

//         // Remove empty subsequence
//         return (int)((ans - 1 + MOD) % MOD);
//     }
// }

class Solution {

    private static final int MOD = 1_000_000_007;
    private long[] dp;

    public long help(String s, int i) {

        if (i == s.length()) {
            return 1; // empty subsequence
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        // Don't take s[i]
        long ans = help(s, i + 1);

        // Take s[i]
        ans += help(s, i + 1);

        // Find next occurrence of same character
        int next = i + 1;

        while (next < s.length() &&
               s.charAt(next) != s.charAt(i)) {
            next++;
        }

        // If same character appears again,
        // remove duplicate subsequences
        if (next < s.length()) {
            ans -= help(s, next + 1);
        }

        return dp[i] = (ans + MOD) % MOD;
    }

    public int distinctSubseqII(String s) {

        int n = s.length();

        dp = new long[n];
        Arrays.fill(dp, -1);

        long ans = help(s, 0);

        // Remove empty subsequence
        return (int)((ans - 1 + MOD) % MOD);
    }
}
