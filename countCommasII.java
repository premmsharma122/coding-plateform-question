// class Solution {
//     public long countCommas(long n) {
//         if(n<1000) return 0;
//         if(n>=1000 && n<10000){
//             long three = n-1000;
//             return three+1;
//         }
//         if(n>=10000 && n<100000){
//             long three = 10000-1000;
//             long four  = n-10000;
//             return three +four+1;
//         }
//         if(n>=100000 && n<1000000){
//             long three = 10000-1000;
//             long four  = 100000-10000;
//             long five = n-100000;
//             return three+four+five+1;
//         }
//         return 0;
//     }
// }
// //10010
// //-80990 my
// //9011

class Solution {

    public long countCommas(long n) {

        long ans = 0;
        long start = 1000;
        long commas = 1;

        while (start <= n) {

            long end = start * 1000 - 1;

            if (end > n) {
                end = n;
            }

            ans += (end - start + 1) * commas;

            start *= 1000;
            commas++;
        }

        return ans;
    }
}
