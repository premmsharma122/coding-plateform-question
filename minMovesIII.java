class Solution {
    public int minMoves(int[] nums) {
        int max =0;
        for(int a : nums) max = Math.max(a,max);
        int c=0;
        for(int a : nums){
            c += Math.abs(max-a);
        }
        return c;
    }
}
