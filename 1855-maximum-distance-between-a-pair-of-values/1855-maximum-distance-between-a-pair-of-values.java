class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {
        int i=0, j=0;
        int max = Integer.MIN_VALUE;
        while(i<nums1.length && j<nums2.length){
            if(nums1[i]<=nums2[j]){
                max = Math.max(max,j-i);
                
                j++;
            }else if(nums1[i]>nums2[j]){
                j++;
                i++;
            }
        }
        return max==Integer.MIN_VALUE?0:max;
    }
}