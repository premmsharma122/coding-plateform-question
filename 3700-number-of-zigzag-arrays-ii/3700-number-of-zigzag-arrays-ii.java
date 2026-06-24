// // class Solution {
// //     ArrayList<Integer> arr  = new ArrayList<>();
// //     public int help(int l, int r, int n){
// //         if(arr.size()==n){
// //             return 1;
// //         }
// //         int ans =0;
// //         boolean f= true;
// //         for(int i=l; i<=r; i++){
// //            arr.add(i);
// //            if(arr.size()>=3){
// //             int a = arr.get(arr.size()-3);
// //             int b = arr.get(arr.size()-2);
// //             int c = arr.get(arr.size()-1);
// //             f = (a < b && b > c) || (a > b && b < c);
// //            }
// //             if(f) {
// //                 ans += help(l,r,n);
// //             }
// //             arr.remove(arr.size()-1);
// //         }
// //         return ans;

// //     }
// //     public int zigZagArrays(int n, int l, int r) {
        
// //         arr.clear();
        
// //         return help(l,r,n);
// //     }
// // }
// class Solution {
//     int MOD = 1_000_000_007;

//     public int zigZagArrays(int n, int l, int r) {
//         int N = n;
//         int M = r - l + 1;

//         long[][][] t = new long[N + 1][M + 1][2];

//         //Base Case
//         for (int prevVal = 1; prevVal <= M; prevVal++) {
//             t[N][prevVal][0] = 1;
//             t[N][prevVal][1] = 1;
//         }

//         for (int i = N - 1; i >= 0; i--) {

//             long[] prefDir0 = new long[M + 1];
//             long[] prefDir1 = new long[M + 1];

//             for (int prevVal = 1; prevVal <= M; prevVal++) {
//                 prefDir0[prevVal] = (prefDir0[prevVal - 1] + t[i + 1][prevVal][0]) % MOD;
//                 prefDir1[prevVal] = (prefDir1[prevVal - 1] + t[i + 1][prevVal][1]) % MOD;
//             }

//             for (int prevVal = 1; prevVal <= M; prevVal++) {
//                 t[i][prevVal][1] = (prefDir0[M] - prefDir0[prevVal] + MOD) % MOD;
//                 t[i][prevVal][0] = prefDir1[prevVal - 1];
//             }
//         }

//         long result = 0;
//         for (int startVal = 1; startVal <= M; startVal++) {
//             //a < b > c < d ...
//             result = (result + t[1][startVal][1]) % MOD;
//             //a > b < c > d...
//             result = (result + t[1][startVal][0]) % MOD;
//         }
//         return (int) result;
//     }
// }

// Helped from solution ...
class Solution {
    static final long MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        long[] up = new long[m];
        for (int i = 0; i < m; i++) up[i] = i;

        long[][] T = new long[m][m];
        for (int i = 1; i < m; i++)
            for (int k = m - i; k < m; k++)
                T[i][k] = 1;

        long[][] Tn = matpow(T, n - 2, m);

        long ans = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < m; j++)
                ans = (ans + Tn[i][j] * up[j]) % MOD;

        return (int) (ans * 2 % MOD);
    }

    long[][] matmul(long[][] A, long[][] B, int sz) {
        long[][] C = new long[sz][sz];
        for (int i = 0; i < sz; i++)
            for (int k = 0; k < sz; k++) {
                if (A[i][k] == 0) continue;
                for (int j = 0; j < sz; j++)
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
            }
        return C;
    }

    long[][] matpow(long[][] M, int p, int sz) {
        long[][] res = new long[sz][sz];
        for (int i = 0; i < sz; i++) res[i][i] = 1;
        while (p > 0) {
            if ((p & 1) == 1) res = matmul(res, M, sz);
            M = matmul(M, M, sz);
            p >>= 1;
        }
        return res;
    }
}