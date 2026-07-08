class Solution {
    public int lowerBound(int[] nums, int target) {
    int l = 0, r = nums.length;

    while (l < r) {
        int mid = l + (r - l) / 2;

        if (nums[mid] >= target) {
            r = mid;
        } else {
            l = mid + 1;
        }
    }

    return l;
}
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int l=0, r=nums.length;
        while(l<=r){
            int mid  = l+(r-l)/2;
            int idx = lowerBound(nums,mid);
            int c=nums.length-idx;
            if(c==mid){
                return mid;
            }else if(c>mid){
                l=mid+1;
            }else r=mid-1;
        }
        return -1;
    }
}