class Solution {
    public int minimumDistance(int[] nums) {
        int min=Integer.MAX_VALUE;
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i]==nums[j]){
                    for(int k=j+1; k<nums.length; k++){
                        if(nums[j]==nums[k]){
                            int x= Math.abs(i-j);
                            int y = Math.abs(j-k);
                            int z = Math.abs(k-i);
                            min = Math.min(min,(x+y+z));
                        }
                    }
                }
            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
}