class Solution {
    public boolean help(int m, int arr[],int p){
        int i=0, c=0;
        while(i<arr.length-1){
            if(arr[i+1]-arr[i]<=m){
                c++;
                i+=2;
            }else i++;
        }
        return c>=p;
    }
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);
        int l=0, r=nums[nums.length-1]-nums[0], ans =0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(help(mid, nums,p)){
                ans = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}