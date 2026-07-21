class Solution {
    public int lengthOfLIS(int[] nums) {
        int arr[] = new int[nums.length];
        Arrays.fill(arr,1);

        int max =1;
        for(int i=1;i<nums.length; i++){
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    arr[i] = Math.max(arr[i] , arr[j]+1);
                }
            }
        max = Math.max(max, arr[i]);
        }
        
        return max;
    }
}