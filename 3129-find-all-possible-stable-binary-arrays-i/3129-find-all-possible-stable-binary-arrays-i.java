// this part (brute fore done by self)-
// class Solution {
//     private static int ans=0;
//     private static int MOD=1000000007;
//     //  static boolean check(List<Integer> arr, int limit){

//     //     int count = 1;

//     //     for(int i=1;i<arr.size();i++){

//     //         if(arr.get(i)==arr.get(i-1)){
//     //             count++;
//     //         }
//     //         else{
//     //             count=1;
//     //         }

//     //         if(count > limit){
//     //             return false;
//     //         }
//     //     }

//     //     return true;
//     // }

//     // public void help(int z, int o, int l, List<Integer> arr){
//     //     if(z==0 && o==0){
//     //         if(check(arr,l)){
//     //             ans=(ans+1)%m;
//     //         }
//     //         return;
//     //     }
//     //     if(z>0){
//     //         arr.add(0);
//     //         help(z-1,o,l,arr);
//     //         arr.remove(arr.size()-1);
//     //     }
//     //     if(o>0){
//     //         arr.add(1);
//     //         help(z,o-1,l,arr);
//     //         arr.remove(arr.size()-1);
//     //     }
//     // }
//      static void help(int zero, int one, int limit, int last, int count){

//         if(zero==0 && one==0){
//             ans = (ans + 1) % MOD;
//             return;
//         }

//         // try placing 0
//         if(zero > 0){
//             if(last == 0){
//                 if(count + 1 <= limit)
//                     help(zero-1, one, limit, 0, count+1);
//             }else{
//                 help(zero-1, one, limit, 0, 1);
//             }
//         }

//         // try placing 1
//         if(one > 0){
//             if(last == 1){
//                 if(count + 1 <= limit)
//                     help(zero, one-1, limit, 1, count+1);
//             }else{
//                 help(zero, one-1, limit, 1, 1);
//             }
//         }
//     }

//     public int numberOfStableArrays(int zero, int one, int limit) {
//         ans=0;
//         List<Integer> arr = new ArrayList<>();
//         help(zero, one, limit, -1, 0);
//         return ans;
//     }
// }

// helped ->

class Solution {

    public int numberOfStableArrays(int zero, int one, int limit) {
        int MOD = 1000000007;
        // dp[z][o][0] -> ways where last element is 0
        // dp[z][o][1] -> ways where last element is 1
        long[][][] dp = new long[zero + 1][one + 1][2];
        // base cases: only zeros
        for(int i = 1; i <= Math.min(zero, limit); i++) {
            dp[i][0][0] = 1;
        }
        // base cases: only ones
        for(int j = 1; j <= Math.min(one, limit); j++) {
            dp[0][j][1] = 1;
        }
        for(int z = 1; z <= zero; z++) {
            for(int o = 1; o <= one; o++) {
                // place 0 at the end
                dp[z][o][0] = (dp[z-1][o][0] + dp[z-1][o][1]) % MOD;

                if(z - limit - 1 >= 0) {
                    dp[z][o][0] = (dp[z][o][0] - dp[z-limit-1][o][1] + MOD) % MOD;
                }
                // place 1 at the end
                dp[z][o][1] = (dp[z][o-1][0] + dp[z][o-1][1]) % MOD;

                if(o - limit - 1 >= 0) {
                    dp[z][o][1] = (dp[z][o][1] - dp[z][o-limit-1][0] + MOD) % MOD;
                }
            }
        }
        return (int)((dp[zero][one][0] + dp[zero][one][1]) % MOD);
    }
}