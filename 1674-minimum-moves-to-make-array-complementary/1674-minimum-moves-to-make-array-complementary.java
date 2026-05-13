// class Solution {
//     public int minMoves(int[] nums, int limit) {
//         int ans =Integer.MAX_VALUE;
//         for(int s=1; s<=2*limit; s++){
//             int m =0;
//             for(int i=0; i<nums.length/2; i++){
//                 int a = nums[i];
//                 int b = nums[nums.length-1-i];
//                 if(a+b==s) continue;
//                 int min = Math.min(a,b)+1;
//                 int max = Math.max(a,b)+limit;
//                 if(min <= s && s<=max){
//                     m+=1;
//                 }else {
//                     m+=2;
//                 }
//             }
//             ans =Math.min(ans,m);
//         }
//         return ans;
//     }
// } 

class Solution {
    public int minMoves(int[] nums, int limit) {
        
        int n = nums.length;

        int[] diff = new int[2 * limit + 2];

        for(int i = 0; i < n/2; i++) {

            int a = nums[i];
            int b = nums[n-1-i];

            int minVal = Math.min(a, b) + 1;
            int maxVal = Math.max(a, b) + limit;

            diff[2] += 2;
            diff[2*limit+1] -= 2;

            //for moves = 1
            diff[minVal]   += (-1);
            diff[maxVal+1] -= (-1);

            //for moves = 0 [a+b, a+b]
            diff[a+b]   += (-1);
            diff[a+b+1] -= (-1);
        }

        int result = Integer.MAX_VALUE;

        for(int sum = 2; sum <= 2*limit; sum++) {
            diff[sum] += diff[sum-1];

            result = Math.min(result, diff[sum]);
        }

        return result;
    }
}