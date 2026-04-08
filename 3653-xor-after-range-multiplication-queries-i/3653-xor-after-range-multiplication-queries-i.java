class Solution {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        int mod= 1000000007;
        for(int a[] : queries){
            int l=a[0];
            int r = a[1];
            int k=a[2];
            int v=a[3];
            for(int i=l;  i<=r; i+=k){
                nums[i] = (int)(((long)nums[i] * v) % mod);
            }
        }
        int ans=nums[0];
        for(int i=1; i<nums.length; i++){
            ans =ans ^ nums[i];
        }
        return ans;
    }
}