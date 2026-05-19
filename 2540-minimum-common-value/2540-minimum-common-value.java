class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0, j=0;
        int ans = Integer.MAX_VALUE;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]==nums2[j]){
                ans = Math.min(nums1[i],Math.min(nums2[j],ans));
                i++;
                j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }else j++;
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
}