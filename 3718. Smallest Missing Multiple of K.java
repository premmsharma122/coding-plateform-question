class Solution {
    public int missingMultiple(int[] nums, int k) {
        HashSet<Integer> hs = new HashSet<>();
        for(int a : nums){
            hs.add(a);
        }
        int c=k;
        while(hs.contains(c)){
            c=c+k;
        }
        return c;
    }
}
