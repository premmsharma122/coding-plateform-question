class Solution {
    public long minimalKSum(int[] nums, int k) {
        // HashSet<Integer> hs = new HashSet<>();
        // for (int v : nums) {
        //     hs.add(v);
        // }
        // long s = 0;        
        // int idx = 0;

        // for (int i = 1; idx < k; i++) {   
        //     if (!hs.contains(i)) {
        //         s += i;
        //         idx++;
        //     }
        // }

        // return s;
        Arrays.sort(nums);
    Set<Integer> set = new HashSet<>();
    long sum = 0;
    
    for (int num: nums) {
        if (!set.contains(num) && num <= k) {
            k++;
            sum += num;        
        }            
        set.add(num);
    }
    
    long res = (long)(1 + k) * k / 2 - sum;
    return res;        

    }
}
