class Solution {
    public int minimumDistance(int[] nums) {
        HashMap<Integer, List<Integer>> hm = new HashMap<>();

        for(int i = 0; i < nums.length; i++){
            hm.putIfAbsent(nums[i], new ArrayList<>());
            hm.get(nums[i]).add(i);
        }

        int ans = Integer.MAX_VALUE;

        for(List<Integer> a : hm.values()){
            if(a.size() >= 3){
                for(int i = 0; i <= a.size() - 3; i++){
                    int x = Math.abs(a.get(i) - a.get(i+1));
                    int y = Math.abs(a.get(i+1) - a.get(i+2));
                    int z = Math.abs(a.get(i) - a.get(i+2));

                    ans = Math.min(ans, x + y + z);
                }
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}