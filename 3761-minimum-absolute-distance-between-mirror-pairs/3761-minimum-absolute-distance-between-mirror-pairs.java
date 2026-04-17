class Solution {
    public static int help(int n) {
        String s = String.valueOf(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return Integer.parseInt(sb.toString());
    }
     public int minMirrorPairDistance(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                min = Math.min(min, i - hm.get(nums[i]));
            }

            int rev = help(nums[i]);
            hm.put(rev, i);
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }
}