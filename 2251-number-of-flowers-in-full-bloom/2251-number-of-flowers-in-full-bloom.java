class Solution {
    public int upperB(int arr[], int trg){
        int l=0, r=arr.length-1;
        int ans =-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]>trg){
                ans = mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
         return ans == -1 ? arr.length : ans;
    }
     public int lowB(int arr[], int trg){
        int l=0, r=arr.length-1;
        int ans =-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(arr[mid]<trg){
                l=mid+1;
            }else{
                ans = mid;
                r=mid-1;
            }
        }
         return ans == -1 ? arr.length : ans;
    }
    public int[] fullBloomFlowers(int[][] flowers, int[] people) {
        int st[] = new int[flowers.length];
        int end[] = new int[flowers.length];
        for(int i=0; i<flowers.length; i++){
            st[i] = flowers[i][0];
            end[i] = flowers[i][1];
        }
        Arrays.sort(st);
        Arrays.sort(end);
        int res[] = new int[people.length];
        for(int i=0; i<people.length; i++){
            int cur = people[i];
            int upper = upperB(st,cur);
            int low = lowB(end,cur);
            res[i] = upper-low;
        }
        return res;
    }
}