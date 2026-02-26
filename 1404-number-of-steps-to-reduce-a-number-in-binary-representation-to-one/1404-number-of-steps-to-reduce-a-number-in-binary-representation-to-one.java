// class Solution {
//     public int numSteps(String s) {
//         long n = Long.parseLong(s,2);
//         int c=0;
//         while(n!=1){
//             if(n%2==1){
//                 n++;

//             }else{
//                 n=n/2;
//             }
//             c++;
//         }
//         return c;
//     }
// }
class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        for(int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if(bit == 1) {
                steps += 2; 
                carry = 1;
            } else {
                steps += 1;
            }
        }

        return steps + carry;
    }
}