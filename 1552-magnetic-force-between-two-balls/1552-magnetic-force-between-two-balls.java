class Solution {
    public boolean help(int mid, int arr[], int m){
        int prev=arr[0];
        int c=1;
        for(int i=1; i<arr.length; i++){
            int cur= arr[i];
            if(cur-prev>=mid){
                c++;
                prev=cur;
            }
            if(c==m) break;
        }
        return (c==m);
    }
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int l=1,r=position[position.length-1]-position[0], ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(help(mid,position,m)){
                ans = mid;
                l=mid+1;
            }else r=mid-1;
        }
        return ans;
    }
}