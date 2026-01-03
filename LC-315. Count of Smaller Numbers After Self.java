// class Solution {
//     public List<Integer> countSmaller(int[] nums) {
//         List<Integer> arr  = new ArrayList<>();
//         for(int i=0; i<nums.length; i++){
//             boolean f = false;
//             int c=0;
//             for(int j=i; j<nums.length; j++){
//                 if(nums[i]>nums[j]){
//                     c++;
//                 }
//             }
//             if(!f) arr.add(c);
//         }
//         return arr;
//     }
// }

// Optimized approach ->
class Solution {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            int idx = lowerBound(sorted, nums[i]);
            res.add(idx);
            sorted.add(idx, nums[i]);
        }

        Collections.reverse(res);
        return res;
    }

    private int lowerBound(List<Integer> list, int target) {
        int l = 0, r = list.size();
        while (l < r) {
            int m = (l + r) / 2;
            if (list.get(m) < target) l = m + 1;
            else r = m;
        }
        return l;
    }
}
