class Solution {
    public int bs(int arr[][], int m){
        int l =0, r=arr.length-1,ans=0;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid][0]>m){
                r=mid-1;
            }else{
                ans =Math.max(ans,arr[mid][1]);
                l=mid+1;
            }
        }
        return ans;
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b)-> Integer.compare(a[0],b[0]));
        int res[] = new int[queries.length];
        int mx = items[0][1];
        for(int i=0; i<items.length; i++){
            mx = Math.max(mx,items[i][1]);
            items[i][1]=mx;
        }
        for(int i=0; i<queries.length; i++){
            int m = queries[i];
            int val =  bs(items,m);
            res[i] = val;
        }
        return res;
    }
}