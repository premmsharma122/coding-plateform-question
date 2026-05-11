class Solution {
    public void help(int n, List<Integer> l){
        List<Integer> tm = new ArrayList<>();
        while(n>0){
            int r = n%10;
            tm.add(r);
            n=n/10;
        }
        for(int i=tm.size()-1; i>=0; i--){
            l.add(tm.get(i));
        }
    }
    public int[] separateDigits(int[] nums) {
        List<Integer> l = new ArrayList<>();
        for(int i=0; i<nums.length; i++){
            help(nums[i],l);
        }
        int ans[] = new int[l.size()];
        for(int i=0; i<l.size(); i++){
            ans[i]=l.get(i);
        }
        
        return ans;
    }
}