class Solution {
    public int longestBalanced(int[] nums) {
        int m=0;
        for(int i=0; i<nums.length; i++){
            HashSet<Integer> ev = new HashSet<>();
            HashSet<Integer> od = new HashSet<>();
            for(int j=i; j<nums.length; j++){
                if(nums[j]%2!=0){
                    od.add(nums[j]);
                }else ev.add(nums[j]);
                if(od.size()==ev.size()){
                    m = Math.max(m, j-i+1);
                }
            }

        }
        return m;
    }
}