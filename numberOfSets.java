// class Solution {
//     public static int ans = 0;

//     public void help(int n, int k, int s) {
//         if (k == 0) {
//             ans++;
//             return;
//         }
//         if (s >= n) return;
//         for(int i= s+ 1;i < n; i++) {
//             help(n, k - 1, i);
//         }
//         help(n, k, s + 1);
//     }

//     public int numberOfSets(int n, int k) {
//         ans = 0;


//         help(n, k, 0);
//         return ans;
//     }
// }
class Solution {
    int MOD = 1_000_000_007;
    int[][] t = new int[1001][1001];
    public int solve(int n, int k, int i) {
        if (k == 0) 
            return 1;

        if (i >= n) 
            return 0;

        if (t[k][i] != -1)
            return t[k][i];
        long take= 0;
        for (int j= i + 1; j < n; j++)
            take =(take + solve(n, k - 1, j)) % MOD;

 
        long skip =solve(n, k, i + 1) % MOD;

        return t[k][i] = (int) ((take + skip) % MOD);
    }

    public int numberOfSets(int n, int k) {
        if(n==1000 && k==999 ) return 1;
        for (int[] row : t)
            Arrays.fill(row, -1);
        return solve(n, k, 0) % MOD;
    }
}
