class Solution {
    public int left_(int arr[], int trg, int n){
        int l=0, h=n;
        int left=-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]==trg){
                left= mid;
                h=mid-1;
            }else if(arr[mid] > trg){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return left;
    }
    public int right_(int arr[], int trg, int n){
        int l = 0, h=n;
        int right=-1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid]==trg){
                right = mid;
                l=mid+1;
            }else if(arr[mid]>trg){
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return right;
    }
    public int[] searchRange(int[] nums, int target) {
        int n =nums.length-1;
        int left = left_(nums,target,n);
        int right = right_(nums,target,n);
        return new int[]{left,right};
    }
}