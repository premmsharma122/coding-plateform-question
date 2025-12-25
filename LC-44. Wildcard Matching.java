import java.util.*;

class Solution {
    int[][] memo;

    public boolean help(int i, int j, String s, String p) {

        if (i < 0 && j < 0) return true;
        if (j < 0 && i >= 0) return false;

        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*') return false;
            }
            return true;
        }

        if (memo[i][j] != -1)
            return memo[i][j] == 1;

        boolean res;

        if (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?') {
            res = help(i - 1, j - 1, s, p);
        }
        else if (p.charAt(j) == '*') {
            res = help(i - 1, j, s, p) || help(i, j - 1, s, p);
        }
        else {
            res = false;
        }

        memo[i][j] = res ? 1 : 0;
        return res;
    }

    public boolean isMatch(String s, String p) {
        memo = new int[s.length()][p.length()];
        for (int i = 0; i < memo.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return help(s.length() - 1, p.length() - 1, s, p);
    }
}
