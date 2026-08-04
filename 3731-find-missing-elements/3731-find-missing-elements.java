class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min = Integer.MAX_VALUE, mx = Integer.MIN_VALUE;
        for(int a : nums){
            min=Math.min(min,a);
            mx= Math.max(mx,a);
        }
        Arrays.sort(nums);
        int idx=0;
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=min; i<=mx; i++){ 
            if(nums[idx]==i){
                idx++;
            }else ans.add(i);
        }
        return ans;
    }
}