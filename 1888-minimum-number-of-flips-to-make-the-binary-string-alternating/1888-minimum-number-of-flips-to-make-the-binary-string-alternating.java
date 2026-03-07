// class Solution {

//     public boolean check(StringBuilder s){
//         for(int i=0;i<s.length()-1;i++){
//             if(s.charAt(i)==s.charAt(i+1)) return false;
//         }
//         return true;
//     }

//     public int help(StringBuilder s,int idx){
//         if(idx==s.length()){
//             if(check(s)) return 0;
//             return (int)1e9;
//         }

//         int ans = help(s,idx+1);

//         char original = s.charAt(idx);
//         s.setCharAt(idx, original=='0' ? '1':'0');

//         ans = Math.min(ans,1 + help(s,idx+1));

//         s.setCharAt(idx, original);

//         return ans;
//     }

//     public int minFlips(String s) {

//         StringBuilder sb = new StringBuilder(s);
//         int n = s.length();
//         int ans = Integer.MAX_VALUE;

//         for(int i=0;i<n;i++){

//             ans = Math.min(ans, help(sb,0));

//             char first = sb.charAt(0);
//             sb.deleteCharAt(0);
//             sb.append(first);
//         }

//         return ans;
//     }
// }
// Optimized -> still got tle - 49/65.💀
// class Solution {

//     public int flips(String s){
//         int c1 = 0, c2 = 0;

//         for(int i=0;i<s.length();i++){

//             char expected1 = (i%2==0)?'0':'1';
//             char expected2 = (i%2==0)?'1':'0';

//             if(s.charAt(i)!=expected1) c1++;
//             if(s.charAt(i)!=expected2) c2++;
//         }

//         return Math.min(c1,c2);
//     }

//     public int minFlips(String s) {

//         StringBuilder sb = new StringBuilder(s);
//         int n = s.length();
//         int ans = Integer.MAX_VALUE;

//         for(int i=0;i<n;i++){

//             ans = Math.min(ans, flips(sb.toString()));

//             char first = sb.charAt(0);
//             sb.deleteCharAt(0);
//             sb.append(first);
//         }

//         return ans;
//     }
// }
// helped..
class Solution {
    public int minFlips(String s) {

        int n = s.length();
        String t = s + s;

        int diff1 = 0;
        int diff2 = 0;
        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < 2*n; i++){

            char expected1 = (i % 2 == 0) ? '0' : '1';
            char expected2 = (i % 2 == 0) ? '1' : '0';

            if(t.charAt(i) != expected1) diff1++;
            if(t.charAt(i) != expected2) diff2++;

            if(i >= n){
                char prev1 = ((i-n) % 2 == 0) ? '0' : '1';
                char prev2 = ((i-n) % 2 == 0) ? '1' : '0';

                if(t.charAt(i-n) != prev1) diff1--;
                if(t.charAt(i-n) != prev2) diff2--;
            }

            if(i >= n-1){
                ans = Math.min(ans, Math.min(diff1, diff2));
            }
        }

        return ans;
    }
}