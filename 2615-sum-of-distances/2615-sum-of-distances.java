class Solution {
    public long[] distance(int[] nums) {
        long ans[] = new long[nums.length];
        // for(int i=0; i<nums.length; i++){
        //     long s=0;
        //     for(int j=0; j<nums.length; j++){
        //         if(nums[i]==nums[j]){
        //             s+=Math.abs(i-j);
        //         }
        //     }
        //     ans[i]=s;
        // }
        // return ans;
        // optimize - 
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        int n = nums.length;
        // Step 1: store indices
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        // Step 2: process each group
        for (ArrayList<Integer> list : map.values()) {
            int size = list.size();

            long prefixSum = 0;

            // Left side contribution
            for (int i = 0; i < size; i++) {
                int index = list.get(i);
                ans[index] += (long) i * index - prefixSum;
                prefixSum += index;
            }

            // Right side contribution
            prefixSum = 0;
            for (int i = size - 1; i >= 0; i--) {
                int index = list.get(i);
                ans[index] += prefixSum - (long) (size - 1 - i) * index;
                prefixSum += index;
            }
        }

        return ans;
    }
}
