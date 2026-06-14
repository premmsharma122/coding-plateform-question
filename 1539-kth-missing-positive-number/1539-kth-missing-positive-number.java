class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n=1;
        int l=0, h=arr.length;
        while(l<h && k>0){
            
            if(arr[l]==n){
                l++;
            }else{
                k--;
            }
            n++;
        }
        while(k-->0){
            n++;
        }
        return n-1;
    }
}