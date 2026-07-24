class Solution {
    public int uniqueXorTriplets(int[] nums) {
        
       // if (nums.length <= 2) return nums.length;
        int MAX = 2048;
        boolean[] pair = new boolean[MAX];
        for (int a : nums) {
            for (int b : nums) {
                pair[a ^ b] = true;
            }
        }
        boolean[] ans = new boolean[MAX];
        for (int x = 0; x < MAX; x++) {
            if (!pair[x]) continue;
            for (int v : nums) {
                ans[x ^ v] = true;
            }
        }

        int count = 0;
        for (boolean b : ans) {
            if (b) count++;
        }

        return count;
    }
}