// // // class Solution {
// // //     // public int help(int n , int l, int r){
// // //     //     if(arr.size()==n) return 1;
// // //     //     if(arr.get(arr.size()-1)>)
// // //     // }
// // //     public int zigZagArrays(int n, int l, int r) {
// // //         // int c=0;
// // //         // for(int i=l; i<=r; i++){ // 4-> 5 
// // //         //     int a = i, b=i+1;
// // //         //     for(int j=l; j<=r; j++){
// // //         //         if ((a<b && b>j) || (a>b && b<j)){

// // //         //             c++;
// // //         //         }
// // //         //     }
// // //         // }
// // //         // return c;
        
// // //     }
// // // }
// // class Solution {

// //     ArrayList<Integer> arr = new ArrayList<>();
// //     int memo[];
// //     public int help(int n, int l, int r) {

// //         if (arr.size() == n) {
// //             return 1;
// //         }

// //         int ans = 0;

// //         for (int num = l; num <= r; num++) {

// //             arr.add(num);

// //             boolean valid = true;

// //             if (arr.size() >= 3) {

// //                 int m = arr.size();

// //                 int a = arr.get(m - 3);
// //                 int b = arr.get(m - 2);
// //                 int c = arr.get(m - 1);

// //                 valid = (a < b && b > c) ||
// //                         (a > b && b < c);
// //             }

// //             if (valid) {
// //                 ans += help(n, l, r);
// //             }

// //             arr.remove(arr.size() - 1);
// //         }

// //         return ans;
// //     }

// //     public int zigZagArrays(int n, int l, int r) {
// //         arr.clear();
// //         return help(n, l, r);
// //     }
// // }
// class Solution {

//     int MOD = 1000000007;
//     Integer[][][] dp;
//     int l, r, n;

//     public int help(int pos, int prev, int dir) {

//         if (pos == n) {
//             return 1;
//         }

//         if (dp[pos][prev - l][dir] != null) {
//             return dp[pos][prev - l][dir];
//         }

//         long ans = 0;

//         for (int next = l; next <= r; next++) {

//             if (dir == 0) { // last relation was <
//                 if (prev > next) {
//                     ans += help(pos + 1, next, 1);
//                 }
//             } else { // last relation was >
//                 if (prev < next) {
//                     ans += help(pos + 1, next, 0);
//                 }
//             }

//             ans %= MOD;
//         }

//         return dp[pos][prev - l][dir] = (int) ans;
//     }

//     public int zigZagArrays(int n, int l, int r) {

//         this.n = n;
//         this.l = l;
//         this.r = r;

//         if (n == 1) {
//             return r - l + 1;
//         }

//         dp = new Integer[n + 1][r - l + 1][2];

//         long ans = 0;

//         for (int first = l; first <= r; first++) {

//             for (int second = l; second <= r; second++) {

//                 if (first < second) {
//                     ans += help(2, second, 0);
//                 }
//                 else if (first > second) {
//                     ans += help(2, second, 1);
//                 }

//                 ans %= MOD;
//             }
//         }

//         return (int) ans;
//     }
// }


// Helped from solution..
class Solution {
    int MOD = 1000000007;

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        long[][] less = new long[n + 1][m];
        long[][] greater = new long[n + 1][m];

        // length = 2
        for (int a = 0; a < m; a++) {
            for (int b = 0; b < m; b++) {

                if (a < b) {
                    less[2][b]++;
                } else if (a > b) {
                    greater[2][b]++;
                }
            }
        }

        for (int len = 3; len <= n; len++) {

            long[] prefLess = new long[m];
            long[] prefGreater = new long[m];

            prefLess[0] = less[len - 1][0];
            prefGreater[0] = greater[len - 1][0];

            for (int i = 1; i < m; i++) {
                prefLess[i] = (prefLess[i - 1] + less[len - 1][i]) % MOD;
                prefGreater[i] = (prefGreater[i - 1] + greater[len - 1][i]) % MOD;
            }

            for (int v = 0; v < m; v++) {

                // last relation becomes <
                long smaller = (v > 0) ? prefGreater[v - 1] : 0;
                less[len][v] = smaller;

                // last relation becomes >
                long bigger =
                        (prefLess[m - 1] - prefLess[v] + MOD) % MOD;
                greater[len][v] = bigger;
            }
        }

        long ans = 0;

        for (int v = 0; v < m; v++) {
            ans = (ans + less[n][v] + greater[n][v]) % MOD;
        }

        return (int) ans;
    }
}