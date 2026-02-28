// class Solution {
//     private int m = 100000007;
//     public int concatenatedBinary(int n) {
//         StringBuilder sb = new StringBuilder();
//         for(int i=1; i<=n; i++){
//             String bin = Integer.toBinaryString(i);
//             sb.append(bin);
//         }
//         long d  = Long.parseLong(sb.toString());
//         return (int) d%m;
//     }
// }
class Solution {
    public int concatenatedBinary(int n) {
        long res = 0;
        int MOD = 1000000007;
        int len = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0)
                len++;

            res = ((res << len) + i) % MOD;
        }

        return (int) res;
    }
}