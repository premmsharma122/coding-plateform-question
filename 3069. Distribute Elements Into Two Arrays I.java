class Solution {
    public int[] resultArray(int[] nums) {
        int ans[] = new int[nums.length];
        ArrayList<Integer> f1 = new ArrayList<>();
        ArrayList<Integer> f2 = new ArrayList<>();
        if(nums.length>2){
            f1.add(nums[0]);
            f2.add(nums[1]);
        }
        for(int i=2; i<nums.length; i++){
            if(f1.get(f1.size()-1) > f2.get(f2.size()-1)){
                f1.add(nums[i]);
            }else f2.add(nums[i]);

        }
        int i=0;
        for(int a : f1){
            ans[i++]=a;
        }
        for(int a : f2){
            ans[i++]=a;
        }
        return ans;
    }
}
