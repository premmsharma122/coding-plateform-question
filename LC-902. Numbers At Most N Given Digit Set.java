// // Passed 70/84 ..
// class Solution {
//     int cnt = 0;

//     public void help(String[] digits, String curr, int n) {
//         if (!curr.equals("")) {
//             long val = Long.parseLong(curr);
//             if (val > n) return;
//             cnt++;
//         }
//         for (int i = 0; i < digits.length; i++) {
//             help(digits, curr + digits[i], n);
//         }
//     }

//     public int atMostNGivenDigitSet(String[] digits, int n) {
//         cnt = 0;
//         help(digits, "", n);
//         return cnt;
//     }
// }

// >>> Helped Count digit calculation by len logic from help ..(added) >>
class Solution {

    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int d = digits.length;
        int ans = 0;

        // 1️⃣ numbers with length < len(n)
        for (int l = 1; l < len; l++) {
            ans += Math.pow(d, l);
        }

        // 2️⃣ numbers with same length
        for (int i = 0; i < len; i++) {
            boolean same = false;
            for (String dig : digits) {
                if (dig.charAt(0) < s.charAt(i)) {
                    ans += Math.pow(d, len - i - 1);
                } else if (dig.charAt(0) == s.charAt(i)) {
                    same = true;
                }
            }
            if (!same) return ans;
        }

        // n itself counted
        return ans + 1;
    }
}
