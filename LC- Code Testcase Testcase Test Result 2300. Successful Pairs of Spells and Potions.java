class Solution {
    public int help(int arr[], long trg){
        int l=0, r =arr.length;
        while(l<r){
            int mid = (l+r)/2;
            if(arr[mid] < trg) l=mid+1;
            else r=mid;
        }
        return l;
    }
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int ans[] = new int[spells.length];
        int n = spells.length;
        for(int i=0; i<n; i++){
            long min = (success+spells[i]-1)/spells[i];
            int idx = help(potions,min);
            ans[i] =  potions.length-idx;
        }
        return ans;

    }
}
