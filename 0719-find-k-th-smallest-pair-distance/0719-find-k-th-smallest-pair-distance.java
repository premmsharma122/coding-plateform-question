class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        int mx=0;
        for(int a : nums){
            mx= Math.max(mx,a);
        }
        int arr[] = new int[mx+1];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++){
                int d= Math.abs(nums[i]-nums[j]);
                arr[d]++;
            }
        }
        for(int i=0; i<mx+1; i++){
            k-=arr[i];
            if(k<=0) return i;
        }
        return -1;
    }
}