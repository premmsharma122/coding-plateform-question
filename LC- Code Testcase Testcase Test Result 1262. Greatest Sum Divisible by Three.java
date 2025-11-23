// class Solution {
//     // private static int m = 0;

//     // public void help(int arr[], int idx, int curr){
//     //     if(idx == arr.length){                 // FIXED base condition
//     //         if(curr % 3 == 0){
//     //             m = Math.max(m, curr);        // this was correct
//     //         }
//     //         return;
//     //     }

//     //     help(arr, idx+1, curr + arr[idx]);     // take
//     //     help(arr, idx+1, curr);                // skip
//     // }

//     public int maxSumDivThree(int[] nums) {
//         // m = 0;
//         // if(nums.length == 1){
//         //     if(nums[0] % 3!=0) return 0;
//         // };
//         // help(nums, 0, 0);
//         // return m;
        
//         }
//     }
// }
class Solution {
    public int maxSumDivThree(int[] nums) {
        int sum = 0;
        ArrayList<Integer> r1 = new ArrayList<>();
        ArrayList<Integer> r2 = new ArrayList<>();
        
        for (int x : nums) {
            sum += x;
            if (x % 3 == 1) r1.add(x);
            else if (x % 3 == 2) r2.add(x);
        }
        
        if (sum % 3 == 0) return sum;
        
        Collections.sort(r1);
        Collections.sort(r2);
        
        int rem = sum % 3;
        int ans = 0;
        
        if (rem == 1) {
            int op1 = (r1.size() >= 1) ? sum - r1.get(0) : 0;
            int op2 = (r2.size() >= 2) ? sum - r2.get(0) - r2.get(1) : 0;
            ans = Math.max(op1, op2);
        } else { // rem == 2
            int op1 = (r2.size() >= 1) ? sum - r2.get(0) : 0;
            int op2 = (r1.size() >= 2) ? sum - r1.get(0) - r1.get(1) : 0;
            ans = Math.max(op1, op2);
        }
        
        return ans;
    }
}
