class Solution {
    public boolean help(int nums[], int mid, int op){
        long tot=0;
        for(int a :nums){
            long c = a/mid;
            if(a%mid==0){
                c-=1;
            }
            tot+=c;
        }
        if(tot>op) return false;
        return true;

    }
    public int minimumSize(int[] nums, int maxOperations) {
        Arrays.sort(nums);
        int mx=0;
        for(int a : nums){
            mx=Math.max(mx,a);
        }
        int l=1, r=mx, res=0;
        while(l<=r){
            int mid =l+(r-l)/2;
            if(help(nums,mid,maxOperations)){
                res=mid;
                r=mid-1;
            }else{
                l=mid+1;
            }
        }
        return res;
    }
}