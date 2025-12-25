// class Solution {
//     int[][] memo;

//     public int help(String s, int i, int j){
//         if(palin(s,i,j)) return 0;
//         if(memo[i][j] != -1) return memo[i][j];
//         int min = Integer.MAX_VALUE;

//         for(int k=i; k<=j-1; k++){
//             int r = 1 + help(s,i,k) + help(s,k+1,j);
//             memo[i][j] = min = Math.min(min,r);
//         }
//         return memo[i][j];
//     }
//     public boolean palin(String s, int i, int j){
//         while(i<j){
//             if(s.charAt(i) != s.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;

//     }
//     public int minCut(String s) {
//         memo = new int[2001][2001];
//         for(int i=0; i<memo.length; i++){
//             Arrays.fill(memo[i],-1);
//         }
//         return help(s,0,s.length()-1);
//     }
// }
import java.util.*;

class Solution {
    int[][] memo;
    boolean[][] isPal;

    public int help(String s, int i, int j) {
        if (i >= j) return 0;
        if (isPal[i][j]) return 0;
        if (memo[i][j] != -1) return memo[i][j];

        int min = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            if (isPal[i][k]) {
                min = Math.min(min, 1 + help(s, k + 1, j));
            }
        }

        return memo[i][j] = min;
    }

    public int minCut(String s) {
        int n = s.length();
        memo = new int[n][n];
        isPal = new boolean[n][n];

        for (int i = 0; i < n; i++)
            Arrays.fill(memo[i], -1);

        for (int g = 0; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                if (g == 0) isPal[i][j] = true;
                else if (g == 1) isPal[i][j] = (s.charAt(i) == s.charAt(j));
                else
                    isPal[i][j] = (s.charAt(i) == s.charAt(j)) && isPal[i + 1][j - 1];
            }
        }

        return help(s, 0, n - 1);
    }
}
